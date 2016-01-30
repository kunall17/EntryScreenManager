package com.kunall17.entryscreenmanager.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.kunall17.entryscreenmanager.Fragments.DefaultFragment;
import com.kunall17.entryscreenmanager.Fragments.GridListFragment;
import com.kunall17.entryscreenmanager.Java.ContactInterface;
import com.kunall17.entryscreenmanager.R;

/**
 * Created by kunall17 on 1/5/16.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private final int pages;
    private ContactInterface talkToActivity;

    public SectionsPagerAdapter(FragmentManager fm, int pages, Context context) {
        super(fm);
        this.pages = pages;
        try {
            talkToActivity = (ContactInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement interface.");
        }
        DefaultFragment bf = new DefaultFragment();
    }


    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Log.d("getItem", "called");
        switch (position) {
            case 0:
                talkToActivity.setContainerBackground(Color.parseColor("#ecf0f1"));
                talkToActivity.setControlsBackground(Color.parseColor("#c0392b"));
                return DefaultFragment.init("Entry Screens", "Share this Awesomeness!", R.drawable.phone);
            case 1:

                return new GridListFragment();
            case 2:
                return DefaultFragment.init("It's so easy to use!", "I can easily change colors, Icons.\nAnd its open source!", R.drawable.zxc);
            case 3:
                return new DefaultFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return pages;
    }
}