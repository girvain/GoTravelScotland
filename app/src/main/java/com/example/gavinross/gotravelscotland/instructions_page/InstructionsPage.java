package com.example.gavinross.gotravelscotland.instructions_page;

import android.app.Fragment;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TableLayout;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.FullScreenMediaController;
import com.example.gavinross.gotravelscotland.HomePage;
import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.VideoFragment;
import com.pixelcan.inkpageindicator.InkPageIndicator;

/**
 * Created by gavinross on 12/12/2017.
 */

public class InstructionsPage extends AppCompatActivity
        implements VideoFragment.OnHeadlineSelectedListener {



    InkPageIndicator inkPageIndicator;
    ViewPager viewPager;
    android.support.v4.app.Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        inkPageIndicator = (InkPageIndicator) findViewById(R.id.indicator);


        // Create an adapter that knows which fragment should be shown on each page
        final InstructionFragmentPagerAdapter adapter = new InstructionFragmentPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
        inkPageIndicator.setViewPager(viewPager);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                fragment = adapter.getItem(position);

                onArticleSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void onArticleSelected(int position) {
        final VideoView v = (VideoView)findViewById(R.id.videoView5);
        final VideoView h = (VideoView)findViewById(R.id.fragmentVideoView);
        if (v != null) {
            Toast.makeText(this, "Article Selected", Toast.LENGTH_SHORT).show();
            if (v.isShown()) {
                //inkPageIndicator.setVisibility(View.INVISIBLE);
            }

        }
    }


}
