package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter (Context context, ArrayList<Earthquake> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rootview = convertView;
        if (rootview == null) rootview = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_item, parent, false);

        TextView nearby = rootview.findViewById(R.id.nearby_textview);
        TextView city = rootview.findViewById(R.id.city_textview);
        TextView mag = rootview.findViewById(R.id.mag_textview);
        TextView date = rootview.findViewById(R.id.date_textview);
        TextView hour = rootview.findViewById(R.id.hour_textview);

        Earthquake earthquake = getItem(position);

        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();
        int magnitudeColor = getMagnitudeColor(earthquake.getMag());
        magnitudeCircle.setColor(magnitudeColor);
        mag.setText(new DecimalFormat("0.0").format(earthquake.getMag()));

        String place = earthquake.getCity();
        if (!place.contains(" of ")) {
            nearby.setText(R.string.near_the);
            city.setText(place);
        }
        else {
            nearby.setText(place.substring(0, (place.indexOf(" of ") + 3)));
            city.setText(place.substring((place.indexOf(" of ") + 4), place.length()));
        }

        date.setText(new SimpleDateFormat("dd MMM, yyyy", Locale.US).format(earthquake.getDate()));
        hour.setText(new SimpleDateFormat("HH:mm", Locale.US).format(earthquake.getDate()));


        return rootview;
    }

    private int getMagnitudeColor(double mag) {
        switch ((int) Math.floor(mag)){
            case 0:
            case 1: return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 2: return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3: return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4: return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5: return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6: return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7: return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8: return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9: return ContextCompat.getColor(getContext(), R.color.magnitude9);
            default: return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }
    }
}
