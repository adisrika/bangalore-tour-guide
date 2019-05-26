package com.example.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ArrayAttractionAdapter extends ArrayAdapter<Attraction> {
    public ArrayAttractionAdapter(Context context, List<Attraction> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.attraction_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Attraction currentAttraction = getItem(position);
        ImageView imageView = listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentAttraction.getmImageId());

        TextView title = listItemView.findViewById(R.id.title);
        title.setText(currentAttraction.getmName());

        ImageButton locationButton = listItemView.findViewById(R.id.location_button);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListView) parent).performItemClick(v, position, 0);
            }
        });

        ImageButton linkButton = listItemView.findViewById(R.id.link_button);
        linkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListView) parent).performItemClick(v, position, 0);
            }
        });

        return listItemView;
    }
}
