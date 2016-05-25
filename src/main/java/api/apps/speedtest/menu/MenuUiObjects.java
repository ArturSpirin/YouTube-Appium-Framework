package api.apps.speedtest.menu;

import core.UiObject;
import core.UiSelector;

/**
 * Created by Artur on 5/25/2016.
 */
public class MenuUiObjects {

    private static UiObject
            speedtest,
            resutls,
            settings,
            about;

    public UiObject speedtest(){
        if(speedtest == null) speedtest = new UiSelector().text("SPEEDTEST").makeUiObject();
        return speedtest;
    }

    public UiObject resutls(){
        if(resutls == null) resutls = new UiSelector().text("RESULTS").makeUiObject();
        return resutls;
    }

    public UiObject settings(){
        if(settings == null) settings = new UiSelector().text("SETTINGS").makeUiObject();
        return settings;
    }

    public UiObject about(){
        if(about == null) about = new UiSelector().text("ABOUT").makeUiObject();
        return about;
    }
}
