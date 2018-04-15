package com.example.android.newsfeedapp;

/**
 * Created by Houst on 2018-04-11.
 */

/**
 * A {@link News} object contains information related to a news item.
 */
public class News {

    /** Title of the news item */
    private String mTitle;

    /** Section that the news item belongs to*/
    private String mSection;

    /** url of the thumbnail image of the news item */
    private String mImageUrl;

    /** publication date of th news item */
    private String mPublicationDate;

    /** Website URL of the news item */
    private String mUrl;

    public News(String title, String section, String imageUrl, String publicationDate, String url) {
        this.mTitle = title;
        this.mSection = section;
        this.mImageUrl = imageUrl;
        this.mPublicationDate = publicationDate;
        this.mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSection() {
        return mSection;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getPublicationDate() {
        return mPublicationDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
