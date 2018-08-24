package patahai.digitopper.com.ptahailatestdesign.application;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static Context appContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }

    public static Context getAppContext() {

        return appContext;
    }

}
