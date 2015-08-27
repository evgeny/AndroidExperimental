package com.evgeny.daggersample;

import android.app.Application;

import com.evgeny.daggersample.injection.component.ApplicationComponent;
import com.evgeny.daggersample.injection.component.DaggerApplicationComponent;
import com.evgeny.daggersample.injection.component.DaggerMockApplicationComponent;
import com.evgeny.daggersample.injection.component.MockApplicationComponent;
import com.evgeny.daggersample.injection.module.ApplicationModule;
import com.evgeny.daggersample.injection.module.MockNetworkModule;
import com.evgeny.daggersample.injection.module.NetworkModule;

public class SampleApplication extends Application {

    private ApplicationComponent component;
    private MockApplicationComponent mockComponent;

    @Override public void onCreate() {
        super.onCreate();

        if (component == null) {
            component = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .networkModule(new NetworkModule())
                    .build();
        }
        if (mockComponent == null) {
            mockComponent = DaggerMockApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .mockNetworkModule(new MockNetworkModule())
                    .build();
        }

//        component.inject(this);
    }

    public ApplicationComponent component() {
        return component;
    }

    public MockApplicationComponent mockComponent() {
        return mockComponent;
    }
}
