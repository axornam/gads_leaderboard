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

    public LearnersRecyclerViewAdapter(Context context, List<LearningLeaders> leadersList) {
        this.mLeadersList = leadersList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(mContext)
                .asDrawable()
                .load(mLeadersList.get(i).getBadgeUrl())
                .into(viewHolder.skillImage);

        viewHolder.innovatorName.setText(mLeadersList.get(i).getName());
        viewHolder.innovatorSkill.setText(String.format("%d Learning Hours, %s",
                mLeadersList.get(i).getHours(), mLeadersList.get(i).getCountry()));
    }

    @Override
    public int getItemCount() {
        if(mLeadersList == null) return 0;
        return mLeadersList.size();
    }


    /////////////////////////////////////////////////////////////////
    /// NESTED VIEW HOLDER CLASS FOR RECYCLER VIEW
    /////////////////////////////////////////////////////////////////
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView skillImage;
        TextView innovatorName;
        TextView innovatorSkill;
        FrameLayout recyclerItem;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            skillImage = itemView.findViewById(R.id.skill_badge);
            innovatorName = itemView.findViewById(R.id.innovator_name);
            innovatorSkill = itemView.findViewById(R.id.innovator_skill);
            recyclerItem = itemView.findViewById(R.id.recycler_item);
        }
    }////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////
}
