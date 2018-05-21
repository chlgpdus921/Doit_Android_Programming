package org.techtown.samplepagesliding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    /**
     * �럹�씠吏�媛� �뿴�젮 �엳�뒗吏� �븣湲� �쐞�븳 �뵆�옒洹�
     */
    boolean isPageOpen = false;

    /**
     * �븷�땲硫붿씠�뀡 媛앹껜
     */
    Animation translateLeftAnim;
    Animation translateRightAnim;

    /**
     * �뒳�씪�씠�뵫�쑝濡� 蹂댁뿬吏��뒗 �럹�씠吏� �젅�씠�븘�썐
     */
    LinearLayout page;

    /**
     * 踰꾪듉
     */
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        // �뒳�씪�씠�뵫�쑝濡� 蹂댁뿬吏� �젅�씠�븘�썐 媛앹껜 李몄“
        page = (LinearLayout) findViewById(R.id.page);

        // �븷�땲硫붿씠�뀡 媛앹껜 濡쒕뵫
        translateLeftAnim = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRightAnim = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        // �븷�땲硫붿씠�뀡 媛앹껜�뿉 由ъ뒪�꼫 �꽕�젙
        SlidingPageAnimationListener animListener = new SlidingPageAnimationListener();
        translateLeftAnim.setAnimationListener(animListener);
        translateRightAnim.setAnimationListener(animListener);

    }

    public void onButton1Clicked(View v) {
        // �븷�땲硫붿씠�뀡 �쟻�슜
        if (isPageOpen) {
            page.startAnimation(translateRightAnim);
        } else {
            page.setVisibility(View.VISIBLE);
            page.startAnimation(translateLeftAnim);
        }
    }

    /**
     * �븷�땲硫붿씠�뀡 由ъ뒪�꼫 �젙�쓽
     */
    private class SlidingPageAnimationListener implements Animation.AnimationListener {
        /**
         * �븷�땲硫붿씠�뀡�씠 �걹�궇 �븣 �샇異쒕릺�뒗 硫붿냼�뱶
         */
        public void onAnimationEnd(Animation animation) {
            if (isPageOpen) {
                page.setVisibility(View.INVISIBLE);

                button.setText("Open");
                isPageOpen = false;
            } else {
                button.setText("Close");
                isPageOpen = true;
            }
        }

        public void onAnimationRepeat(Animation animation) {

        }

        public void onAnimationStart(Animation animation) {

        }

    }

}
