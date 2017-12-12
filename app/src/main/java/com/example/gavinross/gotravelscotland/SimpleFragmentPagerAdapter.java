package com.example.gavinross.gotravelscotland;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by gavinross on 12/12/2017.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter{

    private ArrayList<MessageData> messageDataArrayList;

    public SimpleFragmentPagerAdapter(FragmentManager fm, ArrayList<MessageData> messageItemArray) {
        super(fm);
        messageDataArrayList = messageItemArray;
    }


    public Fragment getItem(int position) {
        if (messageDataArrayList.get(position).isVideo()) {
            VideoFragment fragmentVid = new VideoFragment();
            return fragmentVid;
        }
        else {
            MessageFragment fragmentMsg = new MessageFragment();
            fragmentMsg.setMessage(messageDataArrayList.get(position).getMessage());
            return fragmentMsg;
        }


    }

    public int getCount() {
        return 4;
    }


}
