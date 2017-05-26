package com.lavuelta.lavueltaapp.app;

import android.app.Application;

import com.lavuelta.lavueltaapp.utilidades.Cache;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by jggomez on 23-May-17.
 */

public class LavueltaApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Cache.init(getApplicationContext());

        FlowManager.init(getApplicationContext());
    }
}
