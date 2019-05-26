package com.example.tourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment {


    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);
        ListView listView = rootView.findViewById(R.id.list);
        ArrayList<Attraction> attractions = new ArrayList<Attraction>() {
            {
                add(new Attraction("Chickpet", Uri.parse("geo:0,0?q=12.970547,77.575447 (Chickpet)"), "https://en.wikipedia.org/wiki/Chickpet", R.drawable.chickpet));
                add(new Attraction("Brigade Road", Uri.parse("geo:0,0?q=12.971335, 77.606859 (Brigade Road)"), "https://en.wikipedia.org/wiki/Brigade_Road", R.drawable.brigade));
                add(new Attraction("Commercial Street", Uri.parse("geo:0,0?q=12.982461, 77.608359 (Commercial Street)"), "https://en.wikipedia.org/wiki/Commercial_Street,_Bangalore", R.drawable.commercial));
                add(new Attraction("Majestic", Uri.parse("geo:0,0?q=12.977941, 77.572414 (Majestic)"), "https://en.wikipedia.org/wiki/Kempegowda_Bus_Station", R.drawable.majestic));
                add(new Attraction("MG Road", Uri.parse("geo:0,0?q=12.974977, 77.609386 (MG Road)"), "https://en.wikipedia.org/wiki/M_G_Road,_Bangalore", R.drawable.mgroad));
            }
        };
        ArrayAttractionAdapter arrayAttractionAdapter = new ArrayAttractionAdapter(getActivity(), attractions);
        listView.setAdapter(arrayAttractionAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                long viewId = view.getId();
                Attraction sightseeing = (Attraction) parent.getItemAtPosition(position);

                if (viewId == R.id.location_button) {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(sightseeing.getmLatLng());
                } else {
                    Uri webpage = Uri.parse(sightseeing.getmUrl());
                    intent = new Intent(Intent.ACTION_VIEW, webpage);
                }
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        return rootView;
    }

}
