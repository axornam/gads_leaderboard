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
import com.axornam.gads_leaderboard.apiutil.SkillIQApiClient;
import com.axornam.gads_leaderboard.models.SkillIQLeader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSkillsIQ extends Fragment {
    private static final String TAG = "FragmentSkillsIQ";
    RecyclerView mRecyclerView;
    SkillIQRecyclerViewAdapter mSkillIQRecyclerViewAdapter;
    private List<SkillIQLeader> mSkillIQLeaders = new ArrayList<>();
    View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_learners, container, false);
        getApiList();
        return mView;
    }

    private void getApiList() {
        Call<List<SkillIQLeader>> call = SkillIQApiClient.getService().getSkillIq();
        call.enqueue(new Callback<List<SkillIQLeader>>() {
            @Override
            public void onResponse(@NonNull Call<List<SkillIQLeader>> call, @NonNull Response<List<SkillIQLeader>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.i(TAG, "onResponse: Received Data " + response.body().size());
                    initArrayList(response.body());
                    Toast.makeText(getContext(), "SkillIQ Api Connection Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<SkillIQLeader>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed To Connect To SkillIQ Api", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initArrayList(List<SkillIQLeader> body) {
        Log.d(TAG, "initArrayList: Initialising Arrays");
        if (body.size() != 0) {
//            for (SkillIQLeader s : body){
//                this.mSkillIQLeaders.add(s);
//            }
            this.mSkillIQLeaders.addAll(body);
            initRecyclerView(mView, this.mSkillIQLeaders);
        }

    }

    private void initRecyclerView(View view, List<SkillIQLeader> skillIQLeaders) {
        Log.d(TAG, "initRecyclerView: Creating Recycler View");

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mSkillIQRecyclerViewAdapter = new SkillIQRecyclerViewAdapter(getContext(), skillIQLeaders);
        mRecyclerView.setAdapter(mSkillIQRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
