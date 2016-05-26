package api.apps.speedtest.begintest;

import api.android.Android;
import api.apps.speedtest.home.Home;
import api.interfaces.Activity;
import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Artur on 5/25/2016.
 */
public class BeginTest implements Activity{

    public BeginTestUiObjects uiObject = new BeginTestUiObjects();

    public Home tapBeginTest(){
        try{
            MyLogger.log.info("Tapping Begin Test Button");
            uiObject.beginTestButton().tap();
            Android.app.speedtest.home.uiObject.testAgainButton().waitToAppear(120);
            return Android.app.speedtest.home;
        }catch (NoSuchElementException e){
            throw new AssertionError("Cant tap Begin Test button, element absent or blocked");
        }catch (AssertionError e){
            throw new AssertionError("Speedtest failed to complete within 120 seconds");
        }
    }

    @Override
    public BeginTest waitToLoad() {
        try{
            MyLogger.log.info("Waiting for Begin Test activity");
            uiObject.beginTestButton().waitToAppear(10);
            return Android.app.speedtest.beginTest;
        }catch (AssertionError e){
            throw new AssertionError("Begin Test activity failed to load/open");
        }
    }
}
