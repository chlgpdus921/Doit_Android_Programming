package org.androidtown.doitmission_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   GridView listView;
    ListAdapter adapter;
    EditText editText, editText2, editText3;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (GridView) findViewById(R.id.listView);
        adapter = new ListAdapter();

        listView.setAdapter(adapter);
        adapter.addItem(new ListItem("롱쉬폰 원피스", "160,000원", "명절 기획상품...", R.drawable.clothes));
        adapter.addItem(new ListItem("블랙 정장 코디", "80,000원", "특가상품..", R.drawable.clothes2));
        adapter.addItem(new ListItem("열나무 샌들", "100,000원", "여름 한정상품..", R.drawable.clothes3));
        adapter.addItem(new ListItem("페니백", "190,000원", "2018 패션 트렌디 아이템..", R.drawable.clothes4));
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListItem item = (ListItem)adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택 : " + item.getNum() + " 가격: " + item.getBirth(), Toast.LENGTH_LONG).show();
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
