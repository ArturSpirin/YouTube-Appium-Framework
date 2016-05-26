package api.apps.speedtest.home;

import api.android.Android;
import api.interfaces.Activity;
import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Artur on 5/25/2016.
 */
public class Home implements Activity {

    public HomeUiObjects uiObject = new HomeUiObjects();

    public String getPingSpeed(){
        try{
            MyLogger.log.info("Getting Ping Speed");
            return uiObject.pingSpeed().getText();
        }catch (NoSuchElementException e){
            throw new AssertionError("Cant get Ping Speed, element absent or blocked");
        }
    }

    public String getDownloadSpeed(){
        try{
            MyLogger.log.info("Getting Download Speed");
            return uiObject.downloadSpeed().getText();
        }catch (NoSuchElementException e){
            throw new AssertionError("Cant get Download Speed, element absent or blocked");
        }
    }

    public String getUploadSpeed(){
        try{
            MyLogger.log.info("Getting Upload Speed");
            return uiObject.uploadSpeed().getText();
        }catch (NoSuchElementException e){
            throw new AssertionError("Cant get Upload Speed, element absent or blocked");
        }
    }

    public Home tapTestAgain(){
        try{
            MyLogger.log.info("Tapping Test Again button");
            uiObject.testAgainButton().tap().waitToDisappear(5).waitToAppear(120);
            return Android.app.speedtest.home;
        }catch (NoSuchElementException e){
            throw new AssertionError("Cant tap Test Again button, element absent or blocked");
        }
    }

    @Override
    public Home waitToLoad() {
        try{
            MyLogger.log.info("Waiting for Home activity");
            uiObject.testAgainButton().waitToAppear(10);
            return Android.app.speedtest.home;
        }catch (AssertionError e){
            throw new AssertionError("Home activity failed to load/open");
        }
    }
}
