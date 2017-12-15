package com.example.gavinross.gotravelscotland.tours.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.VideoFragment;
import com.example.gavinross.gotravelscotland.tours.fragments.TourPageImage;
import com.example.gavinross.gotravelscotland.tours.fragments.TourPageVideo;

/**
 * Created by gavinross on 15/12/2017.
 */

public class IntoTheHighlandsAdapter extends FragmentPagerAdapter{
    private Context context; // set from the constructor

    /*
        Uses a Context obejct to pass in the activity using it. This is so the getString() will work
     */
    public IntoTheHighlandsAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    public Fragment getItem(int position) {
        if (position == 0) {
            // gets a ref to the activity through context then gets the string.
            Fragment fragOne = TourPageImage.newInstance(context.getString(R.string.the_departure),
                    context.getString(R.string.place_holder_para), R.drawable.dragon);
            return fragOne;
        } else if (position == 1) {
            Fragment fragTwo = TourPageVideo.newInstance(context.getString(R.string.the_departure),
                    context.getString(R.string.place_holder_para), R.raw.intro_tour);
            return fragTwo;
        } else if (position == 2) {
            Fragment fragThree = TourPageVideo.newInstance(context.getString(R.string.the_departure),
                    context.getString(R.string.place_holder_para), R.raw.intro_tour);
            return fragThree;
        } else if(position == 3) {
            Fragment fragFour = TourPageImage.newInstance(context.getString(R.string.the_departure),
                    context.getString(R.string.place_holder_para), R.drawable.dragon);
            return fragFour;
        }
        else
            return new VideoFragment();
    }

    public int getCount() {
        return 4;
    }
}
