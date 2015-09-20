package com.evgeny.daggersample.network;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface EventBonnService {
    @GET("/api.json.php")
    ResponseEvents listEvents(@Query("mod") String mod);

    @GET("/api.json.php")
    void listEventsAsync(@Query("mod") String mod, Callback<ResponseEvents> cb);

    @GET("/api.json.php")
    ResponseEvents findEvents(@Query("mod") String mod, @Query("query") String query);
}
