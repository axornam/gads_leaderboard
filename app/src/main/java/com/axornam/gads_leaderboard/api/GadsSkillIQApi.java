package com.axornam.gads_leaderboard.api;

import com.axornam.gads_leaderboard.models.SkillIQLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GadsSkillIQApi {

    @GET("skilliq")
    Call<List<SkillIQLeaders>> getSkillIQLeaders();
}
