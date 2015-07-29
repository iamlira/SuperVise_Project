package com.juanliu.captain.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.juanliu.captain.activity.MainActivity;
import com.juanliu.captain.fragment.FindFragment;
import com.juanliu.captain.fragment.MineFragment;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    public final static int TAB_COUNT = 2;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int id) {
        switch (id) {
            case MainActivity.FIND_TAB:
                FindFragment findFragment=new FindFragment();
                return findFragment;
            case MainActivity.MINE_TAB:
                MineFragment findFragment1=new MineFragment();
                return findFragment1;
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return TAB_COUNT;
    }

}
