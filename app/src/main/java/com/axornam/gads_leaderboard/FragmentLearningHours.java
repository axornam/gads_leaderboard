package com.axornam.gads_leaderboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.axornam.gads_leaderboard.adapters.LearnersRecyclerViewAdapter;
import com.axornam.gads_leaderboard.apiutil.HourApiClient;
import com.axornam.gads_leaderboard.models.LearningLeader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentLearningHours extends Fragment {
    private static final String TAG = "FragmentLearningHours";
    private List<LearningLeader> mLearningLeaders = new ArrayList<>();
    View mView;
    RecyclerView mRecyclerView;
    LearnersRecyclerViewAdapter mRecyclerViewAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_learners, container, false);
        getApiList();
        return mView;
    }

    private void getApiList() {
        Call<List<LearningLeader>> call = HourApiClient.getService().getHours();
        call.enqueue(new Callback<List<LearningLeader>>() {
            @Override
            public void onResponse(@NonNull Call<List<LearningLeader>> call, @NonNull Response<List<LearningLeader>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.i(TAG, "onResponse: Received Data " + response.body().size());
                    initArrayList(response.body());
                    Toast.makeText(getContext(), "Hours Api Connection Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<LearningLeader>> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "Failed To Connect To Hours Api", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initArrayList(List<LearningLeader> body) {
        Log.d(TAG, "initArrayList: Initialising Arrays");

        if (body.size() != 0) {
//            for (LearningLeader l : body) {
//                this.mLearningLeaders.add(l);
//            }
            this.mLearningLeaders.addAll(body);
            initRecyclerView(mView, this.mLearningLeaders);
        } else {
            Log.i(TAG, "initArrayList: No Data Recieved");
        }
    }

    private void initRecyclerView(View view, List<LearningLeader> learningLeaders) {
        Log.d(TAG, "initRecyclerView: Creating Recycler View");

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerViewAdapter = new LearnersRecyclerViewAdapter(getContext(), learningLeaders);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
//    private void initRecyclerView(View root) {
//    }
}