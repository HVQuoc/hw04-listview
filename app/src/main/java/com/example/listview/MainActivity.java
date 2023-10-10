
package com.example.listview;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {
        TextView txtMsg;
// The n-th row in the list will consist of [icon, label] where icon = thumbnail[n] and label=items[n]
        String[] names = { "Nguyen Van A", "Nguyen Van B", "Nguyen Van C", "Nguyen Van D" , "Nguyen Van E" };
        String [] phones = {"0867137365","0867137365","0867137365","0867137365","0867137365"};
        Integer[] thumbnails = { R.drawable.pic01_small, R.drawable.pic02_small, R.drawable.pic03_small,R.drawable.pic04_small,R.drawable.pic05_small };
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            txtMsg = (TextView) findViewById(R.id.txtMsg);
// the arguments of the custom adapter are: activityContex, layout-to-be-inflated, labels, icons
            CustomIconLabelAdapter adapter = new CustomIconLabelAdapter(this, R.layout.custom_list_view, names,phones, thumbnails);
// bind intrinsic ListView to custom adapter
            setListAdapter(adapter);
        }//onCreate
        @Override
        protected void onListItemClick(ListView l, View v, int position, long id) {
            super.onListItemClick(l, v, position, id);
            txtMsg.setText(" Position: " + position + " " + names[position]);
    }
}

class CustomIconLabelAdapter extends ArrayAdapter<String> {
    Context context; Integer[] thumbnails; String[] items; String[] item2s;
    public CustomIconLabelAdapter( Context context, int layoutToBeInflated, String[] items,String[] item2s, Integer[] thumbnails) {
        super(context,R.layout.custom_list_view, items);
        this.context = context;
        this.thumbnails = thumbnails;
        this.items = items;
        this.item2s = item2s;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.custom_list_view, null);
        TextView label = (TextView) row.findViewById(R.id.label);
        TextView label2 = (TextView) row.findViewById(R.id.label2);
        ImageView icon = (ImageView) row.findViewById(R.id.icon);
        label.setText(items[position]);
        label2.setText(item2s[position]);
        icon.setImageResource(thumbnails[position]);
        return (row);
    }
} // CustomAdapter