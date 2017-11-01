package com.example.arturmusayelyan.slidenerd2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by artur.musayelyan on 01/11/2017.
 */

// 175% optimization

public class CustomAdapter2 extends ArrayAdapter<String> {
    Context context;
    String[] titleArray;
    String[] descriptionArray;
    int[] images;
    public CustomAdapter2(Context context,String[] titles,String[] descriptions,int[] images){
        super(context,R.layout.single_row_for_customadapter,R.id.textView_forCustomAdapter1,titles);
        this.context=context;
        this.titleArray=titles;
        this.descriptionArray=descriptions;
    }

    class MyViewHolder{
        TextView myTitle;
        TextView myDescription;
        ImageView myImage;
        public MyViewHolder(View view){
            myTitle=view.findViewById(R.id.textView_forCustomAdapter1);
            myDescription=view.findViewById(R.id.textView_forCustomAdapter2);
            myImage=view.findViewById(R.id.imageView_forCustomAdapter);
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        MyViewHolder holder=null;
        if(row==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.single_row_for_customadapter,parent,false);
            holder=new MyViewHolder(row);
            row.setTag(holder);
        }
        else {
            holder= (MyViewHolder) row.getTag();
        }
        holder.myTitle.setText(titleArray[position]);
        holder.myDescription.setText(descriptionArray[position]);
        holder.myImage.setImageResource(images[position]);
        return row;
    }
}
