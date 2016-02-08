package com.kunall17.entryscreenmanager.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kunall17.entryscreenmanager.Fragments.GridListFragment;
import com.kunall17.entryscreenmanager.R;

import java.util.List;


/**
 * Created by kunall17 on 1/4/16.
 */
public class gridListFragmentAdapter extends RecyclerView.Adapter<gridListFragmentHolder> {

    public gridListFragmentAdapter() {
    }

    List<GridListFragment.info> infoList;

    public gridListFragmentAdapter(List<GridListFragment.info> infoList) {
        this.infoList = infoList;
    }

    @Override
    public gridListFragmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_list_row, parent, false);


        int height = parent.getMeasuredHeight() / 2;
        view.setMinimumHeight(height);

        return new gridListFragmentHolder(view);
    }

    @Override
    public void onBindViewHolder(gridListFragmentHolder holder, int position) {
//        imageViewRound=(ImageView)findViewById(R.id.imageView_round);
//        Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.pic1);
//        imageViewRound.setImageBitmap(icon);
        holder.gridListView_title.setText(infoList.get(position).getText());
        holder.image.setImageResource(infoList.get(position).getDrawable());
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}

class gridListFragmentHolder extends RecyclerView.ViewHolder {
    final TextView gridListView_title;
    final ImageView image;

    public gridListFragmentHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.gridListImageView);
        gridListView_title = (TextView) itemView.findViewById(R.id.gridListView_title);
    }
}