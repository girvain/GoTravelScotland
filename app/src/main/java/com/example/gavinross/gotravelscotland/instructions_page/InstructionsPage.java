package com.example.gavinross.gotravelscotland.instructions_page;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.HomePage;
import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.VideoFragment;
import com.pixelcan.inkpageindicator.InkPageIndicator;

/**
 * Created by gavinross on 12/12/2017.
 */

public class InstructionsPage extends AppCompatActivity {

    InkPageIndicator inkPageIndicator;
    ViewPager viewPager;

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



        /*
        if (fragAdaptPos == 3) {
            VideoView videoView = findViewById(R.id.fragmentVideoView);
            //videoView.pause();
        } */


    }

    public void hideDots() {
        inkPageIndicator.setVisibility(View.INVISIBLE);
    }
}
