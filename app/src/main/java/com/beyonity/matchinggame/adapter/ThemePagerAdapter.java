package com.beyonity.matchinggame.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.beyonity.matchinggame.fragments.themeFragment;

public class ThemePagerAdapter extends FragmentPagerAdapter {

    private int size;

    public ThemePagerAdapter(FragmentManager fm, int size) {
        super(fm);
        this.size = size;
    }

    @Override
    public Fragment getItem(int position) {
        return themeFragment.newInstance(position + "");
    }

    @Override
    public int getCount() {
        return size;
    }
}
