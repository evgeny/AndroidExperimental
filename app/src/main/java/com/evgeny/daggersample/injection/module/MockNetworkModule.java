package com.evgeny.daggersample.injection.module;

import com.evgeny.daggersample.data.ClientSource;
import com.evgeny.daggersample.data.MockClientSource;

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
