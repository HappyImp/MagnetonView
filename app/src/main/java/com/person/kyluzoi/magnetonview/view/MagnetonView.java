package com.person.kyluzoi.magnetonview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;

/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/7/2
 */
public class MagnetonView extends FrameLayout {

    int mCenterR = 20;
    int mCircleR = 10;


    int mCenterX, mCenterY;
    int mOutsideMAX = 500; //定义最高偏移半径
    ArrayList<TextView> mCircles = new ArrayList<>();


    public MagnetonView(Context context) {
        super(context);
        TextView view1 = new TextView(getContext());
    }

    public MagnetonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MagnetonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * when view pop ,to locate in somewhere ?  translate and floating
     *
     * @param circleViewPoint
     * @param view
     */
    public void locateAnimation(CircleViewPoint circleViewPoint, View view) {
        ViewHelper.setTranslationY(view, circleViewPoint.translateY);
        ViewHelper.setTranslationX(view, circleViewPoint.translateX);
        floatAnimation();
    }

    public void floatAnimation() {
        // TODO: 2016/7/2 当效果实现后，填充在原地的浮动动画或者震动动画
    }

}
