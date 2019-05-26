package com.example.tourguide;

import android.net.Uri;

public class Attraction {
    private String mName;
    private Uri mLatLng;
    private String mUrl;
    private int mImageId;

    public Attraction(String name, Uri latlng, String url, int imageId) {
        mName = name;
        mLatLng = latlng;
        mUrl = url;
        mImageId = imageId;
    }

    public String getmName() {
        return mName;
    }

    public Uri getmLatLng() {
        return mLatLng;
    }

    public String getmUrl() {
        return mUrl;
    }

    public int getmImageId() {
        return mImageId;
    }
}
