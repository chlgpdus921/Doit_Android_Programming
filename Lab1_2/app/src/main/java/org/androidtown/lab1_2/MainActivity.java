package org.androidtown.lab1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText editText;
Button button1, button2;
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        editText = (EditText)findViewById(R.id.editText);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        textView = (TextView)findViewById(R.id.textView2);
    }
    public void Button1onClicked(View v){
        editText.setText("");
        textView.setText("contents");
    }
    public void Button2onClicked(View v){
        String text = "";
        text = editText.getText().toString();
        textView.setText(text);
    }
}
