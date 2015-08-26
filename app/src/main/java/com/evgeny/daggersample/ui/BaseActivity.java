package com.evgeny.daggersample.ui;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.evgeny.daggersample.data.ClientSource;
import com.evgeny.daggersample.data.Event;
import com.evgeny.daggersample.EventListAdapter;
import com.evgeny.daggersample.R;
import com.evgeny.daggersample.SampleApplication;
import com.evgeny.daggersample.injection.module.ActivityModule;

import javax.inject.Inject;

public class BaseActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Event[]>{
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

        setContentView(R.layout.main);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(eventListAdapter);

        getLoaderManager().initLoader(0, null, this).forceLoad();
    }

    @Override
    public Loader<Event[]> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<Event[]>(this) {
            @Override
            public Event[] loadInBackground() {

                return clientSource.findAll();
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<Event[]> loader, Event[] data) {
        eventListAdapter.setData(data);
    }

    @Override
    public void onLoaderReset(Loader<Event[]> loader) {

    }
}
