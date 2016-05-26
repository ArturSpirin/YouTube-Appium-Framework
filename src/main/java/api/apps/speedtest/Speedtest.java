package api.apps.speedtest;

import api.android.Android;
import api.apps.speedtest.about.About;
import api.apps.speedtest.begintest.BeginTest;
import api.apps.speedtest.home.Home;
import api.apps.speedtest.menu.Menu;
import api.apps.speedtest.results.Results;
import api.interfaces.Application;

/**
 * Created by Artur on 5/25/2016.
 */
public class Speedtest implements Application {

    public Menu menu = new Menu();
    public Home home = new Home();
    public About about = new About();
    public BeginTest beginTest = new BeginTest();
    public Results results = new Results();

    @Override
    public void forceStop() {
        Android.adb.forceStopApp(packageID());
    }

    @Override
    public void clearData() {
        Android.adb.clearAppsData(packageID());
    }

    @Override
    public Object open() {
        Android.adb.openAppsActivity(packageID(), activityID());
        return null;
    }

    @Override
    public String packageID() {
        return "org.zwanoo.android.speedtest";
    }

    @Override
    public String activityID() {
        return "com.ookla.speedtest.softfacade.MainActivity";
    }
}
