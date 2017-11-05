package com.example.arturmusayelyan.slidenerd2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by USER on 05.11.2017.
 */

public class CustomArrayAdapter3 extends ArrayAdapter<String> {
    Context context;
    String[] namesArray;
    int[] flagsArray;

    public CustomArrayAdapter3(Context context, String[] namesArray, int[] flagsArray) {
        super(context, R.layout.single_row_for_listview3, R.id.textView_ForListView3, namesArray);
        Log.d("Art_Log", "CustomArrayAdapter3 constructor worked");
        this.context = context;
        this.namesArray = namesArray;
        this.flagsArray = flagsArray;
    }

    class MyViewHolder {
        TextView namesTextView;
        ImageView flagsImageView;

        public MyViewHolder(View view) {
            namesTextView = view.findViewById(R.id.textView_ForListView3);
            flagsImageView = view.findViewById(R.id.imageView_ForListView3);
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("Art_Log", "getView() method worked");
        View row = convertView;
        MyViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row_for_listview3, parent, false);

            viewHolder = new MyViewHolder(row);
            row.setTag(viewHolder);
        } else {
            // during recycling
            viewHolder=(MyViewHolder) row.getTag();
        }


        viewHolder.namesTextView.setText(namesArray[position]);
        viewHolder.flagsImageView.setBackgroundResource(flagsArray[position]);

        return row;
    }
}
