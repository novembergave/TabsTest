package com.novembergave.apps.tabstest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by novembergave on 27/05/2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    private List<String> numberOfMonths;
    private List<String> wordsList;

    public FragmentAdapter(FragmentManager fm, List<String> months) {
        super(fm);
        this.numberOfMonths = months;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment newFragment = new FragmentActivity();
        return newFragment;
    }

    @Override
    public int getCount() {
        return numberOfMonths.size();
    }
}
