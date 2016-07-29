package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nagma on 07.28.16.
 */
public class Earthquake {
    private String mLocation;
    private double mMagnitude;
//    private String mDate;
    private long mTime;

    public Earthquake(double magnitude, String location, long time){
        this.mLocation = location;
        this.mMagnitude = magnitude;
        this.mTime = time;
    }

//    public Earthquake(String date){
//        this.mDate = date;
//    }

    public String getLocation(){
        return mLocation;
    }

    public double getMagnitude(){
        return mMagnitude;
    }

    public long getTime(){ return mTime; }

//    public String getDate(){ return mDate; }
}
