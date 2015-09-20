package com.evgeny.daggersample.network;


import com.evgeny.daggersample.data.Event;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

@Singleton
public class RetrofitClientSource implements ClientSource {

    private final EventBonnService service;

    @Inject
    public RetrofitClientSource(OkHttpClient okHttpClient, Gson gson) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://www.bonn.de/tools/mobil")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .setClient(new OkClient(okHttpClient))
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        // If required...
                        // TODO log network output
                    }
                })
                .build();

        service = restAdapter.create(EventBonnService.class);
    }

    @Override
    public Event[] findAll() {
        ResponseEvents response = service.listEvents("veranstaltungen");
        return response.items;
    }

    @Override
    public Event[] findAllAsync() {
        return new Event[0];
    }

    public Event[] findByQuery(String query) {
        ResponseEvents events = service.findEvents("veranstaltungen", query);

        return events.items;
    }
}
