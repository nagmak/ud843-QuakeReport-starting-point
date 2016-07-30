package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nagma on 07.28.16.
 */
public class Earthquake {
    private String mLocation;
    private String mWebsite;
    private double mMagnitude;
    private long mTime;

    public Earthquake(double magnitude, String location, long time, String website){
        this.mLocation = location;
        this.mMagnitude = magnitude;
        this.mTime = time;
        this.mWebsite = website;
    }

    public String getLocation(){
        return mLocation;
    }

    public double getMagnitude(){
        return mMagnitude;
    }

    public long getTime(){ return mTime; }

    public String getWebsite(){ return mWebsite; }
}
