package com.example.arturmusayelyan.slidenerd2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by USER on 05.11.2017.
 */

public class CustomBaseAdapter3 extends BaseAdapter {
    Context context;
    ArrayList<SingleRow3> dataList ;

    public CustomBaseAdapter3(Context context, ArrayList<SingleRow3> resoursList) {
        this.context = context;
        this.dataList = resoursList;
    }

    class MyViewHolder {
        TextView namesTextView;
        ImageView flagsImageView;

        public MyViewHolder(View view) {
            namesTextView = view.findViewById(R.id.textView_ForListView3);
            flagsImageView = view.findViewById(R.id.imageView_ForListView3);
        }
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@Nullable ViewGroup parent) {
        View row = convertView;
       MyViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row_for_listview3, parent, false);

            viewHolder = new MyViewHolder(row);
            row.setTag(viewHolder);
        } else {
            //during recycling
            viewHolder = (MyViewHolder) row.getTag();
        }
        viewHolder.namesTextView.setText(dataList.get(position).names);
        viewHolder.flagsImageView.setImageResource(dataList.get(position).images);

        return row;
    }
}
