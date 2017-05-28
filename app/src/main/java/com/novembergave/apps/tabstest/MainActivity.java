package com.novembergave.apps.tabstest;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> listA = new ArrayList<>();
    private List<String> listB = new ArrayList<>();
    private List<String> listC = new ArrayList<>();
    private List<String> listD = new ArrayList<>();
    private List<String> months = new ArrayList<>();
    private List<String> totals = new ArrayList<>();
    private List<List<String>> allStrings = new ArrayList<>();

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView text;
    private FragmentAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String currentMonth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.overview_text);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onSwipe();
            }
        });

        setUpLists();
        createTotalList();
        addAllStrings();

        currentMonth = "May";
        text.setText(totals.get(months.indexOf(currentMonth)));

        adapter = new FragmentAdapter(getSupportFragmentManager(), months, allStrings);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(months.indexOf(currentMonth));

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("tabposition", String.valueOf(position));
                text.setText(totals.get(position));

                if (position != months.indexOf(currentMonth)) {
                    Log.d("onTabSelected", "currentMonth refresh true");
                    swipeRefreshLayout.setEnabled(false);
                } else {
                    swipeRefreshLayout.setEnabled(true);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("tab unselected position", String.valueOf(position));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void onSwipe() {
        Log.d("swiped", "refresh!");
        listC.add("C Extra!");
        addAllStrings();
        adapter = new FragmentAdapter(getSupportFragmentManager(), months, allStrings);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(months.indexOf(currentMonth));
        swipeRefreshLayout.setRefreshing(false);
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

    private void createTotalList() {
        for (int i = 0; i < months.size(); i++) {
            totals.add(String.valueOf(i));
        }
    }

    private void addAllStrings() {
        allStrings = new ArrayList<>();
        allStrings.add(listA);
        allStrings.add(listB);
        allStrings.add(listC);
        allStrings.add(listD);
        allStrings.add(listC);
    }
}
