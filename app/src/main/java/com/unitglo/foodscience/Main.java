package com.unitglo.foodscience;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


@SuppressLint("NewApi")
public class Main extends FragmentActivity {

    ViewPager Tab;
    TabLayout tabLayout;
    TabPagerAdapter TabAdapter;
    ActionBar actionBar;
    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        TabAdapter = new TabPagerAdapter(getSupportFragmentManager());
        Tab = findViewById(R.id.pager);
        Tab = findViewById(R.id.pager);

//		Tab.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//			@Override
//			public void onPageSelected(int position) {
//				actionBar = getActionBar();
//				actionBar.setSelectedNavigationItem(position);
//
//			}
//		});
        Tab.setAdapter(TabAdapter);


        tabLayout = findViewById(R.id.tabLayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Tab.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        Tab.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//		actionBar.addTab(actionBar.newTab().setText("Fruits")
//				.setTabListener(tabListener));
//		actionBar.addTab(actionBar.newTab().setText("Vegetables")
//				.setTabListener(tabListener));
    }
}