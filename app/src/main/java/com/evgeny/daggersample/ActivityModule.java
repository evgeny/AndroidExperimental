package com.evgeny.daggersample;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public EventListAdapter provideListAdapter() {
        return new EventListAdapter(activity);
    }
}
