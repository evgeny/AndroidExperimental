package com.evgeny.daggersample;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    // inject MODULE "ApplicationModule" to activity
//    void inject(BaseActivity baseActivity);

    // inject MODULE to application
//    void inject(Application application);

    // exposed to sub-graph
    ActivityComponent extend(ActivityModule activityModule);
}
