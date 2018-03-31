package com.example.gavinross.gotravelscotland.viewpager_content.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.VideoFragment;
import com.example.gavinross.gotravelscotland.viewpager_content.fragments.TourPageAd;
import com.example.gavinross.gotravelscotland.viewpager_content.fragments.TourPageImage;
import com.example.gavinross.gotravelscotland.viewpager_content.fragments.TourPageVideo;

/**
 * Created by gavinross on 13/12/2017.
 */

public class StartHereAdapter extends FragmentPagerAdapter {

    private Context context; // set from the constructor

    /*
        Uses a Context obejct to pass in the activity using it. This is so the getString() will work
     */
    public StartHereAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    public Fragment getItem(int position) {
        if (position == 0) {
            // gets a ref to the activity through context then gets the string.
            Fragment fragOne = TourPageImage.newInstance(context.getString(R.string.the_departure),
                    context.getString(R.string.place_holder_para), R.drawable.dragon);
            return fragOne;
//        } else if (position == 1) {
//            Fragment fragTwo = TourPageVideo.newInstance(context.getString(R.string.the_departure),
//                    context.getString(R.string.place_holder_para), R.raw.intro_tour);
//            return fragTwo;
//        } else if (position == 2) {
//            Fragment fragThree = TourPageVideo.newInstance(context.getString(R.string.the_departure),
//                    context.getString(R.string.place_holder_para), R.raw.intro_tour);
//            return fragThree;
//        } else if (position == 3) {
//            Fragment fragFour = TourPageImage.newInstance(context.getString(R.string.the_departure),
//                    context.getString(R.string.place_holder_para), R.drawable.dragon);
//            return fragFour;
//        } else if (position == 4) {
//            Fragment fragFive = TourPageAd.newInstance(R.raw.intro_tour);
//            return fragFive;
        }

        else
            return new VideoFragment();
    }


    public int getCount() {
        return 5;
    }
}
