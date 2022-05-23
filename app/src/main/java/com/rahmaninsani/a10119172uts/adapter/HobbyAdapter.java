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

import com.rahmaninsani.a10119172uts.model.HobbyModel;
import com.rahmaninsani.a10119172uts.R;

import java.util.ArrayList;

public class HobbyAdapter extends RecyclerView.Adapter<HobbyAdapter.HobbyViewHolder> {

    ArrayList<HobbyModel> hobbyModel;

    public HobbyAdapter(ArrayList<HobbyModel> hobbyModel) {
        this.hobbyModel = hobbyModel;
    }

    class HobbyViewHolder extends RecyclerView.ViewHolder {
        ImageView hobbyImage;
        TextView hobbyDescription;

        public HobbyViewHolder(@NonNull View itemView) {
            super(itemView);

            hobbyImage = itemView.findViewById(R.id.hobby_image);
            hobbyDescription = itemView.findViewById(R.id.hobby_description);
        }
    }

    @NonNull
    @Override
    public HobbyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hobby, parent, false);
        return new HobbyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HobbyViewHolder holder, int position) {
        holder.hobbyImage.setImageResource(hobbyModel.get(position).getImage());
        holder.hobbyDescription.setText(hobbyModel.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return hobbyModel.size();
    }
}
