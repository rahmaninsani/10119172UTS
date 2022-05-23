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
import com.rahmaninsani.a10119172uts.adapter.MusicAdapter;
import com.rahmaninsani.a10119172uts.adapter.VideoAdapter;
import com.rahmaninsani.a10119172uts.model.MusicModel;
import com.rahmaninsani.a10119172uts.model.VideoModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MediaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MediaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MediaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MediaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MediaFragment newInstance(String param1, String param2) {
        MediaFragment fragment = new MediaFragment();
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

    // Music
    RecyclerView recyclerViewMusic;
    ArrayList<MusicModel> musicModel;


    // Video
    RecyclerView recyclerViewVideo;
    ArrayList<VideoModel> videoModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_media, container, false);

        // Music
        recyclerViewMusic = root.findViewById(R.id.media_musics);
        recyclerViewMusic.setLayoutManager(new LinearLayoutManager(getContext()));

        musicModel = new ArrayList<>();

        MusicModel music1 = new MusicModel(R.drawable.music_tulus, getString(R.string.media_music_title1), getString(R.string.media_music_singer1));
        musicModel.add(music1);

        MusicModel music2 = new MusicModel(R.drawable.music_alan_walker, getString(R.string.media_music_title2), getString(R.string.media_music_singer2));
        musicModel.add(music2);

        MusicModel music3 = new MusicModel(R.drawable.music_clean_bandit, getString(R.string.media_music_title3), getString(R.string.media_music_singer3));
        musicModel.add(music3);

        MusicModel music4 = new MusicModel(R.drawable.music_marron5, getString(R.string.media_music_title4), getString(R.string.media_music_singer4));
        musicModel.add(music4);

        MusicModel music5 = new MusicModel(R.drawable.music_sting, getString(R.string.media_music_title5), getString(R.string.media_music_singer5));
        musicModel.add(music5);

        MusicModel music6 = new MusicModel(R.drawable.music_queen, getString(R.string.media_music_title6), getString(R.string.media_music_singer6));
        musicModel.add(music6);

        recyclerViewMusic.setAdapter(new MusicAdapter(musicModel));

        // Video
        recyclerViewVideo = root.findViewById(R.id.media_videos);
        recyclerViewVideo.setLayoutManager(new LinearLayoutManager(getContext()));

        videoModel = new ArrayList<>();

        VideoModel video1 = new VideoModel(getString(R.string.media_video_id1));
        videoModel.add(video1);

        recyclerViewVideo.setAdapter(new VideoAdapter(videoModel, this.getLifecycle()));

        return root;
    }
}