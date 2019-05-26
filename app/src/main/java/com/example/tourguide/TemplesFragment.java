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
public class TemplesFragment extends Fragment {


    public TemplesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);
        ListView listView = rootView.findViewById(R.id.list);
        ArrayList<Attraction> attractions = new ArrayList<Attraction>() {
            {
                add(new Attraction("Iskcon Temple", Uri.parse("geo:0,0?q=13.010157,77.551086 (Iskcon Temple)"), "https://en.wikipedia.org/wiki/ISKCON_Temple_Bangalore", R.drawable.iskcon));
                add(new Attraction("Nandi Temple", Uri.parse("geo:0,0?q=13.009986, 77.659277 (Nandi Temple)"), "https://en.wikipedia.org/wiki/Dodda_Basavana_Gudi", R.drawable.bull));
                add(new Attraction("Gavi Gangadhareshwara Temple", Uri.parse("geo:0,0?q=12.948452, 77.563033 (Gavi Gangadhareshwara Temple)"), "https://en.wikipedia.org/wiki/Gavi_Gangadhareshwara_Temple", R.drawable.gg));
                add(new Attraction("Ragigudda Anjaneya Temple", Uri.parse("geo:0,0?q=12.9143, 77.5932 (Ragigudda Anjaneya Temple)"), "https://en.wikipedia.org/wiki/Ragigudda_Anjaneya_Temple", R.drawable.ragigudda));
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
