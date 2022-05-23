/*
    NIM     : 10119172
    Nama    : Rahman Insani
    Kelas   : IF-5

    Selasa, 08 Mei 2022
*/

package com.rahmaninsani.a10119172uts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rahmaninsani.a10119172uts.R;
import com.rahmaninsani.a10119172uts.model.GoalModel;

import java.util.ArrayList;

public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.GoalViewHolder> {

    ArrayList<GoalModel> goalModel;

    public GoalAdapter(ArrayList<GoalModel> hobbyModel) {
        this.goalModel = hobbyModel;
    }

    class GoalViewHolder extends RecyclerView.ViewHolder {
        ImageView goalImage;
        TextView goalDescription;

        public GoalViewHolder(@NonNull View itemView) {
            super(itemView);

            goalImage = itemView.findViewById(R.id.goal_image);
            goalDescription = itemView.findViewById(R.id.goal_description);
        }
    }

    @NonNull
    @Override
    public GoalAdapter.GoalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goal, parent, false);
        return new GoalAdapter.GoalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoalAdapter.GoalViewHolder holder, int position) {
        holder.goalImage.setImageResource(goalModel.get(position).getImage());
        holder.goalDescription.setText(goalModel.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return goalModel.size();
    }
}
