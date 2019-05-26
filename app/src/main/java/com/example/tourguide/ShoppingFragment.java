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
                add(new Attraction(getActivity().getString(R.string.chickpet_name), Uri.parse(getActivity().getString(R.string.chickpet_location)), getActivity().getString(R.string.chickpet_link), R.drawable.chickpet));
                add(new Attraction(getActivity().getString(R.string.brigade_name), Uri.parse(getActivity().getString(R.string.brigade_location)), getActivity().getString(R.string.brigade_link), R.drawable.brigade));
                add(new Attraction(getActivity().getString(R.string.commercial_street_name), Uri.parse(getActivity().getString(R.string.commercial_street_location)), getActivity().getString(R.string.commercial_street_link), R.drawable.commercial));
                add(new Attraction(getActivity().getString(R.string.majestic_name), Uri.parse(getActivity().getString(R.string.majestic_location)), getActivity().getString(R.string.majestic_link), R.drawable.majestic));
                add(new Attraction(getActivity().getString(R.string.mg_road_name), Uri.parse(getActivity().getString(R.string.mg_road_location)), getActivity().getString(R.string.mg_road_link), R.drawable.mgroad));
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
