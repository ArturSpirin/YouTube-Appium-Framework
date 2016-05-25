package api.apps.speedtest;

import api.android.Android;
import api.interfaces.Application;

/**
 * Created by Artur on 5/25/2016.
 */
public class Speedtest implements Application {

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
