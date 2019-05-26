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
public class ParksFragment extends Fragment {


    public ParksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);
        ListView listView = rootView.findViewById(R.id.list);
        ArrayList<Attraction> attractions = new ArrayList<Attraction>() {
            {
                add(new Attraction("Lalbagh Botanical Garden", Uri.parse("geo:0,0?q=12.9507,77.5848 (Lalbagh)"), "https://en.wikipedia.org/wiki/Lal_Bagh", R.drawable.lalbagh));
                add(new Attraction("Sri Chamarajendra Park", Uri.parse("geo:0,0?q=12.9763, 77.5929 (Chamarajendra)"), "https://en.wikipedia.org/wiki/Cubbon_Park", R.drawable.cubbon));
                add(new Attraction("Bannerghatta Biological Park", Uri.parse("geo:0,0?q=12.8003, 77.5770 (Bannerghatta Biological Park)"), "https://en.wikipedia.org/wiki/Bannerghatta_National_Park", R.drawable.tiger));
                add(new Attraction("Sankey tank", Uri.parse("geo:0,0?q=13.0093, 77.5741 (Sankey tank)"), "https://en.wikipedia.org/wiki/Sankey_tank", R.drawable.sankey_tank));
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
