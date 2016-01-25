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
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.gridListRecyclerView);
        gridListFragmentAdapter adapter = new gridListFragmentAdapter();
        recyclerView.setAdapter(adapter);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        TextView gridListFragmentMasterTitle = (TextView) v.findViewById(R.id.gridListFragmentMasterTitle);
        gridListFragmentMasterTitle.setText("Master Title Here!");
        recyclerView.setLayoutManager(glm);

        return v;
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
}
