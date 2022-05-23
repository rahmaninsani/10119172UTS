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
import com.rahmaninsani.a10119172uts.model.ActivityModel;

import java.util.ArrayList;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {
    ArrayList<ActivityModel> activityModel;

    public ActivityAdapter(ArrayList<ActivityModel> activityModel) {
        this.activityModel = activityModel;
    }

    class ActivityViewHolder extends RecyclerView.ViewHolder {
        ImageView activityImage;
        TextView activityTitle, activityDescription;

        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            activityImage = itemView.findViewById(R.id.activity_image);
            activityTitle = itemView.findViewById(R.id.activity_title);
            activityDescription = itemView.findViewById(R.id.activity_description);
        }
    }

    @NonNull
    @Override
    public ActivityAdapter.ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity, parent, false);
        return new ActivityAdapter.ActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityAdapter.ActivityViewHolder holder, int position) {
        holder.activityImage.setImageResource(activityModel.get(position).getImage());
        holder.activityTitle.setText(activityModel.get(position).getTitle());
        holder.activityDescription.setText(activityModel.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return activityModel.size();
    }


}
