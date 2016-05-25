package api.interfaces;

/**
 * Created by Artur on 5/25/2016.
 */
public interface Application {

    void forceStop();
    void clearData();
    Object open();
    String packageID();
    String activityID();
}
