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
import com.axornam.gads_leaderboard.models.SkillIQLeaders;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class SkillIQRecyclerViewAdapter extends RecyclerView.Adapter<SkillIQRecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<SkillIQLeaders> mSkillIQLeaders;

    public SkillIQRecyclerViewAdapter(Context context, List<SkillIQLeaders> skillIQLeaders) {
        mContext = context;
        mSkillIQLeaders = skillIQLeaders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_learners, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int i) {
        Glide.with(mContext)
                .asDrawable()
                .load(mSkillIQLeaders.get(i).getBadgeUrl())
                .into(viewholder.skillImage);

        viewholder.innovatorName.setText(mSkillIQLeaders.get(i).getName());
        viewholder.innovatorSkill.setText(String.format("%d Skill IQ Score, %s", mSkillIQLeaders.get(i).getScore(),
                mSkillIQLeaders.get(i).getCountry()));
    }

    @Override
    public int getItemCount() {
        if (mSkillIQLeaders == null) return 0;
        return mSkillIQLeaders.size();
    }

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
    }
}
