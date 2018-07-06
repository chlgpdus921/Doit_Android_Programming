package org.androidtown.doitmission_09;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class listView extends LinearLayout {
    TextView textView, textView2, textView3;
ImageView imageView;
    public listView(Context context) {
        super(context);
        init(context);
    }

    public listView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listview, this, true);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        imageView = (ImageView)findViewById(R.id.imageView);
    }
    public void setNum(String num){
        textView.setText(num);
    }
    public void setBirth(String birth){
        textView2.setText(birth);
    }
    public void setPhone(String phone){
        textView3.setText(phone);
    }
    public void setImage(int resId){
        imageView.setImageResource(resId);
    }
}
