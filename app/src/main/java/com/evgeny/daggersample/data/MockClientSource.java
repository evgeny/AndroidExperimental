package com.evgeny.daggersample.data;

import android.util.Log;

import com.evgeny.daggersample.data.ClientSource;
import com.evgeny.daggersample.data.Event;

/**
 * Created by evgeny on 21.08.15.
 */
public class MockClientSource implements ClientSource {
    @Override
    public Event[] findAll() {
        Log.d("Mock", "findAll");
        return null;
    }
}
