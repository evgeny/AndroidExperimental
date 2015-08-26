package com.evgeny.daggersample.injection.module;

import android.app.Application;
import android.content.Context;
import android.location.LocationManager;

import com.evgeny.daggersample.data.ClientSource;
import com.evgeny.daggersample.data.RestClientSource;
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
    ClientSource provideClientSource(RestClientSource clientSource) {
        return clientSource;
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient() {
        return new OkHttpClient();
    }
}