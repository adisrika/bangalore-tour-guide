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
public class SightSeeingFragment extends Fragment {


    public SightSeeingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);
        ListView listView = rootView.findViewById(R.id.list);
        ArrayList<Attraction> attractions = new ArrayList<Attraction>() {
            {
                add(new Attraction("Nandi Hills", Uri.parse("geo:0,0?q=13.3702,77.6835 (Nandi Hills)"), "https://en.wikipedia.org/wiki/Nandi_Hills,_India", R.drawable.nandi_hills));
                add(new Attraction("Bangalore Palace", Uri.parse("geo:0,0?q=12.9988, 77.5921 (Bangalore Palace)"), "https://en.wikipedia.org/wiki/Bangalore_Palace", R.drawable.bangalore_palace));
                add(new Attraction("Tipu Sultan's Summer Palace", Uri.parse("geo:0,0?q=12.9595, 77.5738 (Bangalore Palace)"), "https://en.wikipedia.org/wiki/Tipu_Sultan's_Summer_Palace", R.drawable.tipu_palace));
                add(new Attraction("Vidhana Soudha", Uri.parse("geo:0,0?q=12.9779, 77.5896 (Vidhana Soudha)"), "https://en.wikipedia.org/wiki/Vidhana_Soudha", R.drawable.vidhana_soudha));
                add(new Attraction("Dodda Alada Mara", Uri.parse("geo:0,0?q=12.9094, 77.3958 (Big banyan tree)"), "https://en.wikipedia.org/wiki/Dodda_Alada_Mara", R.drawable.big_tree));
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
