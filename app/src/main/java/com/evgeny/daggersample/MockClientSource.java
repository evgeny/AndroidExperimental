package com.evgeny.daggersample;

import android.util.Log;

import java.util.List;

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
