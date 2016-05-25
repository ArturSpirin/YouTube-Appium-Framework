package core;

import api.android.Android;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

/**
 * Created by Artur on 4/13/2016.
 */
public class UiObject {

    private String locator;

    UiObject(String locator){
        this.locator = locator;
        MyLogger.log.debug("Created new UiObject: "+this.locator);
    }

    private boolean isXpath(){
        return !locator.contains("UiSelector");
    }

    public boolean exists(){
        try{
            WebElement element;
            if(isXpath()) element = Android.driver.findElementByXPath(locator);
            else element = Android.driver.findElementByAndroidUIAutomator(locator);
            return element.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean isChecked(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("checked").equals("true");
    }

    public boolean isCheckable(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("checkable").equals("true");
    }

    public boolean isClickable(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("clickable").equals("true");
    }

    public boolean isEnabled(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("enabled").equals("true");
    }

    public boolean isFocusable(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("focusable").equals("true");
    }

    public boolean isFocused(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("focused").equals("true");
    }

    public boolean isScrollable(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("scrollable").equals("true");
    }

    public boolean isLongClickable(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("longClickable").equals("true");
    }

    public boolean isSelected(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("selected").equals("true");
    }

    public Point getLocation(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getLocation();
    }

    public String getText(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("name");
    }

    public String getResourceId(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("resourceId");
    }

    public String getClassName(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("className");
    }

    public String getContentDesc(){
        WebElement element;
        if(isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("contentDesc");
    }

    public UiObject clearText(){
        if(isXpath()) Android.driver.findElementByXPath(locator).clear();
        else  Android.driver.findElementByAndroidUIAutomator(locator).clear();
        return this;
    }

    public UiObject typeText(String value){
        if(isXpath()) Android.driver.findElementByXPath(locator).sendKeys(value);
        else  Android.driver.findElementByAndroidUIAutomator(locator).sendKeys(value);
        return this;
    }

    public UiObject tap(){
        if(isXpath()) Android.driver.findElementByXPath(locator).click();
        else  Android.driver.findElementByAndroidUIAutomator(locator).click();
        return this;
    }

    public UiObject scrollTo(){
        if(!locator.contains("text")) throw new RuntimeException("Scroll to method can only be used with text attributes and current locator: "+locator+" does not contain any text attributes!");
        if(isXpath()) Android.driver.scrollTo(locator.substring(locator.indexOf("@text=\""), locator.indexOf("\"]")).replace("@text=\"", ""));
        else{
            String text;
            if(locator.contains("textContains")) text = locator.substring(locator.indexOf(".textContains(\""), locator.indexOf("\")")).replace(".textContains(\"", "");
            else text = locator.substring(locator.indexOf(".text(\""), locator.indexOf("\")")).replace(".text(\"", "");
            Android.driver.scrollTo(text);
        }
        return this;
    }

    public UiObject waitToAppear(int seconds){
        Timer timer = new Timer();
        timer.start();
        while(!timer.expired(seconds)) if(exists()) break;
        if(timer.expired(seconds) && !exists()) throw new AssertionError("Element "+locator+" failed to appear within "+seconds+" seconds");
        return this;
    }

    public UiObject waitToDisappear(int seconds){
        Timer timer = new Timer();
        timer.start();
        while(!timer.expired(seconds)) if(!exists()) break;
        if(timer.expired(seconds) && exists()) throw new AssertionError("Element "+locator+" failed to disappear within "+seconds+" seconds");
        return this;
    }
}
