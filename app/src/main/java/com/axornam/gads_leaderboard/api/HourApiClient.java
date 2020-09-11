package com.axornam.gads_leaderboard.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HourApiClient {

    public static Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gadsapi.herokuapp.com/api")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static GadsHoursApi getService() {
        GadsHoursApi service = getRetrofit().create(GadsHoursApi.class);
        return service;
    }
}
