package com.example.gavinross.gotravelscotland.custom_array_adapter_content;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gavinross.gotravelscotland.HomePage;
import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.TourHomePage;

import java.util.ArrayList;

/**
 * Created by gavin on 18/03/18.
 */

public class ListItemArrayAdapter extends ArrayAdapter<BasicItem>  {

    public ListItemArrayAdapter(Context context, ArrayList<BasicItem> basicItems) {
        super(context, 0, basicItems);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link BasicItem} object located at this position in the list
        BasicItem currentAd = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView adTitle = (TextView) listItemView.findViewById(R.id.ad_title_text_view);
        adTitle.setText(currentAd.getName());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView adPara = (TextView) listItemView.findViewById(R.id.ad_para_text_view);
        adPara.setText(currentAd.getDescription());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.ad_image);

        // Check if an image is provided for this advert or not
        if (currentAd.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentAd.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}