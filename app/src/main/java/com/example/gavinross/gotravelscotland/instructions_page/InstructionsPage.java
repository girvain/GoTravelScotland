package com.example.gavinross.gotravelscotland.instructions_page;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.gavinross.gotravelscotland.HomePage;
import com.example.gavinross.gotravelscotland.R;

/**
 * Created by gavinross on 12/12/2017.
 */

public class InstructionsPage extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        InstructionFragmentPagerAdapter adapter = new InstructionFragmentPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        Button startTour = (Button) findViewById(R.id.start_tour_button);
        startTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomePageIntent = new Intent(InstructionsPage.this, HomePage.class);
                startActivity(HomePageIntent);
            }
        });
    }
}
