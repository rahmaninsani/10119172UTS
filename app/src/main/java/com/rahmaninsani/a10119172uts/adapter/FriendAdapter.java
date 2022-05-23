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
import com.rahmaninsani.a10119172uts.model.FriendModel;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendViewHolder> {
    ArrayList<FriendModel> friendModel;

    public FriendAdapter(ArrayList<FriendModel> friendModel) {
        this.friendModel = friendModel;
    }

    class FriendViewHolder extends RecyclerView.ViewHolder {
        ImageView friendImage;
        TextView friendName;

        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            friendImage = itemView.findViewById(R.id.friend_image);
            friendName = itemView.findViewById(R.id.friend_name);
        }
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, parent, false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        holder.friendImage.setImageResource(friendModel.get(position).getImage());
        holder.friendName.setText(friendModel.get(position).getNama());
    }

    @Override
    public int getItemCount() {
        return friendModel.size();
    }

}
