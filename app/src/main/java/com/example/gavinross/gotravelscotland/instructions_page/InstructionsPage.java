package com.example.gavinross.gotravelscotland.instructions_page;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.HomePage;
import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.VideoFragment;

/**
 * Created by gavinross on 12/12/2017.
 */

public class InstructionsPage extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        int fragAdaptPos = getIntent().getIntExtra("fragAdaptPos", 0);
        int videoPosition = getIntent().getIntExtra("videoPosition", 0);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        InstructionFragmentPagerAdapter adapter = new InstructionFragmentPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);


        // set the fragment to be on the same item as it was before full screen was triggered
        viewPager.setCurrentItem(fragAdaptPos);


        android.support.v4.app.Fragment fragment =(android.support.v4.app.Fragment) adapter.getItem(fragAdaptPos);

        /*
        if (fragAdaptPos == 3) {
            VideoView videoView = findViewById(R.id.fragmentVideoView);
            //videoView.pause();
        } */


    }
}
