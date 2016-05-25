import api.android.Android;
import core.MyLogger;
import core.UiObject;
import core.UiSelector;
import core.managers.DriverManager;
import org.apache.log4j.Level;

import java.net.MalformedURLException;

/**
 * Created by Artur on 3/23/2016.
 */
public class Runner {
//org.zwanoo.android.speedtest
//com.ookla.speedtest.softfacade.MainActivity
    public static void main(String[] args) throws MalformedURLException {

        MyLogger.log.setLevel(Level.INFO);
        try{
            DriverManager.createDriver();
            Android.adb.openAppsActivity("org.zwanoo.android.speedtest", "com.ookla.speedtest.softfacade.MainActivity");

            UiObject testAgainButton = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/o2_button_button").makeUiObject();
            UiObject ping = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/pingSpeed").makeUiObject();
            UiObject download = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/downloadSpeed").makeUiObject();
            UiObject upload = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/uploadSpeed").makeUiObject();

            testAgainButton.waitToAppear(5).tap().waitToDisappear(5).waitToAppear(120);

            MyLogger.log.info("Ping: "+ping.getText());
            MyLogger.log.info("Download: "+download.getText());
            MyLogger.log.info("Upload: "+upload.getText());
        }finally {
            DriverManager.killDriver();
        }
    }
}
