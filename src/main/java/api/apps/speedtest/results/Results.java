package api.apps.speedtest.results;

import api.android.Android;
import api.interfaces.Activity;
import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Artur on 5/25/2016.
 */
public class Results implements Activity{

    public ResultsUiObjects uiObject = new ResultsUiObjects();

    //sortTypes: 1=type, 2=time, 3=download, 4=upload, 5=ping
    public Results sortBy(String sortType){
        try{
            sortType = sortType.toLowerCase();
            MyLogger.log.info("Sorting by "+sortType);
            if(sortType.equals("type")) uiObject.sortByType().tap();
            else if(sortType.equals("time")) uiObject.sortByTime().tap();
            else if(sortType.equals("download")) uiObject.sortByDownload().tap();
            else if(sortType.equals("upload")) uiObject.sortByUpload().tap();
            else if(sortType.equals("ping")) uiObject.sortByPing().tap();
            else throw new RuntimeException("Sorting by type: "+sortType+" is not supported");
            return Android.app.speedtest.results;
        }catch (NoSuchElementException e){
            throw new AssertionError("Cant sort by "+sortType+", element absent or blocked");
        }
    }

    @Override
    public Results waitToLoad() {
        try{
            MyLogger.log.info("Waiting for Results Activity");
            uiObject.resultsLabel().waitToAppear(10);
            return Android.app.speedtest.results;
        }catch (AssertionError e){
            throw new AssertionError("Results activity failed to load/open");
        }
    }
}
