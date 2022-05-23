/*
    NIM     : 10119172
    Nama    : Rahman Insani
    Kelas   : IF-5

    Selasa, 08 Mei 2022
*/

package com.rahmaninsani.a10119172uts.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rahmaninsani.a10119172uts.R;
import com.rahmaninsani.a10119172uts.adapter.ActivityAdapter;
import com.rahmaninsani.a10119172uts.adapter.FriendAdapter;
import com.rahmaninsani.a10119172uts.model.ActivityModel;
import com.rahmaninsani.a10119172uts.model.FriendModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DailyActivityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DailyActivityFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DailyActivityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DailyActivityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DailyActivityFragment newInstance(String param1, String param2) {
        DailyActivityFragment fragment = new DailyActivityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    // Friend
    RecyclerView recyclerViewFriend;
    ArrayList<FriendModel> friendModel;

    // Activity
    RecyclerView recyclerViewActivity;
    ArrayList<ActivityModel> activityModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_daily_activity, container, false);

        // Friend
        recyclerViewFriend = root.findViewById(R.id.daily_activity_friends);
        recyclerViewFriend.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        friendModel = new ArrayList<>();

        FriendModel friend1 = new FriendModel(R.drawable.annisa, getString(R.string.friend1));
        friendModel.add(friend1);

        FriendModel friend2 = new FriendModel(R.drawable.taufiq, getString(R.string.friend2));
        friendModel.add(friend2);

        FriendModel friend3 = new FriendModel(R.drawable.fazri, getString(R.string.friend4));
        friendModel.add(friend3);

        FriendModel friend4 = new FriendModel(R.drawable.sania, getString(R.string.friend5));
        friendModel.add(friend4);

        FriendModel friend5 = new FriendModel(R.drawable.anggi, getString(R.string.friend6));
        friendModel.add(friend5);

        FriendModel friend6 = new FriendModel(R.drawable.renis, getString(R.string.friend7));
        friendModel.add(friend6);

        FriendModel friend7 = new FriendModel(R.drawable.renur, getString(R.string.friend8));
        friendModel.add(friend7);

        FriendModel friend8 = new FriendModel(R.drawable.nesta, getString(R.string.friend3));
        friendModel.add(friend8);

        recyclerViewFriend.setAdapter(new FriendAdapter(friendModel));


        // Activity
        recyclerViewActivity = root.findViewById(R.id.daily_activity_activities);
        recyclerViewActivity.setLayoutManager(new LinearLayoutManager(getContext()));

        activityModel = new ArrayList<>();

        ActivityModel activity1 = new ActivityModel(R.drawable.ic_activity_star, getString(R.string.activity_title1), getString(R.string.activity_description1));
        activityModel.add(activity1);

        ActivityModel activity2 = new ActivityModel(R.drawable.ic_activity_learning, getString(R.string.activity_title2), getString(R.string.activity_description2));
        activityModel.add(activity2);

        ActivityModel activity3 = new ActivityModel(R.drawable.ic_activity_cat, getString(R.string.activity_title3), getString(R.string.activity_description3));
        activityModel.add(activity3);

        ActivityModel activity4 = new ActivityModel(R.drawable.ic_activity_headphone, getString(R.string.activity_title4), getString(R.string.activity_description4));
        activityModel.add(activity4);

        ActivityModel activity5 = new ActivityModel(R.drawable.ic_activity_youtube, getString(R.string.activity_title5), getString(R.string.activity_description5));
        activityModel.add(activity5);

        ActivityModel activity6 = new ActivityModel(R.drawable.ic_activity_instagram, getString(R.string.activity_title6), getString(R.string.activity_description6));
        activityModel.add(activity6);

        ActivityModel activity7 = new ActivityModel(R.drawable.ic_activity_movie, getString(R.string.activity_title7), getString(R.string.activity_description7));
        activityModel.add(activity7);

        recyclerViewActivity.setAdapter(new ActivityAdapter(activityModel));

        return root;
    }
}