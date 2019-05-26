package com.example.tourguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AttractionsAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public AttractionsAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new SightSeeingFragment();
        } else if (i == 1) {
            return new TemplesFragment();
        } else if (i == 2) {
            return new ParksFragment();
        } else {
            return new ShoppingFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int i) {
        if (i == 0) {
            return mContext.getString(R.string.sightseeing);
        } else if (i == 1) {
            return mContext.getString(R.string.temples);
        } else if (i == 2) {
            return mContext.getString(R.string.parks);
        } else {
            return mContext.getString(R.string.shopping);
        }
    }
}
