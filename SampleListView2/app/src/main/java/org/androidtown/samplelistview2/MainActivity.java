package org.androidtown.samplelistview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    String[] items = {"mike", "angel", "crow", "john", "ginnie", "sally", "cohen", "rice"};
ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        setListAdapter(new ArrayAdapter<String >(this, android.R.layout.simple_list_item_1, items));

protected void onListItemClick(ListView l, View v, int position, long id){
            super.onListItemClick(l, v, position, id);
            String text = "position: " + position + " " + items[position];

        }

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

         }
}