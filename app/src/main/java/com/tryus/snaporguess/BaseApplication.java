package com.tryus.snaporguess;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by joaozao on 13/03/17.
 * This class contains the application initializations.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
