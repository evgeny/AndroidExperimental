package com.evgeny.daggersample.injection.module;

import com.evgeny.daggersample.data.ClientSource;
import com.evgeny.daggersample.data.RestClientSource;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides @Singleton
    ClientSource provideClientSource(RestClientSource clientSource) {
        return clientSource;
    }
}
