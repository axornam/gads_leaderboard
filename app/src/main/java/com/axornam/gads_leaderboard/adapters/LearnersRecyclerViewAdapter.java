package com.axornam.gads_leaderboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axornam.gads_leaderboard.R;
import com.axornam.gads_leaderboard.models.LearningLeaders;
import com.bumptech.glide.Glide;

import java.util.List;

public class LearnersRecyclerViewAdapter extends RecyclerView.Adapter<LearnersRecyclerViewAdapter.ViewHolder> {
    List<LearningLeaders> mLeadersList;
    Context mContext;

    public LearnersRecyclerViewAdapter(List<LearningLeaders> leadersList) {
        this.mLeadersList = leadersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        this.mContext = viewGroup.getContext();
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(mContext)
                .asDrawable()
                .load(mLeadersList.get(i).getBadgeUrl())
                .into(viewHolder.skillBadge);

        viewHolder.learnerName.setText(mLeadersList.get(i).getName());
        viewHolder.learnerDetails.setText(String.format("%d Learning Hours, %s",
                mLeadersList.get(i).getHours(), mLeadersList.get(i).getCountry()));
    }

    @Override
    public int getItemCount() {
//        if (mLeadersList == null) return 0;
        return mLeadersList.size();
    }


    /////////////////////////////////////////////////////////////////
    /// NESTED VIEW HOLDER CLASS FOR RECYCLER VIEW
    /////////////////////////////////////////////////////////////////
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView skillBadge;
        TextView learnerName;
        TextView learnerDetails;
        FrameLayout recyclerItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerItem = itemView.findViewById(R.id.recycler_item);
            skillBadge = itemView.findViewById(R.id.badge);
            learnerName = itemView.findViewById(R.id.name);
            learnerDetails = itemView.findViewById(R.id.details);
        }
    }////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////
}
