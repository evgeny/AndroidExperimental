package com.evgeny.daggersample.injection.component;

import com.evgeny.daggersample.injection.module.ActivityModule;
import com.evgeny.daggersample.injection.module.ApplicationModule;
import com.evgeny.daggersample.injection.module.NetworkModule;
import com.evgeny.daggersample.ui.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {
    // inject MODULE "ApplicationModule" to activity
//    void inject(BaseActivity baseActivity);

    // inject MODULE to application
//    void inject(Application application);

    // exposed to sub-graph
    ActivityComponent extend(ActivityModule activityModule);
}
