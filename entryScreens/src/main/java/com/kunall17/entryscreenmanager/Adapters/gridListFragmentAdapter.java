package com.kunall17.entryscreenmanager.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kunall17.entryscreenmanager.R;


/**
 * Created by kunall17 on 1/4/16.
 */
public class gridListFragmentAdapter extends RecyclerView.Adapter<gridListFragmentHolder> {

    public gridListFragmentAdapter(Context context) {
        Context context1 = context;
    }

    @Override
    public gridListFragmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_list_row, parent, false);
        gridListFragmentHolder holder = new gridListFragmentHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(gridListFragmentHolder holder, int position) {
//        imageViewRound=(ImageView)findViewById(R.id.imageView_round);
//        Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.pic1);
//        imageViewRound.setImageBitmap(icon);
        holder.gridListView_title.setText("Number-" + position);
    }

    @Override
    public int getItemCount() {
        return 30;
    }
}

class gridListFragmentHolder extends RecyclerView.ViewHolder {
    TextView gridListView_title;

    public gridListFragmentHolder(View itemView) {
        super(itemView);
        ImageView image = (ImageView) itemView.findViewById(R.id.gridListImageView);
        gridListView_title = (TextView) itemView.findViewById(R.id.gridListView_title);
    }
}