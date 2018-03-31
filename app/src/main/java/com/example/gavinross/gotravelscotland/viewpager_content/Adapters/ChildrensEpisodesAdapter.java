package com.example.gavinross.gotravelscotland.viewpager_content.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.VideoFragment;
import com.example.gavinross.gotravelscotland.viewpager_content.fragments.TourPageImage;
import com.example.gavinross.gotravelscotland.viewpager_content.fragments.TourPageVideo;

/**
 * Created by gavin on 19/03/18.
 */

public class ChildrensEpisodesAdapter extends FragmentPagerAdapter {
    private Context context; // set from the constructor

    /*
        Uses a Context obejct to pass in the activity using it. This is so the getString() will work
     */
    public ChildrensEpisodesAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    public Fragment getItem(int position) {
        if (position == 0) {
            Fragment fragOne = TourPageVideo.newInstance(context.getString(R.string.children_page_ep1_title),
                    context.getString(R.string.children_page_ep1_para),
                    "mnt/extSdCard/intro_tour.mp4");
            return fragOne;
        } else if (position == 1) {
            Fragment fragTwo = TourPageVideo.newInstance(context.getString(R.string.the_departure),
                    context.getString(R.string.place_holder_para), "mnt/extSdCard/intro_tour.mp4");
            return fragTwo;
        } else
            return new VideoFragment(); //?
    }

    public int getCount() {
        return 2;
    }
}
