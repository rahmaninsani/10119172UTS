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
import com.rahmaninsani.a10119172uts.model.MusicModel;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {
    ArrayList<MusicModel> musicModel;

    public MusicAdapter(ArrayList<MusicModel> musicModel) {
        this.musicModel = musicModel;
    }

    class MusicViewHolder extends RecyclerView.ViewHolder {
        ImageView musicImage;
        TextView musicTitle, musicSinger;

        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            musicImage = itemView.findViewById(R.id.music_image);
            musicTitle = itemView.findViewById(R.id.music_title);
            musicSinger = itemView.findViewById(R.id.music_singer);
        }
    }

    @NonNull
    @Override
    public MusicAdapter.MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent, false);
        return new MusicAdapter.MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.MusicViewHolder holder, int position) {
        holder.musicImage.setImageResource(musicModel.get(position).getImage());
        holder.musicTitle.setText(musicModel.get(position).getTitle());
        holder.musicSinger.setText(musicModel.get(position).getSinger());
    }

    @Override
    public int getItemCount() {
        return musicModel.size();
    }

}
