package org.androidtown.doitmission_11;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class ColorSelect extends Activity {
    GridView gridView;
    Button closeBtn;
    ColorDataAdapter adapter;
    public static OnColorSelectedListener listener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color);

        this.setTitle("색상 선택");
        gridView = (GridView) findViewById(R.id.gridView);
        closeBtn = (Button) findViewById(R.id.closeBtn);

        gridView.setBackgroundColor(Color.GRAY);
        gridView.setColumnWidth(14);
        gridView.setVerticalSpacing(4);
        gridView.setHorizontalSpacing(4);

        adapter = new ColorDataAdapter(this);
        gridView.setAdapter(adapter);
        gridView.setNumColumns(adapter.getNumberColumns());

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    class ColorDataAdapter extends BaseAdapter {
        Context mContext;
        int[] colors = new int[]{
                0xff000000, 0xff00007f, 0xff0000ff, 0xff007f00, 0xff007f7f, 0xff00ff00, 0xff00ff7f,
                0xff00ffff, 0xff7f007f, 0xff7f00ff, 0xff7f7f00, 0xff7f7f7f, 0xffff0000, 0xffff007f,
                0xffff00ff, 0xffff7f00, 0xffff7f7f, 0xffff7fff, 0xffffff00, 0xffffff7f, 0xffffffff
        };
        int rowCount, columnCount;

        public ColorDataAdapter(Context context) {
            super();
            mContext = context;
            rowCount = 3;
            columnCount = 7;
        }

        public int getNumberColumns() {
            return columnCount;
        }

        public int getCount() {
            return rowCount * columnCount;
        }

        public Object getItem(int position) {
            return colors[position];
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View view, ViewGroup group) {
            int rowIndex = position / rowCount;
            int columnIndex = position % rowCount;

            GridView.LayoutParams params = new GridView.LayoutParams(
                    GridView.LayoutParams.MATCH_PARENT, GridView.LayoutParams.MATCH_PARENT);

            Button aItem = new Button(mContext);
            aItem.setText(" ");
            aItem.setLayoutParams(params);
            aItem.setPadding(4, 4, 4, 4);
            aItem.setBackgroundColor(colors[position]);
            aItem.setHeight(120);
            aItem.setTag(colors[position]);

            aItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ColorSelect.listener != null) {
                        ColorSelect.listener.onColorSelected(((Integer) v.getTag()).intValue());
                    }
                    ((ColorSelect) mContext).finish();
                }
            });

            return aItem;
        }

    }
}
