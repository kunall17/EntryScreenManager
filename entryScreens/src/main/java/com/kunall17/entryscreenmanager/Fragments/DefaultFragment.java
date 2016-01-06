package com.kunall17.entryscreenmanager.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kunall17.entryscreenmanager.R;

public class DefaultFragment extends Fragment {

    private ImageView imageView;
    private TextView textView;
    private TextView textView_title;

    private int imageId;
    private String title;
    private String text;

    public DefaultFragment() {
        // Required empty public constructor
    }

    public static DefaultFragment init(String title, String text, int image) {
        DefaultFragment fragment = new DefaultFragment();
        // Supply val input as an argument.
        Bundle args = new Bundle();
        args.putInt("imageId", image);
        args.putString("TitleText", title);
        args.putString("MessageText", text);
        fragment.setArguments(args);
        return fragment;
    }

    public static DefaultFragment newInstance() {
        DefaultFragment fragment = new DefaultFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString("TitleText");
            text = getArguments().getString("MessageText");
            imageId = getArguments().getInt("imageId");
        }

    }

    private void setTextViewText(String title, String text) {
        textView.setText(text);
        textView_title.setText(title);

    }

    private void setContent(String title, String text, int image) {
        imageView.setImageResource(image);
        textView.setText(text);
        textView_title.setText(title);
    }

    private void setContent(String title, String text, Drawable image) {
        imageView.setImageDrawable(image);
        textView.setText(text);
        textView_title.setText(title);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_default, container, false);
        imageView = (ImageView) v.findViewById(R.id.blank_imageView);
        textView = (TextView) v.findViewById(R.id.blank_textView);
        textView_title = (TextView) v.findViewById(R.id.blank_textView_title);

        if (title != null) setContent(title, text, imageId);
        return v;
    }
}
