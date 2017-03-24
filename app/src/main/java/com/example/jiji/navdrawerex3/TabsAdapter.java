package com.example.jiji.navdrawerex3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Jiji on 3/7/2017.
 */

public class TabsAdapter extends FragmentPagerAdapter {

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){

            case 0: return new Frag_four();
            case 1: return new Frag_five();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
