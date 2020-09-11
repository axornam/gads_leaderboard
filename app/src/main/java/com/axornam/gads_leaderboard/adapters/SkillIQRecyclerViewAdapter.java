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
import com.axornam.gads_leaderboard.models.SkillIQLeader;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class SkillIQRecyclerViewAdapter extends RecyclerView.Adapter<SkillIQRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "SkillIQRecyclerViewAdap";
    private Context mContext;
    private List<SkillIQLeader> mSkillIQLeaders = new ArrayList<>();

    public SkillIQRecyclerViewAdapter(Context context, List<SkillIQLeader> skillIQLeaders) {
        mContext = context;
        mSkillIQLeaders = skillIQLeaders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Glide.with(mContext)
                .asBitmap()
                .load(mSkillIQLeaders.get(i).getBadgeUrl())
                .into(holder.skillBadge);
        holder.learnerName.setText(mSkillIQLeaders.get(i).getName());
        holder.learnerDetails.setText(String.format("%d Skill IQ Score, %s", mSkillIQLeaders.get(i).getScore(),
                mSkillIQLeaders.get(i).getCountry()));
    }

    @Override
    public int getItemCount() {
//        if (mSkillIQLeaders == null) return 0;
        return mSkillIQLeaders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FrameLayout recyclerItem;
        ImageView skillBadge;
        TextView learnerName;
        TextView learnerDetails;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerItem = itemView.findViewById(R.id.recycler_item);
            skillBadge = itemView.findViewById(R.id.badge);
            learnerName = itemView.findViewById(R.id.name);
            learnerDetails = itemView.findViewById(R.id.details);
        }
    }
}
