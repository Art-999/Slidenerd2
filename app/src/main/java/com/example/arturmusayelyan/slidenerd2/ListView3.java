package com.example.arturmusayelyan.slidenerd2;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListView3 extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private  String[] namesArray;
    private int[] images = {R.drawable.flag1, R.drawable.flag2, R.drawable.flag3, R.drawable.flag4, R.drawable.flag5, R.drawable.flag6, R.drawable.flag7, R.drawable.flag8, R.drawable.flag9, R.drawable.flag9a};
    ArrayList<SingleRow3> resoursList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3);

        resoursList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView3);
        //Resources resources=getResources();
         namesArray = getResources().getStringArray(R.array.countries);
        //adapter = new ArrayAdapter<String>(this, R.layout.single_row_for_listview3, R.id.textView_ForListView3, namesArray);

//        CustomArrayAdapter3 customArrayAdapter = new CustomArrayAdapter3(this, namesArray, images);
//        listView.setAdapter(customArrayAdapter);


        for (int i = 0; i < 10; i++) {
            resoursList.add(new SingleRow3(namesArray[i], images[i]));
        }
        CustomBaseAdapter3 baseAdapter=new CustomBaseAdapter3(this,resoursList);
        listView.setAdapter(baseAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        //  TextView temp = (TextView) view;
        RelativeLayout layout = (RelativeLayout) view;
        TextView temp = layout.findViewById(R.id.textView_ForListView3);
        Toast.makeText(this, temp.getText() + " " + position, Toast.LENGTH_SHORT).show();
    }
}
