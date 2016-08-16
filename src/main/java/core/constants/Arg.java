package core.constants;

import io.appium.java_client.service.local.flags.ServerArgument;

/**
 * Created by Artur on 7/28/2016.
 */
public enum Arg implements ServerArgument {

    TIMEOUT("--command-timeout"),
    LOCATL_TIME_ZONE("--local-timezone"),
    LOG_LEVEL("--log-level");

    private final String arg;

    Arg(String arg){
        this.arg = arg;
    }

    @Override
    public String getArgument() {
        return arg;
    }
}
