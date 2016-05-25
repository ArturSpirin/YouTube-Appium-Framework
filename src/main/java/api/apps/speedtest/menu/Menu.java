package api.apps.speedtest.menu;

import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Artur on 5/25/2016.
 */
public class Menu {

    public MenuUiObjects uiObject = new MenuUiObjects();

    public void tapSpeedtest(){
        try{
            MyLogger.log.info("Tapping on the Speedtest Menu Button");
            uiObject.speedtest().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Cant tap Speedtest Button, element absent or blocked");
        }
    }

    public void tapResults(){
        try{
            MyLogger.log.info("Tapping on the Results Menu Button");
            uiObject.resutls().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Cant tap Results Button, element absent or blocked");
        }
    }

    public void tapSettings(){
        try{
            MyLogger.log.info("Tapping on the Settings Menu Button");
            uiObject.settings().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Cant tap Settings Button, element absent or blocked");
        }
    }

    public void tapAbout(){
        try{
            MyLogger.log.info("Tapping on the About Menu Button");
            uiObject.about().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Cant tap About Button, element absent or blocked");
        }
    }
}
