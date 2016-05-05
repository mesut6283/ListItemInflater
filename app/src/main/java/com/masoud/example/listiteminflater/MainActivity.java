package com.masoud.example.listiteminflater;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] demoTitle;
    String[] demoDescriptions;
    int[] image = {R.drawable.pic01, R.drawable.pic02, R.drawable.pic03, R.drawable.pic04,
            R.drawable.pic05, R.drawable.pic06, R.drawable.pic07, R.drawable.pic08,
            R.drawable.pic09, R.drawable.pic10};
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        demoTitle = res.getStringArray(R.array.title);
        demoDescriptions = res.getStringArray(R.array.descriptions);
        list = (ListView) findViewById(R.id.listView);
        mesutAdapter adapter = new mesutAdapter(this, demoTitle, image, demoDescriptions);
        list.setAdapter(adapter);
    }
}

class MyViewHolder{
    ImageView myImage;
    TextView myTitle;
    TextView myDescription;
    MyViewHolder(View v){
        myImage= (ImageView) v.findViewById(R.id.imageView);
        myTitle= (TextView) v.findViewById(R.id.textView);
        myDescription= (TextView) v.findViewById(R.id.textView2);
    }

        }


class mesutAdapter extends ArrayAdapter {
    Context context;
    int[] image;
    String[] titleArray;
    String[] descriptionArray;

    mesutAdapter(Context c, String[] title, int[] img, String[] desc) {

        super(c, R.layout.single_row, R.id.textView, title);

        this.context = c;
        this.image = img;
        this.titleArray = title;
        this.descriptionArray = desc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //--------baraye bala bordane sorat moge scrool
        View row = convertView;
        MyViewHolder holder=null;

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
            holder=new MyViewHolder(row);
            row.setTag(holder);
            Log.d("Vivz","create new row");
        }
        else {
            holder= (MyViewHolder) row.getTag();
            Log.d("Vivz","stuff");
        }
//---------------------


        holder.myImage.setImageResource(image[position]);
        holder.myTitle.setText(titleArray[position]);
        holder.myDescription.setText(descriptionArray[position]);

        return row;
    }
}

