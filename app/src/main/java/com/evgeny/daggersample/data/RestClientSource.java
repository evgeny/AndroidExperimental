package com.evgeny.daggersample.data;

import android.util.Log;

import com.evgeny.daggersample.data.ClientSource;
import com.evgeny.daggersample.data.Event;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RestClientSource implements ClientSource {

    private OkHttpClient okHttpClient;
    private final Gson gson;
    private final String eventsUrl = "http://www.bonn.de/tools/mobil/api.json.php?mod=veranstaltungen";

    @Inject
    public RestClientSource(OkHttpClient okHttpClient, Gson gson) {
        this.okHttpClient = okHttpClient;
        this.gson = gson;
    }

    @Override
    public Event[] findAll() {
        Log.d("Rest", "findAll()");

        final Request request = new Request.Builder()
                .url(eventsUrl)
                .build();

        try {
            Response httpResponse = okHttpClient.newCall(request).execute();
            ResponseEvents response = gson.fromJson(httpResponse.body().charStream(), ResponseEvents.class);
            return response.items;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Response Wrapper
     */
    private static class ResponseEvents {
        boolean success;
        Event[] items;
        int count;
    }
}
