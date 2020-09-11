package com.axornam.gads_leaderboard.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SkillIQApiClient {

    public static Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static GadsSkillIQApi getService() {
        GadsSkillIQApi service = getRetrofit().create(GadsSkillIQApi.class);
        return service;
    }
}
