package com.example.gavinross.gotravelscotland.whats_on_classes;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gavinross.gotravelscotland.R;

import java.util.ArrayList;

/**
 * Created by gavin on 18/03/18.
 */

public class AdvertArrayAdapter extends ArrayAdapter<Advert>  {

    public AdvertArrayAdapter(Context context, ArrayList<Advert> adverts) {
        super(context, 0, adverts);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Advert currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getName());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDescription());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.ad_image);
        // Check if an image is provided for this word or not
        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentWord.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}