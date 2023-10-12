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
import java.util.ArrayList;

// a static class as a random info machine
class RandomDataMachine {
    // random repos
    String [] firstNameRepo = {"Quoc", "Truc", "Hoang", "Quan", "Huyen", "Hoa", "My", "Dung", "Mai", "Lan"};
    String [] lastNameRepo = {"Tran", "Lam", "Nguyen", "Le", "Huynh"};
    String [] middleNameRepo = {"Thao", "Minh", "Thuy", "Phuong", "Thu"};
    Integer [] thumnailsRepo = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                            R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10};

    // instances
    Integer image;
    private String name;
    private String phoneNumber;
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public Integer getImage() {
        return image;
    }

    public String randomName(){
        int index1 = (int)Math.floor(Math.random() * this.lastNameRepo.length);
        int index2 = (int)Math.floor(Math.random() * this.middleNameRepo.length);
        int index3 = (int)Math.floor(Math.random() * this.firstNameRepo.length);
        return lastNameRepo[index1] + " " + middleNameRepo[index2] + " " + firstNameRepo[index3];
    }
    public String randomPhoneNumber() {
        String phoneNumber = "0";
        for (int i = 0; i < 9; ++i) {
            phoneNumber += (int)Math.floor(Math.random() * 9);
        }
        return phoneNumber;
    }
    public Integer randomThumnails() {
        int index = (int)Math.floor(Math.random() * this.thumnailsRepo.length);
        return thumnailsRepo[index];
    }
}

public class MainActivity extends ListActivity {
        TextView txtMsg;
        RandomDataMachine item = new RandomDataMachine();
// The n-th row in the list will consist of [icon, label] where icon = thumbnail[n] and label=items[n]
        String[] names = { item.randomName(), "Nguyen Van B", "Nguyen Van C", "Nguyen Van D" , "Nguyen Van E" };
        String [] phones = {item.randomPhoneNumber(),"0867137365","0867137365","0867137365","0867137365"};
        Integer[] thumbnails = {item.randomThumnails(), R.drawable.pic2, R.drawable.pic3,R.drawable.pic4,R.drawable.pic5 };


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            txtMsg = (TextView) findViewById(R.id.txtMsg);
// the arguments of the custom adapter are: activityContex, layout-to-be-inflated, labels, icons
            CustomIconLabelAdapter adapter = new CustomIconLabelAdapter(this, R.layout.custom_list_view, names, phones, thumbnails);
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