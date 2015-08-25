package com.evgeny.daggersample;

import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

public class RestClientSource implements ClientSource {

    private OkHttpClient okHttpClient;
    private final Gson gson;
    private final String eventsUrl = "http://www.bonn.de/tools/mobil/api.json.php?mod=veranstaltungen";

    public RestClientSource() {
        this.okHttpClient = new OkHttpClient();
        this.gson = new Gson();
    }

    @Override
    public Event[] findAll() {
        Log.d("Rest", "findAll()");

        final Request request = new Request.Builder()
                .url(eventsUrl)
                .build();

        try {
            Response httpResponse = okHttpClient.newCall(request).execute();
            ResponseC response = gson.fromJson(httpResponse.body().charStream(), ResponseC.class);
            return response.items;
        } catch (IOException e) {
            e.printStackTrace();
        }
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void
//            onFailure(Request request, IOException e) {
//                Log.d("Rest", "onFailure");
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
//                Log.d("Rest", "onResponse");
//            }
//        });
        return null;
    }

    private static class ResponseC {
        boolean success;
        Event[] items;
        int count;
    }
}
