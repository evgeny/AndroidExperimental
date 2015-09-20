package com.evgeny.daggersample.injection.module;

import android.content.Context;

import com.evgeny.daggersample.injection.scope.ActivityScope;
import com.evgeny.daggersample.ui.BaseActivity;
import com.evgeny.daggersample.EventListAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

//    @Provides
//    @ActivityScope
//    public EventListAdapter provideListAdapter() {
//        return new EventListAdapter(activity);
//    }

    @Provides
    @ActivityScope
    public Context provideActivityContext() {
        return activity;
    }
}
