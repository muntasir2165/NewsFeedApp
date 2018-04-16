package com.example.android.newsfeedapp;

/**
 * Created by Houst on 2018-04-11.
 */

import android.graphics.Bitmap;

/**
 * A {@link News} object contains information related to a news item.
 */
public class News {

    /** Title of the news item */
    private String mTitle;

    /** Section that the news item belongs to*/
    private String mSection;

    /** url of the thumbnail image of the news item */
    private Bitmap mThumbnailBitmap;

    /** publication date of th news item */
    private String mPublicationDate;

    /** Website URL of the news item */
    private String mUrl;

    public News(String title, String section, Bitmap thumbnailBitmap, String publicationDate, String url) {
        this.mTitle = title;
        this.mSection = section;
        this.mThumbnailBitmap = thumbnailBitmap;
        this.mPublicationDate = publicationDate;
        this.mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSection() {
        return mSection;
    }

    public Bitmap getThumbnailBitmap() {
        return mThumbnailBitmap;
    }

    public String getPublicationDate() {
        return mPublicationDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
