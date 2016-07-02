package com.person.kyluzoi.magnetonview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.person.kyluzoi.magnetonview.AnimationUtils;
import com.person.kyluzoi.magnetonview.MathUtils;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/7/2
 */
public class MagnetonView extends FrameLayout {

    int mCenterR = 20;
    int mCircleR = 10;
    Random random = new Random();



    int mCenterX, mCenterY;
    int mOutsideMAX = 400; //定义最高偏移半径
    ArrayList<TextView> mCircles = new ArrayList<>();
    ArrayList<CircleViewPoint> mCirclesDatas = new ArrayList<>();
    CircleViewPoint mCenterPoint = new CircleViewPoint(0, 0, mCircleR);


    public MagnetonView(Context context) {
        super(context);
        initSetViews(null);
    }

    public MagnetonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initSetViews(attrs);
    }

    public MagnetonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initSetViews(attrs);
    }

    private void initSetViews(AttributeSet attrs) {
        addObzData(mCenterPoint);
//        CircleViewPoint cir111=new CircleViewPoint(20,200,10);
//        CircleViewPoint cir11=new CircleViewPoint(5,-50,10);
//        CircleViewPoint cir1=new CircleViewPoint(7,60,10);
//        addObzData(cir1);
//        addObzData(cir11);
//        addObzData(cir111);
    }


    /**
     * when view pop ,to locate in somewhere ?  translate and floating
     *
     * @param circleViewPoint
     * @param view
     */
    public void locateAnimation(CircleViewPoint circleViewPoint, View view) {
        ObjectAnimator.ofFloat(view, "translationX", view.getX(), circleViewPoint.getTranslateX()).setDuration(1000).start();
        ObjectAnimator.ofFloat(view, "translationY", view.getY(), circleViewPoint.getTranslateY()).setDuration(1000).start();
        floatAnimation(view);
    }

    public void floatAnimation(View view) {
        // TODO: 2016/7/2 当效果实现后，填充在原地的浮动动画或者震动动画
    }

    public void addSubView(/**View view**/) {
        int _x = randomSke();
        int _y = randomSke();
        int i = 0;
        CircleViewPoint circle = new CircleViewPoint(_x, _y, 50);
        for (CircleViewPoint tempcir : mCirclesDatas) {
            if (!MathUtils.measureDistance(circle, tempcir)) {
                addSubView();
                break;
            }
            i++;
        }
        if (i == mCirclesDatas.size()) {
            addObzData(circle);
        }
    }

    public void addObzData(CircleViewPoint circle) {
        mCirclesDatas.add(circle);
        TextView view = new TextView(getContext());
        LayoutParams lytp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.CENTER);
        view.setText(circle.toString());
        view.setGravity(Gravity.CENTER);
        view.setTextSize(10);
        addView(view, lytp);
        locateAnimation(circle, view);
    }

    private int randomSke() {
        return random.nextInt(mOutsideMAX + 200) - 200;
    }

}
