package com.novembergave.apps.tabstest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by novembergave on 27/05/2017.
 */

public class FragmentActivity extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerAdapter;
    private List<String> wordList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recyclerview, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);

        recyclerAdapter = new RecyclerViewAdapter(getContext(), wordList);
        recyclerView.setAdapter(recyclerAdapter);

        return rootView;
    }

    public void setWordList(List<String> list) {
        this.wordList = list;
    }
}
