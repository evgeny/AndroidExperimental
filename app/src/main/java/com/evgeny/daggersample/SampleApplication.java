package com.evgeny.daggersample;

import android.app.Application;

public class SampleApplication extends Application {

    private ApplicationComponent component;

    @Override public void onCreate() {
        super.onCreate();

        if (component == null) {
            component = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }

//        component.inject(this);
    }

    public ApplicationComponent component() {
        return component;
    }
}
