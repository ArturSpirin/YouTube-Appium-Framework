import core.UiSelector;

/**
 * Created by Artur on 3/23/2016.
 */
public class Runner {

    public static void main(String[] args){

        new UiSelector().resourceId("hello").text("item1").makeUiObject();
        new UiSelector().resourceId("hello").text("item2").makeUiObject();
        new UiSelector().resourceId("hello").text("item3").makeUiObject();
        new UiSelector().resourceId("hello").text("item4").makeUiObject();
        new UiSelector().resourceId("hello").text("item5").makeUiObject();
        new UiSelector().resourceId("hello").text("item6").makeUiObject();

    }
}
