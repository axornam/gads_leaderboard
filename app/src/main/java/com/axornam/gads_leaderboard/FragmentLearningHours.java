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
import com.axornam.gads_leaderboard.api.HourApiClient;
import com.axornam.gads_leaderboard.models.LearningLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentLearningHours extends Fragment {
    private static final String TAG = "FragmentLearningHours";
    private List<LearningLeaders> mInnovators;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_learners, container, false);

        initArrayList();
        initRecyclerView(root);
        return root;
    }

    private void initArrayList() {
        Log.d(TAG, "initBitMaps: Initializing Image Bitmaps");

        Call<List<LearningLeaders>> call = HourApiClient.getService().getHours();
        call.enqueue(new Callback<List<LearningLeaders>>() {
            @Override
            public void onResponse(Call<List<LearningLeaders>> call, Response<List<LearningLeaders>> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getContext(), "Hours Api Connection Success", Toast.LENGTH_SHORT).show();
                    mInnovators = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<LearningLeaders>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed To Connect To Hours Api", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecyclerView(View root) {
        Log.d(TAG, "initRecyclerView: Creating Recycler View");
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        LearnersRecyclerViewAdapter recyclerViewAdapter = new LearnersRecyclerViewAdapter(getActivity().getApplicationContext(),  mInnovators);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}