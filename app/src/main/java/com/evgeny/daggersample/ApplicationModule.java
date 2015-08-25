package com.evgeny.daggersample;

import android.app.Application;
import android.content.Context;
import android.location.LocationManager;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(Context.LOCATION_SERVICE);
    }

    @Provides
    @Singleton
    ClientSource provideClientSource() {
        return new RestClientSource();
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient() {
        return new OkHttpClient();
    }
}
