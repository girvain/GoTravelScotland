package com.example.gavinross.gotravelscotland;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.gavinross.gotravelscotland.fragments.MessageFragmentOne;
import com.example.gavinross.gotravelscotland.fragments.MessageFragmentThree;
import com.example.gavinross.gotravelscotland.fragments.MessageFragmentTwo;
import com.example.gavinross.gotravelscotland.fragments.VideoFragment;

/**
 * Created by gavinross on 13/12/2017.
 */

public class StartHereFragmentPagerAdapter extends FragmentPagerAdapter{
    public StartHereFragmentPagerAdapter(FragmentManager fm) {
        super(fm);

    }


    public Fragment getItem(int position) {
        if (position == 0) {
            return new MessageFragmentOne();
        }
        else if (position == 1) {
            return new MessageFragmentTwo();
        }
        else if (position == 2) {
            return new MessageFragmentThree();
        }
        else
            return new VideoFragment();
    }

    public int getCount(){
        return 1;
    }
}
