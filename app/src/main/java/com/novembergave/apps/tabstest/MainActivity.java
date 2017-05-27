package com.novembergave.apps.tabstest;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> listA = new ArrayList<>();
    private List<String> listB = new ArrayList<>();
    private List<String> listC = new ArrayList<>();
    private List<String> listD = new ArrayList<>();
    private List<String> months = new ArrayList<>();

    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        setUpLists();

        tabLayout.setupWithViewPager(viewPager);
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
