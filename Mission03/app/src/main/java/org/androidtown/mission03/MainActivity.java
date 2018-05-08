package org.androidtown.mission03;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
ScrollView scrollView;
ImageView imageView, imageView2;
BitmapDrawable bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = (ScrollView)findViewById(R.id.scrollView);
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView2);



    }

    public void onButton1Clicked(View v){
        changeImage();
    }
    public void onButton2Clicked(View v){
        changeImage2();
    }
    private void changeImage(){

            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);

        }

        private void changeImage2(){

                imageView.setVisibility(View.VISIBLE);
                imageView2.setVisibility(View.INVISIBLE);

            }


    }

