/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.newsfeedapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * A {@link NewsAdapter} knows how to create a list item layout for each news item
 * in the data source (a list of {@link News} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /** Tag for log messages */
    private static final String LOG_TAG = NewsAdapter.class.getName();
    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param newsItemsList is the list of news items, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> newsItemsList) {
        super(context, 0, newsItemsList);
    }

    /**
     * Returns a list item view that displays information about the news item at the given position
     * in the list of news items.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the new item at the given position in the list of news items
        News newsItem = getItem(position);

        // Find the TextView with view ID news_title_text_view
        TextView newsItemTitleTextView = (TextView) listItemView.findViewById(R.id.news_title_text_view);
        // Display the title of the current news item in that TextView
        newsItemTitleTextView.setText(newsItem.getTitle());

        // Find the TextView with view ID author_text_view
        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author_text_view);
        // Display the author of the current news item in that TextView
        // If the author string is empty or null, then print out "by Unknown Author"
        authorTextView.setText("by " + (TextUtils.isEmpty(newsItem.getAuthor())? "Unknown Author" : newsItem.getAuthor()));

        // Find the TextView with view ID section_text_view
        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section_text_view);
        // Display the section of the current news item in that TextView
        sectionTextView.setText(newsItem.getSection());

        // Find the TextView with view ID publication_date_text_view
        TextView publicationDateTextView = (TextView) listItemView.findViewById(R.id.publication_date_text_view);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = null;
        try {
            date = format.parse(newsItem.getPublicationDate());
        } catch (ParseException e) {
            Log.e(LOG_TAG, "Problem parsing the news item datetime string", e);
        }
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(date);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(date);
        // Display the publication time of the current news item in that TextView
        publicationDateTextView.setText(formattedDate + " " + formattedTime);

        // Find the ImageView in the news_list_item.xml layout with the ID news_item_image_view.
        ImageView thumbnailImageView = (ImageView) listItemView.findViewById(R.id.news_item_image_view);
        // Set the thumbnail image bitmap
        thumbnailImageView.setImageBitmap(formatImageFromBitmap(newsItem.getThumbnailBitmap()));
        // Make sure the view is visible
        thumbnailImageView.setVisibility(View.VISIBLE);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the news item thumbnail image bitmap or a blank bitmap
     */
    private Bitmap formatImageFromBitmap(Bitmap thumbnailBitmap) {
        //Bitmap for image
        Bitmap returnBitmap;

        //Check if the thumbnailBitmap is null
        if (thumbnailBitmap == null) {
            //If thumbnailBitmap is null, return a default image
            returnBitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.noimage);
        } else {
            returnBitmap = thumbnailBitmap;
        }

        return returnBitmap;
    }

}
