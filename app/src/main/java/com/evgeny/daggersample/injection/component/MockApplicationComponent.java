package com.evgeny.daggersample.injection.component;

import com.evgeny.daggersample.injection.module.ActivityModule;
import com.evgeny.daggersample.injection.module.ApplicationModule;
import com.evgeny.daggersample.injection.module.MockNetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, MockNetworkModule.class})
public interface MockApplicationComponent {

    ActivityComponent extend(ActivityModule activityModule);
}
