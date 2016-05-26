package api.apps.speedtest.results;

import core.UiObject;
import core.UiSelector;

/**
 * Created by Artur on 5/25/2016.
 */
public class ResultsUiObjects {

    private static UiObject
            logo,
            sortByType,
            sortByTime,
            sortByDownload,
            sortByUpload,
            sortByPing,
            toolsButton,
            resultsLabel;

    public UiObject logo(){
        if(logo == null) logo = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/logo").makeUiObject();
        return logo;
    }

    public UiObject sortByType(){
        if(sortByType == null) sortByType = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/typeLayout").makeUiObject();
        return sortByType;
    }

    public UiObject sortByTime(){
        if(sortByTime == null) sortByTime = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/timeLayout").makeUiObject();
        return sortByTime;
    }

    public UiObject sortByDownload(){
        if(sortByDownload == null) sortByDownload = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/downloadLayout").makeUiObject();
        return sortByDownload;
    }

    public UiObject sortByUpload(){
        if(sortByUpload == null) sortByUpload = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/uploadLayout").makeUiObject();
        return sortByUpload;
    }

    public UiObject sortByPing(){
        if(sortByPing == null) sortByPing = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/pingLayout").makeUiObject();
        return sortByPing;
    }

    public UiObject toolsButton(){
        if(toolsButton == null) toolsButton = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/toolsButton").makeUiObject();
        return toolsButton;
    }

    public UiObject resultsLabel(){
        if(resultsLabel == null) resultsLabel = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/resultsCoutText").makeUiObject();
        return resultsLabel;
    }
}
