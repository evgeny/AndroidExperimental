package com.evgeny.daggersample.injection.module;

import com.evgeny.daggersample.network.ClientSource;
import com.evgeny.daggersample.network.RetrofitClientSource;
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
    ClientSource provideClientSource(RetrofitClientSource clientSource) {
        return clientSource;
    }
}
