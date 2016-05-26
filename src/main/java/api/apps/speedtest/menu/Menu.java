package api.apps.speedtest.menu;

import api.android.Android;
import api.apps.speedtest.about.About;
import api.apps.speedtest.home.Home;
import api.apps.speedtest.results.Results;
import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Artur on 5/25/2016.
 */
public class Menu {

    public MenuUiObjects uiObject = new MenuUiObjects();

    public Home tapSpeedtest(){
        try{
            MyLogger.log.info("Tapping on the Speedtest Menu Button");
            uiObject.speedtest().tap();
            return Android.app.speedtest.home.waitToLoad();
        }catch (NoSuchElementException e){
            throw new AssertionError("Cant tap Speedtest Button, element absent or blocked");
        }
    }

    public Results tapResults(){
        try{
            MyLogger.log.info("Tapping on the Results Menu Button");
            uiObject.resutls().tap();
            return Android.app.speedtest.results.waitToLoad();
        }catch (NoSuchElementException e){
            throw new AssertionError("Cant tap Results Button, element absent or blocked");
        }
    }

    //Todo return settings
    public void tapSettings(){
        try{
            MyLogger.log.info("Tapping on the Settings Menu Button");
            uiObject.settings().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Cant tap Settings Button, element absent or blocked");
        }
    }

    //Todo return about
    public About tapAbout(){
        try{
            MyLogger.log.info("Tapping on the About Menu Button");
            uiObject.about().tap();
            return Android.app.speedtest.about.waitToLoad();
        }catch (NoSuchElementException e){
            throw new AssertionError("Cant tap About Button, element absent or blocked");
        }
    }
}
