package com.example.arturmusayelyan.slidenerd2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by artur.musayelyan on 02/11/2017.
 */

public class MyBaseAdapter extends BaseAdapter {
    Context context;
    ArrayList<SingleRow> list;

//    public MyBaseAdapter(Context context) {
//        this.context = context;
//        list = new ArrayList<>();
//        Resources resources = context.getResources();
//        String[] titlesArray = resources.getStringArray(R.array.titles);
//        String[] descriptionArray = resources.getStringArray(R.array.descriptions);
//        int[] imagesArray = {R.drawable.meme1, R.drawable.meme2, R.drawable.meme3, R.drawable.meme4, R.drawable.meme5, R.drawable.meme6, R.drawable.meme7};
//        for (int i = 0; i < 7; i++) {
//            list.add(new SingleRow(titlesArray[i], descriptionArray[i], imagesArray[i]));
//        }
//    }


    class MyViewHolder {
        TextView myTitle;
        TextView myDescription;
        ImageView myImage;

        public MyViewHolder(View view) {
            myTitle = view.findViewById(R.id.textView_ForCustomBaseAdapter1);
            myDescription = view.findViewById(R.id.textView_ForCustomBaseAdapter2);
            myImage = view.findViewById(R.id.imageView_ForCustomBaseAdapter);
        }
    }

    public MyBaseAdapter(Context context, ArrayList<SingleRow> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder viewHolder;
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row_for_baseadapter, parent, false);

            viewHolder = new MyViewHolder(row);
            row.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) row.getTag();
        }
//
//        TextView myTitle = row.findViewById(R.id.textView_ForCustomBaseAdapter1);
//        TextView myDescription = row.findViewById(R.id.textView_ForCustomBaseAdapter2);
//        ImageView myImage = row.findViewById(R.id.imageView_ForCustomBaseAdapter);
//
//        SingleRow temp = list.get(position);
//        myTitle.setText(temp.title);
//        myDescription.setText(temp.description);
//        myImage.setImageResource(temp.image);

        viewHolder.myTitle.setText(list.get(position).title);
        viewHolder.myDescription.setText(list.get(position).description);
        viewHolder.myImage.setImageResource(list.get(position).image);

        return row;
    }
}
