package org.androidtown.doitmission_11;
import java.io.OutputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class PaintBoard extends View {
    Canvas mCanvas;
    Bitmap mBitmap;
    final Paint mPaint;
    int lastX,lastY;

    public PaintBoard(Context context) {
        super(context);

        this.mPaint = new Paint();
        this.mPaint.setColor(Color.BLACK);

        this.lastX = -1;
        this.lastY = -1;

        Log.i("PaintBoard", "initialized.");
    }
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Bitmap img = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(img);
        canvas.drawColor(Color.WHITE);

        mBitmap = img;
        mCanvas = canvas;

    }
    protected void onDraw(Canvas canvas) {
        if (mBitmap != null) {
            canvas.drawBitmap(mBitmap, 0, 0, null);
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        int X = (int) event.getX();
        int Y = (int) event.getY();

        switch (action) {
            case MotionEvent.ACTION_UP:
                // reset coordinates
                lastX = -1;
                lastY = -1;

                break;

            case MotionEvent.ACTION_DOWN:
                // draw line with the coordinates
                if (lastX != -1) {
                    if (X != lastX || Y != lastY) {
                        mCanvas.drawLine(lastX, lastY, X, Y, mPaint);
                    }
                }

                // set the last coordinates
                lastX = X;
                lastY = Y;

                break;

            case MotionEvent.ACTION_MOVE:
                // draw line with the coordinates
                if (lastX != -1) {
                    mCanvas.drawLine(lastX, lastY, X, Y, mPaint);
                }

                lastX = X;
                lastY = Y;

                break;
        }
        invalidate();

        return true;
    }
    public boolean Save(OutputStream outstream) {
        try {
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outstream);
            invalidate();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
