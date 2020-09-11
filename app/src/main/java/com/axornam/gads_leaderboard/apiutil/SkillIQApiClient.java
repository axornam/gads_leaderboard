package com.axornam.gads_leaderboard.apiutil;

import com.axornam.gads_leaderboard.api.GadsSkillIQApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SkillIQApiClient {

    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static GadsSkillIQApi getService() {
        return getRetrofit().create(GadsSkillIQApi.class);
    }
}
