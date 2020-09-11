package com.axornam.gads_leaderboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.axornam.gads_leaderboard.adapters.SkillIQRecyclerViewAdapter;
import com.axornam.gads_leaderboard.api.SkillIQApiClient;
import com.axornam.gads_leaderboard.models.SkillIQLeaders;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSkillsIQ extends Fragment {
    private static final String TAG = "FragmentSkillsIQ";
    RecyclerView mRecyclerView;
    SkillIQRecyclerViewAdapter mSkillIQRecyclerViewAdapter;
    private List<SkillIQLeaders> mSkillIQLeaders = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learners, container, false);
        initArrayList();
        initRecyclerView(view);

        return view;
    }

    private void initArrayList() {
        Log.d(TAG, "initArrayList: Initialising Arrays");

        Call<List<SkillIQLeaders>> call = SkillIQApiClient.getService().getSkillIq();
        call.enqueue(new Callback<List<SkillIQLeaders>>() {
            @Override
            public void onResponse(Call<List<SkillIQLeaders>> call, Response<List<SkillIQLeaders>> response) {
                if(response.isSuccessful()){
                    mSkillIQLeaders = response.body();
                    Log.d(TAG, "onResponse: " + response.body().toString());
                    Toast.makeText(getContext(), "SkillIQ Api Connection Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<SkillIQLeaders>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed To Connect To SkillIQ Api", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecyclerView(View root) {
        Log.d(TAG, "initRecyclerView: Creating Recycler View");

        mRecyclerView = root.findViewById(R.id.recycler_view);
        mSkillIQRecyclerViewAdapter = new SkillIQRecyclerViewAdapter(getContext(), mSkillIQLeaders);
        mRecyclerView.setAdapter(mSkillIQRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
