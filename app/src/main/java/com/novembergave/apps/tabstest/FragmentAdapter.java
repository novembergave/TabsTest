package com.novembergave.apps.tabstest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by novembergave on 27/05/2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    public final static String LIST_BUNDLE = "BUNDLE";

    private List<String> numberOfMonths = new ArrayList<>();
    private List<String> wordsList = new ArrayList<>();
    private List<List<String>> allStrings = new ArrayList<>();

    public FragmentAdapter(FragmentManager fm, List<String> months, List<List<String>> words) {
        super(fm);
        this.numberOfMonths = months;
        this.allStrings = words;
    }

    @Override
    public Fragment getItem(int position) {
        wordsList = allStrings.get(position);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(LIST_BUNDLE, (ArrayList<String>) wordsList);
        Fragment newFragment = new FragmentActivity();
        newFragment.setArguments(bundle);
        return newFragment;
    }

    @Override
    public int getCount() {
        return numberOfMonths.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return numberOfMonths.get(position);
    }

    public void setList(List<String> list) {
//        this.wordsList = list;
    }
}
