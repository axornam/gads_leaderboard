package com.axornam.gads_leaderboard.apiutil;

import com.axornam.gads_leaderboard.api.SubmitAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitAPIClient {

    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static SubmitAPI getService() {
        return getRetrofit().create(SubmitAPI.class);
    }
}
