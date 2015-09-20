package com.evgeny.daggersample.ui;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ListView;

import com.evgeny.daggersample.EventListAdapter;
import com.evgeny.daggersample.R;
import com.evgeny.daggersample.network.ClientSource;
import com.evgeny.daggersample.data.Event;
import com.evgeny.daggersample.injection.component.ActivityComponent;

import javax.inject.Inject;

public class EventListActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<Event[]> {

    @Inject
    ClientSource clientSource;

    @Inject
    LocationManager locationManager;

    @Inject
    EventListAdapter eventListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(eventListAdapter);

        getLoaderManager().initLoader(0, null, this).forceLoad();
    }

    @Override
    public void injectModule(ActivityComponent component) {
        component.inject(this);
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
