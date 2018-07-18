package org.androidtown.paintboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PaintBoard paintBoard = new PaintBoard(this);
        setContentView(paintBoard);
    }
}
