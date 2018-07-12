package org.androidtown.samplecustomview2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.lang.annotation.Inherited;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(this);
        setContentView(myView);
    }

    protected class MyView extends View {
        public MyView(Context context){
            super(context);
        }
        /*onDraw 뷰가 화면에 보여질때 자동적으로 호출*/
        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            /*paint - 그래픽 그리기위한 속성으를 담고있다. */
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);//반듯하게 나옴.
            paint.setStrokeWidth(8);
            paint.setColor(Color.RED);

            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(50,50,40,paint);

            paint.setStyle(Paint.Style.STROKE); //안에 가 텅빈
            canvas.drawCircle(150,50,40,paint);

            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(250,50,40,paint);
         //    canvas.drawCircle(200,200,50,paint);
            /*중심측 좌표x, 중심측 좌표y, 반지름*/

            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(50,150,40,paint);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(50,150,40,paint);

            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);
            canvas.drawCircle(150,150,40,paint);
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(150,150,40,paint);
        }
    }
}
