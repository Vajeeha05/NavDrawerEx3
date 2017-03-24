package com.example.jiji.navdrawerex3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Fragment_One extends Fragment {

    private ViewPager viewPager;
    private TabsAdapter adapter;
    private TabLayout tabLayout;


    private String [] tabs = {"Student details","College details"};


    public Fragment_One() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_fragment__one, container, false);

        tabLayout = (TabLayout)view.findViewById(R.id.tab_Layout);
        tabLayout.addTab(tabLayout.newTab().setText("bbb"));
        tabLayout.addTab(tabLayout.newTab().setText("aaa"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        adapter = new TabsAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);;
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;

    }

}
