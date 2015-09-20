package com.evgeny.daggersample.network;

import com.evgeny.daggersample.data.Event;

public interface ClientSource {
    public Event[] findAll();
    public Event[] findAllAsync();
}
