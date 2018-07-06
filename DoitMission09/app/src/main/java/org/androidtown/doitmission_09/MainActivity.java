package org.androidtown.doitmission_09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ListAdapter adapter;
    EditText editText, editText2, editText3;
    TextView textView;
    Button button;
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        adapter = new ListAdapter();
        editText = (EditText) findViewById(R.id.name);
        editText2 = (EditText) findViewById(R.id.birth);
        editText3 = (EditText) findViewById(R.id.phone);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.num);
        listView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String birth = editText2.getText().toString();
                String phone = editText3.getText().toString();

                adapter.addItem(new ListItem(name, birth.substring(0,4)+"."+birth.substring(4,6)+"."+birth.substring(6),
                        phone.substring(0,3) +"-"+phone.substring(3,7)+"-"+phone.substring(7), R.drawable.pic));
                listView.setAdapter(adapter);
                sum++;
                textView.setText(sum + " 명");
                editText.setText("");
                editText2.setText("");
                editText3.setText("");
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListItem item = (ListItem)adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택 : " + item.getNum(), Toast.LENGTH_LONG).show();
            }
        });
    }


    class ListAdapter extends BaseAdapter {
        ArrayList<ListItem> items = new ArrayList<ListItem>();


        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(ListItem item) {
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
            listView view = new listView((getApplicationContext()));
            ListItem item = items.get(position);
            view.setNum(item.getNum());
            view.setBirth(item.getBirth());
            view.setPhone(item.getPhone());
            view.setImage(item.getResId());

            return view;
        }
    }

}
