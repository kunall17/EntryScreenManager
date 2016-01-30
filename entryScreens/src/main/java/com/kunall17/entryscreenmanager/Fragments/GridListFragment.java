package com.kunall17.entryscreenmanager.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kunall17.entryscreenmanager.Adapters.gridListFragmentAdapter;
import com.kunall17.entryscreenmanager.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GridListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GridListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GridListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private OnFragmentInteractionListener mListener;
    List<info> infoList;

    public GridListFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static GridListFragment newInstance(String param1, String param2) {
        GridListFragment fragment = new GridListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_grid_list, container, false);
        infoList = new ArrayList<>();
        addItems();
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.gridListRecyclerView);
        gridListFragmentAdapter adapter = new gridListFragmentAdapter(infoList);
        recyclerView.setAdapter(adapter);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);

        TextView gridListFragmentMasterTitle = (TextView) v.findViewById(R.id.gridListFragmentMasterTitle);
        gridListFragmentMasterTitle.setText("Master Title Here!");
        recyclerView.setLayoutManager(glm);

        return v;
    }

    private void addItems() {
        info Info = new info();
        Info.setDrawable(R.drawable.a);
        Info.setText("Icon- " + "a");
        infoList.add(Info);

        info Info1 = new info();
        Info1.setDrawable(R.drawable.b);
        Info1.setText("Icon- " + "b");
        infoList.add(Info1);

        info Info2 = new info();
        Info2.setDrawable(R.drawable.c);
        Info2.setText("Icon- " + "c");
        infoList.add(Info2);

        info Info3 = new info();
        Info3.setDrawable(R.drawable.d);
        Info3.setText("Icon- " + "d");
        infoList.add(Info3);

        info Info4 = new info();
        Info4.setDrawable(R.drawable.e);
        Info4.setText("Icon- " + "e");
        infoList.add(Info4);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public class info {
        int drawable;

        public int getDrawable() {
            return drawable;
        }

        public void setDrawable(int drawable) {
            this.drawable = drawable;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        String text;
    }
}
