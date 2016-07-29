package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nagma on 07.28.16.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_activity, parent, false);
        }

        // Gets the current quake's information at this position in the index
        Earthquake currentQuake = getItem(position);

        // Sets the magnitude value on the layout
        TextView quakeMagnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        String magnitudeValue = Double.toString(currentQuake.getMagnitude()); // converts magnitude to string value
        quakeMagnitudeTextView.setText(magnitudeValue);

        // Sets location onto the layout
        TextView quakeLocationTextView = (TextView) listItemView.findViewById(R.id.location);
        quakeLocationTextView.setText(currentQuake.getLocation());

        // Sets date onto the layout
        TextView quakeDateTextView = (TextView) listItemView.findViewById(R.id.date_view);
        String timeValue = Double.toString(currentQuake.getTime());
        quakeDateTextView.setText(timeValue);

        return listItemView;
    }
}
