package com.evgeny.daggersample.ui;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.os.Bundle;
import android.widget.ListView;

import com.evgeny.daggersample.R;
import com.evgeny.daggersample.data.Event;

public class EventListActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<Event[]> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
