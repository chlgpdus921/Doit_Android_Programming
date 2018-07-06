package org.androidtown.samplecustomviewstyle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CustomViewStyles view = new CustomViewStyles(this);
        super.onCreate(savedInstanceState);
        setContentView(view);
    }
}
