package org.androidtown.simplebitmapwidget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;

import java.util.jar.Attributes;

import static android.provider.ContactsContract.ProviderStatus.STATUS_NORMAL;

public class BitmapButton extends AppCompatButton {
    int iconNormal = R.drawable.bitmap_button_normal;
    int iconClicked = R.drawable.bitmap_button_clicked;

    int iconStatus = STATUS_NORMAL;
    public static int STATUS_NORMAL = 0;
    public static int STATUS_CLICKED = 1;

    public BitmapButton(Context context) {
        super(context);

        init();
    }

    public BitmapButton(Context context, AttributeSet atts) {
        super(context, atts);
        init();
    }

    public void init() {
        setBackgroundResource(iconNormal);

        int defaultTextColor = Color.WHITE;
        float defaultTextSize = getResources().getDimension(R.dimen.text_size);
        Typeface defaultTypeface = Typeface.DEFAULT_BOLD;

        setTextColor(defaultTextColor);
        setTextSize(defaultTextSize);
        setTypeface(defaultTypeface);
    }

    public void setIcon(int iconNormal, int iconClicked) {
        this.iconNormal = iconNormal;
        this.iconClicked = iconClicked;
    }

    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                setBackgroundResource(this.iconClicked);
                iconStatus = STATUS_CLICKED;
                break;

            case MotionEvent.ACTION_OUTSIDE:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                setBackgroundResource(this.iconNormal);

                iconStatus = STATUS_NORMAL;

                break;
        }
        invalidate();

        return true;
    }
}
