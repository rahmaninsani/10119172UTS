/*
    NIM     : 10119172
    Nama    : Rahman Insani
    Kelas   : IF-5

    Selasa, 08 Mei 2022
*/

package com.rahmaninsani.a10119172uts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.rahmaninsani.a10119172uts.fragment.DailyActivityFragment;
import com.rahmaninsani.a10119172uts.fragment.GalleryFragment;
import com.rahmaninsani.a10119172uts.fragment.HomeFragment;
import com.rahmaninsani.a10119172uts.fragment.MediaFragment;
import com.rahmaninsani.a10119172uts.fragment.ProfileFragment;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity {
    AnimatedBottomBar bottomNavigation;

    private final static int dailyActivityFragmentId = R.id.daily_activity_fragment;
    private final static int galleryFragmentId = R.id.gallery_fragment;
//    private final static int homeFragmentId = R.id.home_fragment;
    private final static int mediaFragmentId = R.id.media_fragment;
    private final static int profileFragmentId = R.id.profile_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mengatur HomeFragment Sebagai Tampilan Awal
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NonNull AnimatedBottomBar.Tab selectedTab) {
                Fragment selectedFragment;

                switch (selectedTab.getId()) {

                    case dailyActivityFragmentId:
                        selectedFragment = new DailyActivityFragment();
                        break;

                    case galleryFragmentId:
                        selectedFragment = new GalleryFragment();
                        break;

                    case mediaFragmentId:
                        selectedFragment = new MediaFragment();
                        break;

                    case profileFragmentId:
                        selectedFragment = new ProfileFragment();
                        break;

                    default:
                        selectedFragment = new HomeFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            }

            @Override
            public void onTabReselected(int i, @NonNull AnimatedBottomBar.Tab tab) {

            }
        });

    }
}