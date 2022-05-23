/*
    NIM     : 10119172
    Nama    : Rahman Insani
    Kelas   : IF-5

    Selasa, 08 Mei 2022
*/

package com.rahmaninsani.a10119172uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.rahmaninsani.a10119172uts.adapter.WalkthroughAdapter;
import com.rahmaninsani.a10119172uts.model.WalkthroughModel;

import java.util.ArrayList;
import java.util.List;


public class WalkthroughActivity extends AppCompatActivity {
    private WalkthroughAdapter walkthroughAdapter;
    private LinearLayout walkthroughIndicator;
    private Button walkthroughButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        walkthroughIndicator = findViewById(R.id.walkthrough_indicator);
        walkthroughButton = findViewById(R.id.walkthrough_button);

        setupWalkthroughItems();

        final ViewPager2 walkthroughViewPager = findViewById(R.id.walkthrough_viewpager);
        walkthroughViewPager.setAdapter(walkthroughAdapter);

        setupIndicatorWalkthrough();
        setCurrentIndicatorWalkthrough(0);

        walkthroughViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicatorWalkthrough(position);
            }
        });

        walkthroughButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(walkthroughViewPager.getCurrentItem() + 1 < walkthroughAdapter.getItemCount()) {
                    walkthroughViewPager.setCurrentItem(walkthroughViewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(WalkthroughActivity.this, MainActivity.class));
                    finish();
                }
            }
        });
    }

    private void setupWalkthroughItems() {
        List<WalkthroughModel> walkthroughModel = new ArrayList<>();

        WalkthroughModel itemWalkthrough1 = new WalkthroughModel();
        itemWalkthrough1.setTitle(getString(R.string.walkthrough1_title));
        itemWalkthrough1.setSubtitle(getString(R.string.walkthrough1_subtitle));
        itemWalkthrough1.setIllustration(R.drawable.ic_walkthrough_illustration_1);

        WalkthroughModel itemWalkthrough2 = new WalkthroughModel();
        itemWalkthrough2.setTitle(getString(R.string.walkthrough2_title));
        itemWalkthrough2.setSubtitle(getString(R.string.walkthrough2_subtitle));
        itemWalkthrough2.setIllustration(R.drawable.ic_walkthrough_illustration_2);

        WalkthroughModel itemWalkthrough3 = new WalkthroughModel();
        itemWalkthrough3.setTitle(getString(R.string.walkthrough3_title));
        itemWalkthrough3.setSubtitle(getString(R.string.walkthrough3_subtitle));
        itemWalkthrough3.setIllustration(R.drawable.ic_walkthrough_illustration_3);

        walkthroughModel.add(itemWalkthrough1);
        walkthroughModel.add(itemWalkthrough2);
        walkthroughModel.add(itemWalkthrough3);

        walkthroughAdapter = new WalkthroughAdapter(walkthroughModel);
    }

    private void setupIndicatorWalkthrough() {
        ImageView[] indicator = new ImageView[walkthroughAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0, 8,0);
        for (int i = 0; i < indicator.length; i++) {
            indicator[i] = new ImageView(getApplicationContext());
            indicator[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.walkthrough_indicator_inactive
            ));
            indicator[i].setLayoutParams(layoutParams);
            walkthroughIndicator.addView(indicator[i]);
        }
    }

    private void setCurrentIndicatorWalkthrough(int index) {
        int childCount = walkthroughIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) walkthroughIndicator.getChildAt(i);
            if(i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.walkthrough_indicator_active)
                );
            }else{
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.walkthrough_indicator_inactive)
                );
            }
        }
        if (index == walkthroughAdapter.getItemCount() - 1) {
            walkthroughButton.setText(getString(R.string.start));
        } else {
            walkthroughButton.setText(getString(R.string.next));
        }
    }
}