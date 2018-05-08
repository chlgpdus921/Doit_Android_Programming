package org.androidtown.lab11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView imageView1, imageView2;
int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.imageview1);
        imageView2 = (ImageView) findViewById(R.id.imageview2);

    }
        public void Button1onClicked (View v){
            changeImage();
        }

        private void changeImage() {
            if (index == 0) {
                imageView1.setVisibility(View.INVISIBLE);
                imageView2.setVisibility(View.VISIBLE);
                index = 1;
            }
            else if(index == 1) {
                imageView1.setVisibility(View.VISIBLE);
                imageView2.setVisibility(View.INVISIBLE);
                index = 0;
            }
    }
}

