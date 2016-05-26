import api.android.Android;
import api.apps.speedtest.home.Home;
import core.MyLogger;
import core.managers.DriverManager;
import org.apache.log4j.Level;

import java.net.MalformedURLException;

/**
 * Created by Artur on 3/23/2016.
 */
public class Runner {
    public static void main(String[] args) throws MalformedURLException {

        MyLogger.log.setLevel(Level.INFO);
        try{
            DriverManager.createDriver();
            Android.app.speedtest.open();
            Home results = Android.app.speedtest.home.tapTestAgain();
            MyLogger.log.info("Ping: "+results.getPingSpeed());
            MyLogger.log.info("Download: "+results.getDownloadSpeed());
            MyLogger.log.info("Upload: "+results.getUploadSpeed());
        }finally {
            DriverManager.killDriver();
        }
    }
}
