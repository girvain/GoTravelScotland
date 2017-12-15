package com.example.gavinross.gotravelscotland.instructions_page;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.widget.Button;

import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.MessageFragWithButton;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.MessageFragmentOne;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.MessageFragmentThree;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.MessageFragmentTwo;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.VideoFragment;

/**
 * Created by gavinross on 12/12/2017.
 */

public class InstructionFragmentPagerAdapter extends FragmentStatePagerAdapter{

    public InstructionFragmentPagerAdapter(FragmentManager fm) {
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
        else if (position == 3) {
            return new VideoFragment();
        }
        else
            return new MessageFragWithButton();
    }

    public int getCount() {
        return 5;
    }


}
