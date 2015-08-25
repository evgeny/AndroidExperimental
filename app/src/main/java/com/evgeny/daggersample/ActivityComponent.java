package com.evgeny.daggersample;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    BaseActivity inject(BaseActivity activity);
}
