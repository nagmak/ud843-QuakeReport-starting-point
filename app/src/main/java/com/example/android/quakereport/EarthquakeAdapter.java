package com.example.android.quakereport;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
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
        final Earthquake currentQuake = getItem(position);

        // Sets the magnitude value on the layout
        TextView quakeMagnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        DecimalFormat decimalFormatter = new DecimalFormat("0.0");
        String magnitudeValue = decimalFormatter.format(currentQuake.getMagnitude());
        quakeMagnitudeTextView.setText(magnitudeValue);
        GradientDrawable magnitudeCircle = (GradientDrawable) quakeMagnitudeTextView.getBackground();

        // Returns magnitude color id, converts into the actual color value
        int magnitudeColor = getMagnitudeColor(currentQuake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

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

        LinearLayout clickView = (LinearLayout) listItemView.findViewById(R.id.text_container);
        clickView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openCurrentQuakeSite(currentQuake.getWebsite());
            }
        });

        return listItemView;
    }

    // Returns background color for the corresponding magnitude
    private int getMagnitudeColor(double magnitude){
        int magnitudeFloor = (int) Math.floor(magnitude);
        int magColorID = 0;

        switch (magnitudeFloor) {
            case 0:
            case 1:
                magColorID = R.color.magnitude1;
                break;
            case 2:
                magColorID = R.color.magnitude2;
                break;
            case 3:
                magColorID = R.color.magnitude3;
                break;
            case 4:
                magColorID = R.color.magnitude4;
                break;
            case 5:
                magColorID = R.color.magnitude5;
                break;
            case 6:
                magColorID = R.color.magnitude6;
                break;
            case 7:
                magColorID = R.color.magnitude7;
                break;
            case 8:
                magColorID = R.color.magnitude8;
                break;
            case 9:
                magColorID = R.color.magnitude9;
                break;
            default:
                magColorID = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magColorID);
    }

    // Opens current earthquake's webpage on click
    private void openCurrentQuakeSite(String website){
        Uri webpage = Uri.parse(website);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            getContext().startActivity(intent);
        }
    }
}
