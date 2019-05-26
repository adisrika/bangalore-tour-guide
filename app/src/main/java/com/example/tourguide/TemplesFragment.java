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
                add(new Attraction(getActivity().getString(R.string.iskcon_name), Uri.parse(getActivity().getString(R.string.iskcon_location)), getActivity().getString(R.string.iskcon_link), R.drawable.iskcon));
                add(new Attraction(getActivity().getString(R.string.nandi_temple_name), Uri.parse(getActivity().getString(R.string.nandi_temple_location)), getActivity().getString(R.string.nandi_temple_link), R.drawable.bull));
                add(new Attraction(getActivity().getString(R.string.gavi_name), Uri.parse(getActivity().getString(R.string.gavi_location)), getActivity().getString(R.string.gavi_link), R.drawable.gg));
                add(new Attraction(getActivity().getString(R.string.ragiguda_name), Uri.parse(getActivity().getString(R.string.ragiguda_location)), getActivity().getString(R.string.ragiguda_link), R.drawable.ragigudda));
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
