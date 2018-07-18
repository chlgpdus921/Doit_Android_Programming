package org.androidtown.samplecustomviewimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CustomViewImage extends View {
    private Paint mPaint;
    private Bitmap cacheBitmap;
    private Canvas cacheCanvas;
    public CustomViewImage(Context context){
        super(context);
        mPaint = new Paint();
    }
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        createCacheBitmap(w, h);
        testDrawing();
    }
    private void createCacheBitmap(int w, int h){
        cacheBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        cacheCanvas = new Canvas();
        cacheCanvas.setBitmap(cacheBitmap);
    }

    private  void testDrawing(){
        cacheCanvas.drawColor(Color.WHITE);

        mPaint.setColor(Color.RED);
        cacheCanvas.drawRect(100,100,200,200,mPaint);
    }
    protected void onDraw(Canvas canvas){
        if(cacheBitmap != null){
            canvas.drawBitmap(cacheBitmap, 0,0,null);
        }
    }
}
