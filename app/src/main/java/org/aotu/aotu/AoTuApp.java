package org.aotu.aotu;

import android.app.Application;

public class AoTuApp extends Application{
    public static AoTuApp context;

    @Override
    public void onCreate() {
        context = this;
        super.onCreate();
    }
}
