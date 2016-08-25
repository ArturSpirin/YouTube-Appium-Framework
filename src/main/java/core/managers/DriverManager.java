package core.managers;

import api.android.Android;
import core.ADB;
import core.MyLogger;

import core.Timer;
import core.constants.Arg;
import core.constants.Resources;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Artur on 4/13/2016.
 */
public class DriverManager {

    private static String nodeJS = System.getenv("APPIUM_HOME")+"/node.exe";
    private static String appiumJS = System.getenv("APPIUM_HOME")+"/node_modules/appium/bin/appium.js";
    private static DriverService service;
    private static String deviceID;

    private static HashMap<String, URL> hosts;
    private static String unlockPackage = "io.appium.unlock";

    private static DesiredCapabilities getCaps(String deviceID){
        MyLogger.log.info("Creating driver caps for device: "+deviceID);
        DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", deviceID);
            caps.setCapability("platformName", "Android");
            caps.setCapability("app", "C:/Appium/node_modules/appium/build/unlock_apk/unlock_apk-debug.apk");
        return caps;
    }

    private static URL host(String deviceID) throws MalformedURLException {
        if(hosts == null){
            hosts = new HashMap<String, URL>();
            hosts.put("ZX1G324LHF", new URL("http://127.0.0.1:4723/wd/hub"));
        }return hosts.get(deviceID);
    }

    private static ArrayList<String> getAvailableDevices(){
        MyLogger.log.info("Checking for available devices");
        ArrayList<String> avaiableDevices = new ArrayList<String>();
        ArrayList connectedDevices = ADB.getConnectedDevices();
        for(Object connectedDevice: connectedDevices){
            String device = connectedDevice.toString();
            ArrayList apps = new ADB(device).getInstalledPackages();
            if(!apps.contains(unlockPackage)){
                if(useDevice(deviceID)) avaiableDevices.add(device);
                else MyLogger.log.info("Device: "+deviceID+" is being used by another JVM");
            }
            else MyLogger.log.info("Device: "+device+" has "+unlockPackage+" installed, assuming it is under testing");
        }
        if(avaiableDevices.size() == 0) throw new RuntimeException("Not a single device is available for testing at this time");
        return avaiableDevices;
    }

    private static DriverService createService() throws MalformedURLException {
        service = new AppiumServiceBuilder()
                .usingDriverExecutable(new File(nodeJS))
                .withAppiumJS(new File(appiumJS))
                .withIPAddress(host(deviceID).toString().split(":")[1].replace("//", ""))
                .usingPort(Integer.parseInt(host(deviceID).toString().split(":")[2].replace("/wd/hub","")))
                .withArgument(Arg.TIMEOUT, "120")
                .withArgument(Arg.LOG_LEVEL, "warn")
                .build();
        return service;
    }

    public static void createDriver() throws MalformedURLException {
        ArrayList<String> devices = getAvailableDevices();
        for(String device : devices){
            try{
                deviceID = device;
                if(useDevice(deviceID)){
                    queueUp();
                    gracePeriod();
                    MyLogger.log.info("Trying to create new Driver for device: "+device);
                    createService().start();
                    Android.driver = new AndroidDriver(host(device), getCaps(device));
                    Android.adb = new ADB(device);
                    leaveQueue();
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
                //Ignore and try next device
            }
        }
    }

    public static void killDriver(){
        if(Android.driver != null){
            MyLogger.log.info("Killing Android Driver");
            Android.driver.quit();
            Android.adb.uninstallApp(unlockPackage);
            service.stop();
        }else MyLogger.log.info("Android Driver is not initialized, nothing to kill");
    }

    private static void queueUp() {
        try {
            MyLogger.log.info("Queueing Up: "+deviceID);
            JSONObject json = new JSONObject();
                json.put("queued_at", Timer.getTimeStamp());
            JSONObject jsonQueue = Resources.getQueue();
                jsonQueue.put(deviceID, json);
            MyLogger.log.info("JSON Queue: "+jsonQueue);
            ServerManager.write(new File(Resources.QUEUE), jsonQueue.toString());
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean useDevice(String deviceID) {
        try {
            JSONObject  json = Resources.getQueue();
            if(json.containsKey(deviceID)){
                JSONObject deviceJson = (JSONObject) json.get(deviceID);
                long time = (long) deviceJson.get("queued_at");
                int diff = Timer.getDifference(time, Timer.getTimeStamp());
                if(diff >= 30) return true;
                else return false;
            } else return true;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static void gracePeriod(){
        int waitTime = 0;
        try {
            JSONObject  json = Resources.getQueue();
            Set keys = json.keySet();

            JSONObject ourDeviceJson = (JSONObject) json.get(deviceID);
            json.remove(deviceID);
            long weQueuedAt = (long) ourDeviceJson.get("queued_at");

            for(Object key : keys){
                JSONObject deviceJson = (JSONObject) json.get(key);
                long theyQueuedAt = (long) deviceJson.get("queued_at");
                //If we did not queue first we need to wait for the other device to initialize driver so there is no collision
                if(weQueuedAt > theyQueuedAt) {
                    //But only if device queued first and recently, otherwise we can assume device was already initialized or no longer being used
                    int diff = Timer.getDifference(theyQueuedAt, Timer.getTimeStamp());
                    if(diff < 50){
                        MyLogger.log.info("Device: "+key+" queued first, I will need to give it extra time to initialize");
                        waitTime += 15;
                    }
                }
            }
            try {Thread.sleep(waitTime);} catch (InterruptedException e) {e.printStackTrace();}
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leaveQueue(){
        try {
            JSONObject jsonQueue = Resources.getQueue();
            jsonQueue.remove(deviceID);
            ServerManager.write(new File(Resources.QUEUE), jsonQueue.toString());
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
