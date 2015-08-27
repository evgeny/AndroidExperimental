package com.evgeny.daggersample.ui;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.evgeny.daggersample.EventListAdapter;
import com.evgeny.daggersample.SampleApplication;
import com.evgeny.daggersample.data.ClientSource;
import com.evgeny.daggersample.injection.module.ActivityModule;

import javax.inject.Inject;

public class BaseActivity extends AppCompatActivity {
    @Inject
    ClientSource clientSource;

    @Inject
    LocationManager locationManager;

    @Inject
    EventListAdapter eventListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Perform injection so that when this call returns all dependencies will be available for use.
        ((SampleApplication) getApplication()).component().extend(new ActivityModule(this)).inject(this);
    }
}
