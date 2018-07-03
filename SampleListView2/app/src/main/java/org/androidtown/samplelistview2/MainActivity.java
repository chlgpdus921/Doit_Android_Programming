package org.androidtown.samplelistview2;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {
    String[] items = {"mike", "angel", "crow", "john", "ginnie", "sally", "cohen", "rice"};
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));

    }
    protected void onListItemClick(ListView I, View v, int position, long id){
        super.onListItemClick(I, v, position, id);
      //  textView.setText(items[position]);
        String text = "position: " + position + " " + items[position];

    }
}