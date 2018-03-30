package com.example.gavinross.gotravelscotland.tour_activities.heros_and_freedom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.tour_activities.TourActivity;

public class BattleOfBannockbunPage extends TourActivity {
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);

        TextView mHeadingTextView = (TextView) findViewById(R.id.heading);
        TextView mParagraphView = (TextView) findViewById(R.id.paragraph);
        ImageButton largePlayButton = (ImageButton)findViewById(R.id.largePlayButton);
        ImageButton nextActivity = (ImageButton) findViewById(R.id.nextSlideButton);

        String videoFilePath = "android.resource://" + getPackageName() + "/" +
                R.raw.gts_commando_memorial_multi;
        mHeadingTextView.setText(R.string.battle_of_bannockburn_title);
        mParagraphView.setText(R.string.battle_of_bannockburn_para);


        // Pass in the next activity it's going to
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BattleOfBannockbunPage.this, RecognitionOfScotInde.class);
                startActivity(intent);

            }
        });
    }
}
