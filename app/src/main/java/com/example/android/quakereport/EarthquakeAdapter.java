package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by nagma on 07.28.16.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

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
        TextView quakeDistanceTextView = (TextView) listItemView.findViewById(R.id.distance);
        TextView quakeLocationTextView = (TextView) listItemView.findViewById(R.id.location);

        String location = currentQuake.getLocation();
        String distance = "", currentPlace = "";
        for (int i = 0; i < location.length(); i++){
            if (location.contains(LOCATION_SEPARATOR)){
                String[] place = location.split(LOCATION_SEPARATOR);
                distance = place[0] + LOCATION_SEPARATOR;
                currentPlace = place[1];
            }
        }
        quakeDistanceTextView.setText(distance);
        quakeLocationTextView.setText(currentPlace);

        // Sets date onto the layout
        TextView quakeDateTextView = (TextView) listItemView.findViewById(R.id.date_view);
        Date dateObject = new Date(currentQuake.getTime());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String date = dateFormatter.format(dateObject);
        quakeDateTextView.setText(date);

        // Sets time onto the layout
        TextView quakeTimeTextView = (TextView) listItemView.findViewById(R.id.time_view);
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String timeValue = timeFormatter.format(dateObject);
        quakeTimeTextView.setText(timeValue);

        return listItemView;
    }
}
