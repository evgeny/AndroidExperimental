package com.evgeny.daggersample.injection.module;

import com.evgeny.daggersample.network.ClientSource;
import com.evgeny.daggersample.network.MockClientSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MockNetworkModule {

    @Provides @Singleton
    ClientSource provideClientSource(MockClientSource clientSource){
        return clientSource;
    }
}
