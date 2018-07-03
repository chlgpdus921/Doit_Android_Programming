package org.androidtown.samplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  EditText editText;
  Button button;
    ListView listView;
    SingerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);

        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("미정", "010-1000-1000", 23, R.drawable.singer));
        adapter.addItem(new SingerItem("옥경", "010-2000-2000", 25, R.drawable.singer2));
        adapter.addItem(new SingerItem("으나", "010-3000-3000", 23, R.drawable.singer3));
        adapter.addItem(new SingerItem("혜원", "010-4000-4000", 22, R.drawable.singer4));
        adapter.addItem(new SingerItem("지니", "010-5000-5000", 22, R.drawable.singer5));

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                adapter.addItem(new SingerItem(editText.getText().toString(), "010-5000-5000", 22, R.drawable.singer3));
                adapter.notifyDataSetChanged();
            }
        });
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택 : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            SingerItemView view = new SingerItemView(getApplicationContext());

            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setAge(item.getAge());
            view.setImage(item.getResId());

            return view;
        }
    }



}
