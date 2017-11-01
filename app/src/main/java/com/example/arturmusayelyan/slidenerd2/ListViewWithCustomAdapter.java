package com.example.arturmusayelyan.slidenerd2;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ListViewWithCustomAdapter extends AppCompatActivity {
    private ListView listView;
    private String[] titles;
    private String[] description;
    private int[] images = {R.drawable.meme1, R.drawable.meme2, R.drawable.meme3, R.drawable.meme4, R.drawable.meme5, R.drawable.meme6, R.drawable.meme7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_custom_adapter);
        listView = (ListView) findViewById(R.id.listViewForCustomAdapter);

        Resources resources = getResources();
        titles = resources.getStringArray(R.array.titles);
        description = resources.getStringArray(R.array.descriptions);

//        MyCustomAdapter adapter = new MyCustomAdapter(this, titles, description, images);
//        listView.setAdapter(adapter);
        CustomAdapter2 adapter2=new CustomAdapter2(this,titles,description,images);
        listView.setAdapter(adapter2);
    }
}

//class MyCustomAdapter extends ArrayAdapter<String> {
//    Context context;
//    String[] titleArray;
//    String[] descriptionArray;
//    int[] imagesArray;
//
//    public MyCustomAdapter(Context context, String[] titles, String[] description, int[] images) {
//        super(context, R.layout.single_row_for_customadapter, R.id.textView_forCustomAdapter1, titles);
//        this.context = context;
//        this.titleArray = titles;
//        this.descriptionArray = description;
//        this.imagesArray = images;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        //150% optimization
//        View row = convertView;
//        if (row == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            row = inflater.inflate(R.layout.single_row_for_customadapter, parent, false);
//        }
//        //
//        TextView myTitle = row.findViewById(R.id.textView_forCustomAdapter1);
//        TextView myDescription = row.findViewById(R.id.textView_forCustomAdapter2);
//        ImageView myImage = row.findViewById(R.id.imageView_forCustomAdapter);
//
//        myTitle.setText(titleArray[position]);
//        myDescription.setText(descriptionArray[position]);
//        myImage.setImageResource(imagesArray[position]);
//
//        return row;
//    }
//}
