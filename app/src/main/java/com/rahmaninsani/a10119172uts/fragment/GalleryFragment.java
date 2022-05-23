/*
    NIM     : 10119172
    Nama    : Rahman Insani
    Kelas   : IF-5

    Selasa, 08 Mei 2022
*/

package com.rahmaninsani.a10119172uts.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rahmaninsani.a10119172uts.R;
import com.rahmaninsani.a10119172uts.adapter.GalleryAdapter;
import com.rahmaninsani.a10119172uts.model.GalleryModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GalleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
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

    // Gallery
    RecyclerView recyclerViewGallery;
    ArrayList<GalleryModel> galleryModel;
    private StaggeredGridLayoutManager manager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        // Gallery
        recyclerViewGallery = root.findViewById(R.id.gallery_body);
        manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerViewGallery.setLayoutManager(manager);

        galleryModel = new ArrayList<>();

        GalleryModel gallery1 = new GalleryModel(R.drawable.gallery1);
        galleryModel.add(gallery1);
        GalleryModel gallery2 = new GalleryModel(R.drawable.gallery2);
        galleryModel.add(gallery2);
        GalleryModel gallery3 = new GalleryModel(R.drawable.gallery3);
        galleryModel.add(gallery3);

        recyclerViewGallery.setAdapter(new GalleryAdapter(galleryModel));

        return root;
    }
}