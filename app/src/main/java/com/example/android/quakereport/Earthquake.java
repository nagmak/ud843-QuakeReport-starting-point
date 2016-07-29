package com.example.android.quakereport;

/**
 * Created by nagma on 07.28.16.
 */
public class Earthquake {
    private String mLocation;
    private double mMagnitude;
    //private String mDate;
    private int mTime;

    public Earthquake(double magnitude, String location, int time){
        this.mLocation = location;
        this.mMagnitude = magnitude;
        this.mTime = time;
    }

    public String getLocation(){
        return mLocation;
    }

    public double getMagnitude(){
        return mMagnitude;
    }

    public int getTime(){
        return mTime;
    }
}
