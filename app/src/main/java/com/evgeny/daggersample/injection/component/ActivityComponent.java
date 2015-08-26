package com.evgeny.daggersample.injection.component;

import com.evgeny.daggersample.injection.scope.ActivityScope;
import com.evgeny.daggersample.ui.BaseActivity;
import com.evgeny.daggersample.injection.module.ActivityModule;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(BaseActivity activity);
}
