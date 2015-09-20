package com.evgeny.daggersample.network;

import android.util.Log;

import com.evgeny.daggersample.data.Event;
import com.evgeny.daggersample.network.ClientSource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MockClientSource implements ClientSource {

    @Inject
    public MockClientSource() {}

    @Override
    public Event[] findAll() {
        Log.d("Mock", "findAll");
        Event event1 = new Event();
        event1.id = 1;
        event1.title = "Event 1";

        Event event2 = new Event();
        event2.id = 2;
        event2.title = "Event 2";

        Event event3 = new Event();
        event3.id = 3;
        event3.title = "Event 3";

        return new Event[]{
                event1, event2, event3
        };
    }

    @Override
    public Event[] findAllAsync() {
        return new Event[0];
    }
}
