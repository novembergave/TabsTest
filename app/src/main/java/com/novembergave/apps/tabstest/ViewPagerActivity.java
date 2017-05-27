package com.novembergave.apps.tabstest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by novembergave on 27/05/2017.
 * Using https://stackoverflow.com/questions/13664155/dynamically-add-and-remove-view-to-viewpager
 */

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPagerAdapter pagerAdapter = null;
    private ViewPager viewPager = null;
    private TabLayout tabLayout;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;
    private TextView textView;

    private List<String> listA = new ArrayList<>();
    private List<String> listB = new ArrayList<>();
    private List<String> listC = new ArrayList<>();
    private List<String> listD = new ArrayList<>();
    private List<String> months = new ArrayList<>();
    private List<String> totals = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_main);

        setUpLists();
        createTotalList();

        textView = (TextView) findViewById(R.id.overview_text);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        pagerAdapter = new ViewPagerAdapter(months);
        viewPager.setAdapter(pagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
//                switch (position) {
//                    case 0: textView.setText("Jan");
//                        break;
//                    case 1: textView.setText("Feb");
//                        break;
//                    case 2: textView.setText("March");
//                        break;
//                    case 3: textView.setText("April");
//                        break;
//                    case 4: textView.setText("May");
//                        break;
//                    default: textView.setText("oops");
//                }
                textView.setText(totals.get(position));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        setUpViews();

    }

    //-----------------------------------------------------------------------------
    // Here's what the app should do to add a view to the ViewPager.
    public void addView (View newPage)
    {
        int pageIndex = pagerAdapter.addView (newPage);
        // You might want to make "newPage" the currently displayed page:
        viewPager.setCurrentItem (pageIndex, true);
    }

    //-----------------------------------------------------------------------------
    // Here's what the app should do to remove a view from the ViewPager.
    public void removeView (View defunctPage)
    {
        int pageIndex = pagerAdapter.removeView (viewPager, defunctPage);
        // You might want to choose what page to display, if the current page was "defunctPage".
        if (pageIndex == pagerAdapter.getCount())
            pageIndex--;
        viewPager.setCurrentItem (pageIndex);
    }

    //-----------------------------------------------------------------------------
    // Here's what the app should do to get the currently displayed page.
    public View getCurrentPage ()
    {
        return pagerAdapter.getView (viewPager.getCurrentItem());
    }

    //-----------------------------------------------------------------------------
    // Here's what the app should do to set the currently displayed page.  "pageToShow" must
    // currently be in the adapter, or this will crash.
    public void setCurrentPage (View pageToShow)
    {
        viewPager.setCurrentItem (pagerAdapter.getItemPosition (pageToShow), true);
    }

    private void setUpViews() {
        for (int i = 0; i < months.size(); ++i) {
            Log.d("viewsSetUp", String.valueOf(i));
            LayoutInflater inflater = this.getLayoutInflater();
            View newView = inflater.inflate (R.layout.recyclerview, null);
            recyclerView = (RecyclerView) newView.findViewById(R.id.my_recycler_view);
            recyclerViewAdapter = new RecyclerViewAdapter(this, listB);
            recyclerView.setLayoutManager(new LinearLayoutManager(newView.getContext()));
            recyclerView.setAdapter(recyclerViewAdapter);
            addView(newView);
            pagerAdapter.notifyDataSetChanged();
        }

    }

    private void createTotalList() {
        for (int i = 0; i < months.size(); i++) {
            totals.add(String.valueOf(i));
        }
    }

    private void setUpLists() {
        months.add("Jan");
        months.add("Feb");
        months.add("March");
        months.add("April");
        months.add("May");

        listA.add("A1");
        listA.add("A1");
        listA.add("A1");
        listA.add("A1");
        listA.add("A1");

        listB.add("B1");
        listB.add("B1");
        listB.add("B1");
        listB.add("B1");

        listC.add("C1");
        listC.add("C1");
        listC.add("C1");
        listC.add("C1");
        listC.add("C1");

        listD.add("D1");
        listD.add("D1");
        listD.add("D1");
    }
}
