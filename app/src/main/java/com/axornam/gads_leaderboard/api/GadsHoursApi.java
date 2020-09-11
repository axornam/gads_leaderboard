package com.axornam.gads_leaderboard.api;

import com.axornam.gads_leaderboard.models.LearningLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GadsHoursApi {

    @GET("hours")
    Call<List<LearningLeaders>> getLearningLeaders();
}
