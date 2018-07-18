package org.techtown.tutorial.paintboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PaintBoardActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        PaintBoard board = new PaintBoard(this);
        setContentView(board);
    }

}
