package com.example.gavinross.gotravelscotland.tour_one;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.MessageFragmentOne;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.MessageFragmentThree;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.MessageFragmentTwo;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.VideoFragment;
import com.example.gavinross.gotravelscotland.tour_one.fragments.DeparturePage;
import com.example.gavinross.gotravelscotland.tour_one.fragments.TourSlidePage;

/**
 * Created by gavinross on 13/12/2017.
 */

public class StartHereFragmentPagerAdapter extends FragmentPagerAdapter{

    private Context context; // set from the constructor

    /*
        Uses a Context obejct to pass in the activity using it. This is so the getString() will work
     */
    public StartHereFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    public Fragment getItem(int position) {
        if (position == 0) {

            Fragment fragOne = DeparturePage.newInstance(context.getString(R.string.the_departure));
            return fragOne;
        }
        else if (position == 1) {
            return new TourSlidePage();
        }
        else if (position == 2) {
            return new MessageFragmentThree();
        }
        else
            return new VideoFragment();
    }


    public int getCount(){
        return 4;
    }
}
