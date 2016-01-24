package com.kunall17.entryscreenmanager.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.kunall17.entryscreenmanager.Java.ContactInterface;
import com.kunall17.entryscreenmanager.R;
import com.kunall17.entryscreenmanager.Adapters.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity implements ContactInterface {

    private ViewPager mViewPager;
    private int NUMBER_OF_PAGES = 3;
    private Button skip;
    private Button next;
    private LinearLayout main_content;
    private LinearLayout controls_layout;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        main_content = (LinearLayout) findViewById(R.id.main_content);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), NUMBER_OF_PAGES, MainActivity.this);
        mViewPager = (ViewPager) findViewById(R.id.container);
        skip = (Button) findViewById(R.id.SKIP_BUTTON);
        next = (Button) findViewById(R.id.NEXT_BUTTON);
        controls_layout = (LinearLayout) findViewById(R.id.controls_layout);


        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(R.drawable.circle_selector);
//            ((LinearLayout) tabLayout.getTabAt(i)).setPadding(0, 0, 0, 0);

            (((LinearLayout) tabLayout.getChildAt(0)).getChildAt(i)).setPadding(0, 0, 0, 0);
        }
        tabLayout.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {

                        int position = tab.getPosition();
                        super.onTabSelected(tab);
                        if ((position) == NUMBER_OF_PAGES - 1) {
                            skip.setVisibility(View.INVISIBLE);
                            next.setText("FINISH");
                        } else {
                            skip.setVisibility(View.VISIBLE);
                            next.setText("Next");
                        }

                        switch (position) {
                             case 0:
                                setContainerBackground(Color.parseColor("#ecf0f1"));
                                setControlsBackground(Color.parseColor("#c0392b"));
                                break;
                            case 1:
                                setContainerBackground(Color.parseColor("#ecf0f1"));
                                setControlsBackground(Color.parseColor("#2980b9"));
                                break;
                            case 2:
                                setContainerBackground(Color.parseColor("#ecf0f1"));
                                setControlsBackground(Color.parseColor("#f39c12"));
                                break;
                        }
                    }
                });

    }

    private void completed() {

        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void skip_button(View v) {
        completed();
    }

    public void next_button(View v) {
        if (mViewPager.getCurrentItem() != NUMBER_OF_PAGES - 1) {
            int page = mViewPager.getCurrentItem() + 1;
            mViewPager.setCurrentItem(page);
            tabLayout.setScrollPosition(page, 0f, true);
        } else {
            completed();

        }


    }


    @Override
    public void setContainerBackground(int COLOR) {
        main_content.setBackgroundColor(COLOR);
    }

    @Override
    public void setControlsBackground(int Color) {
        controls_layout.setBackgroundColor(Color);
        skip.setBackgroundColor(Color);
        next.setBackgroundColor(Color);

    }

    @Override
    public void setControlsTextColor(int color) {
        skip.setTextColor(color);
        next.setTextColor(color);
    }


}
