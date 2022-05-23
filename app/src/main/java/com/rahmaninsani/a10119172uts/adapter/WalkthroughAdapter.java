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

import com.rahmaninsani.a10119172uts.model.WalkthroughModel;
import com.rahmaninsani.a10119172uts.R;

import java.util.List;

public class WalkthroughAdapter extends RecyclerView.Adapter<WalkthroughAdapter.WalkthroughViewHolder> {

    private List<WalkthroughModel> walkthroughModel;

    public WalkthroughAdapter(List<WalkthroughModel> walkthroughModel) {
        this.walkthroughModel = walkthroughModel;
    }

    class WalkthroughViewHolder extends RecyclerView.ViewHolder {
        private ImageView walkthroughIllustration;
        private TextView walkthroughTitleText;
        private TextView walkthroughSubtitleText;

        public WalkthroughViewHolder(@NonNull View itemView) {
            super(itemView);

            walkthroughIllustration = itemView.findViewById(R.id.walkthrough_illustration);
            walkthroughTitleText = itemView.findViewById(R.id.walkthrough_title);
            walkthroughSubtitleText = itemView.findViewById(R.id.walkthrough_subtitle);
        }

        void setWalkthroughData(WalkthroughModel walkthroughModel) {
            walkthroughIllustration.setImageResource(walkthroughModel.getIllustration());
            walkthroughTitleText.setText(walkthroughModel.getTitle());
            walkthroughSubtitleText.setText(walkthroughModel.getSubtitle());
        }
    }

    @NonNull
    @Override
    public WalkthroughViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WalkthroughViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_walkthrough, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull WalkthroughViewHolder holder, int position) {
        holder.setWalkthroughData(walkthroughModel.get(position));
    }

    @Override
    public int getItemCount() {
        return walkthroughModel.size();
    }
}
