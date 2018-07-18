package org.androidtown.samplecustomviewimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
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

        Bitmap srcImg = BitmapFactory.decodeResource(getResources(), R.drawable.waterdrop);
        cacheCanvas.drawBitmap(srcImg, 30,30,mPaint);

        Matrix horInverseMatrix = new Matrix();
        horInverseMatrix.setScale(-1,1);
        Bitmap horInverseImg = Bitmap.createBitmap(srcImg, 0,0, srcImg.getWidth(), srcImg.getHeight(), horInverseMatrix, false);
        cacheCanvas.drawBitmap(horInverseImg, 30,130,mPaint);

        Matrix verInverseMatrix = new Matrix();
        verInverseMatrix.setScale(1,-1);
        Bitmap verInverseImg = Bitmap.createBitmap(srcImg, 0,0, srcImg.getWidth(), srcImg.getHeight(), verInverseMatrix, false);
        cacheCanvas.drawBitmap(verInverseImg, 30,230,mPaint);

        Bitmap srcImg2 = BitmapFactory.decodeResource(getResources(), R.drawable.face);
        mPaint.setMaskFilter(new BlurMaskFilter(10,BlurMaskFilter.Blur.NORMAL));
        Bitmap scaledImg = Bitmap.createScaledBitmap(srcImg2, srcImg2.getWidth()*2, srcImg2.getHeight()*2, false);
        cacheCanvas.drawBitmap(scaledImg, 100,230,mPaint);

    }
    protected void onDraw(Canvas canvas){
        if(cacheBitmap != null){
            canvas.drawBitmap(cacheBitmap, 0,0,null);
        }
    }
}
