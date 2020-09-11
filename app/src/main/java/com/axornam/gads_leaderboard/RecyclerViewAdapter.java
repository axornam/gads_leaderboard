package com.axornam.gads_leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axornam.gads_leaderboard.models.Innovator;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<Innovator> mInnovatorArrayList;
    Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<Innovator> innovatorArrayList) {
        this.mInnovatorArrayList = innovatorArrayList;
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
                .load(mInnovatorArrayList.get(i).getBadgeUrl())
                .into(viewHolder.skillImage);

        viewHolder.innovatorName.setText(mInnovatorArrayList.get(i).getName());
        viewHolder.innovatorSkill.setText(String.format("%d Learning Hours, %s",
                mInnovatorArrayList.get(i).getHours(), mInnovatorArrayList.get(i).getCountry()));
    }

    @Override
    public int getItemCount() {
        return mInnovatorArrayList.size();
    }


    /////////////////////////////////////////////////////////////////
    ///
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
