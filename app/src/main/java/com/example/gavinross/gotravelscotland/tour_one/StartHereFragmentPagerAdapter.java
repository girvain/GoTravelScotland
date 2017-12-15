package com.example.gavinross.gotravelscotland.tour_one;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.MessageFragmentThree;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.VideoFragment;
import com.example.gavinross.gotravelscotland.tour_one.fragments.TourDeparturePage;
import com.example.gavinross.gotravelscotland.tour_one.fragments.TourSlideEndPage;
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
            // gets a ref to the activity through context then gets the string.
            Fragment fragOne = TourDeparturePage.newInstance(context.getString(R.string.the_departure),
                    context.getString(R.string.place_holder_para), R.drawable.dragon);
            return fragOne;
        }
        else if (position == 1) {
            Fragment fragTwo = TourSlidePage.newInstance(context.getString(R.string.the_departure),
                   context.getString(R.string.place_holder_para), R.raw.intro_tour);
            return fragTwo;
            //return new TourSlidePage();
        }
        else if (position == 2) {
            Fragment fragThree = TourSlideEndPage.newInstance(context.getString(R.string.the_departure),
                    context.getString(R.string.place_holder_para), R.raw.intro_tour);
            return fragThree;
        }
        else
            return new VideoFragment();
    }


    public int getCount(){
        return 4;
    }
}