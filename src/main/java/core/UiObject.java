package core;

/**
 * Created by Artur on 4/13/2016.
 */
public class UiObject {

    private String locator;

    UiObject(String locator){
        this.locator = locator;
        System.out.println(this.locator);
    }
}
