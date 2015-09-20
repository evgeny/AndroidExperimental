package com.evgeny.daggersample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.evgeny.daggersample.SampleApplication;
import com.evgeny.daggersample.injection.component.ActivityComponent;
import com.evgeny.daggersample.injection.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectModule(((SampleApplication) getApplication()).component().extend(new ActivityModule(this)));
    }

    public abstract void injectModule(ActivityComponent component);
}
