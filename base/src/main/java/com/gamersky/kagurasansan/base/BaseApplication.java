package com.gamersky.kagurasansan.base;

import android.app.Application;


public class BaseApplication extends Application {
    private static BaseApplication mBaseApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        mBaseApplication = this;
    }

    public static BaseApplication getBaseApplication() {
        return mBaseApplication;
    }
}
