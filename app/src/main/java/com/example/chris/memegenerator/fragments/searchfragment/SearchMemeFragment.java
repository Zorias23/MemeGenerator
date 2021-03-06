package com.example.chris.memegenerator.fragments.searchfragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.chris.memegenerator.R;
import com.example.chris.memegenerator.fragments.memesliderfrag.MemeSliderFragment;
import com.example.chris.memegenerator.util.Image;
import com.example.chris.memegenerator.util.MemeSliderAdapter;
import com.example.chris.memegenerator.util.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchMemeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchMemeFragment extends Fragment {
    private List<String> memes;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView rvSearchMeme;
    private List<Image> imageList;
    private FloatingActionButton btnSearch;


    public SearchMemeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchMemeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchMemeFragment newInstance(String param1, String param2) {
        SearchMemeFragment fragment = new SearchMemeFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_search_meme, container, false);
        btnSearch = view.findViewById(R.id.btnSearchMemes);
        memes=new ArrayList<>();
        rvSearchMeme = view.findViewById(R.id.rvSearchMeme);
        rvSearchMeme.setLayoutManager(new GridLayoutManager(this.getActivity(),2));

//        ViewPager viewPager = view.findViewById(R.id.imageSliderPager);
//        MemeSliderAdapter memeSliderAdapter = new MemeSliderAdapter(this.getActivity());
//        viewPager.setAdapter(memeSliderAdapter);
        loadInterestTrending();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }


    private void loadInterestTrending()
    {
        imageList = new ArrayList<>();
        // memes.clear();
        for (int i = 0; i < 10; i++) {
            //  memes.add("https://loremflickr.com/320/240?random=3");
            imageList.add(new Image("https://loremflickr.com/320/240"));
        }
        Log.d("TAg", "loadInterestTrending: "+ imageList.size());
//        memes.clear();
//        for (int i = 0; i < 10; i++)
//            memes.add("https://loremflickr.com/320/240");

        rvSearchMeme.setAdapter(new RecyclerAdapter(imageList, new RecyclerAdapter.onMemeClickListner() {
            @Override
            public void onMemeClick(Image image) {
                Toast.makeText(getContext(), "Item Clicked"+image.getImageUrl(), Toast.LENGTH_LONG).show();
                MemeSliderFragment memeSliderFragment = MemeSliderFragment.newInstance(imageList, image.getImageUrl());
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.searchFragmentFrame,memeSliderFragment, "Slider").addToBackStack("Slider").commit();

            }
        }));
    }
}
