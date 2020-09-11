package com.axornam.gads_leaderboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.axornam.gads_leaderboard.adapters.LearnersRecyclerViewAdapter;
import com.axornam.gads_leaderboard.models.LearningLeaders;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentLearningHours extends Fragment {
    private static final String TAG = "FragmentLearningHours";
    private ArrayList<LearningLeaders> mInnovators;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_learners, container, false);

        initArrayList();
        initRecyclerView(root);
        return root;
    }

    private void initArrayList() {
        Log.d(TAG, "initBitMaps: Initializing Image Bitmaps");
        mInnovators = new ArrayList<>();

        mInnovators.add(new LearningLeaders("Richard", 5, "Ghana", "https://i.redd.it/qn7f9oqu7o501.jpg"));
        mInnovators.add(new LearningLeaders("Richard", 5, "Ghana", "https://i.redd.it/qn7f9oqu7o501.jpg"));
        mInnovators.add(new LearningLeaders("Richard", 5, "Ghana", "https://i.redd.it/qn7f9oqu7o501.jpg"));
        mInnovators.add(new LearningLeaders("Richard", 5, "Ghana", "https://i.redd.it/qn7f9oqu7o501.jpg"));
        mInnovators.add(new LearningLeaders("Richard", 5, "Ghana", "https://i.redd.it/qn7f9oqu7o501.jpg"));
        mInnovators.add(new LearningLeaders("Richard", 5, "Ghana", "https://i.redd.it/qn7f9oqu7o501.jpg"));
        mInnovators.add(new LearningLeaders("Richard", 5, "Ghana", "https://i.redd.it/qn7f9oqu7o501.jpg"));
        mInnovators.add(new LearningLeaders("Richard", 5, "Ghana", "https://i.redd.it/qn7f9oqu7o501.jpg"));
        mInnovators.add(new LearningLeaders("Richard", 5, "Ghana", "https://i.redd.it/qn7f9oqu7o501.jpg"));
        mInnovators.add(new LearningLeaders("Richard", 5, "Ghana", "https://i.redd.it/qn7f9oqu7o501.jpg"));

    }

    private void initRecyclerView(View root) {
        Log.d(TAG, "initRecyclerView: Creating Recycler View");
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        LearnersRecyclerViewAdapter recyclerViewAdapter = new LearnersRecyclerViewAdapter(getActivity().getApplicationContext(),  mInnovators);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}