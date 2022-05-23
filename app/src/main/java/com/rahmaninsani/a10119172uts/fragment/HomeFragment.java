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
import com.rahmaninsani.a10119172uts.adapter.GoalAdapter;
import com.rahmaninsani.a10119172uts.adapter.HobbyAdapter;
import com.rahmaninsani.a10119172uts.model.GoalModel;
import com.rahmaninsani.a10119172uts.model.HobbyModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    // Hobby
    RecyclerView recyclerViewHobby;
    ArrayList<HobbyModel> hobbyModel;

    // Goal
    RecyclerView recyclerViewGoal;
    ArrayList<GoalModel> goalModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Hobbies
        recyclerViewHobby = root.findViewById(R.id.home_hobbies);
        recyclerViewHobby.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        hobbyModel = new ArrayList<>();

        HobbyModel daily1 = new HobbyModel(R.drawable.ic_hobby_game, getString(R.string.my_hobby_1));
        hobbyModel.add(daily1);

        HobbyModel daily2 = new HobbyModel(R.drawable.ic_hobby_music, getString(R.string.my_hobby_2));
        hobbyModel.add(daily2);

        HobbyModel daily3 = new HobbyModel(R.drawable.ic_hobby_movie, getString(R.string.my_hobby_3));
        hobbyModel.add(daily3);

        HobbyModel daily4 = new HobbyModel(R.drawable.ic_hobby_nature, getString(R.string.my_hobby_4));
        hobbyModel.add(daily4);

        HobbyModel daily5 = new HobbyModel(R.drawable.ic_hobby_swimming, getString(R.string.my_hobby_5));
        hobbyModel.add(daily5);


        recyclerViewHobby.setAdapter(new HobbyAdapter(hobbyModel));

        // Goals
        recyclerViewGoal = root.findViewById(R.id.home_goals);
        recyclerViewGoal.setLayoutManager(new LinearLayoutManager(getContext()));

        goalModel = new ArrayList<>();

        GoalModel hobby1 = new GoalModel(R.drawable.ic_goal_laptop, getString(R.string.my_goal_1));
        goalModel.add(hobby1);

        GoalModel hobby2 = new GoalModel(R.drawable.ic_goal_entrepreneur, getString(R.string.my_goal_2));
        goalModel.add(hobby2);

        GoalModel hobby3 = new GoalModel(R.drawable.ic_goal_teacher, getString(R.string.my_goal_3));
        goalModel.add(hobby3);

        recyclerViewGoal.setAdapter(new GoalAdapter(goalModel));

        return root;
    }
}