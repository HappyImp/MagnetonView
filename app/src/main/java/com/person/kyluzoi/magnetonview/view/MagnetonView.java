package com.person.kyluzoi.magnetonview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nineoldandroids.animation.ObjectAnimator;
import com.person.kyluzoi.magnetonview.MathUtils;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/7/2
 */
public class MagnetonView extends FrameLayout {

    int mCenterR = 30;
    int mCircleR = 10;
    Random random = new Random();



    int mCenterX, mCenterY;
    int mOutsideMAX = 300; //定义最高偏移半径
    ArrayList<TextView> mCircles = new ArrayList<>();
    ArrayList<CircleViewPoint> mCirclesDatas = new ArrayList<>();
    CircleViewPoint mCenterPoint = new CircleViewPoint(0, 0, mCenterR);


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
        try {

            int _x = randomSke();
            int _y = randomSke();
            int i = 0;
            CircleViewPoint circle = new CircleViewPoint(_x, _y, mCircleR);
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
        catch (StackOverflowError e)
        {

            // TODO: 2016/7/2 这里可以做减小半径的操作 然后递归  
//            Toast.makeText(getContext(), "出不来了", Toast.LENGTH_SHORT).show();
            mCircleR=mCircleR-2;
            Log.d("MagnetonView", "出不来了");
        }
    }

    public void addObzData(CircleViewPoint circle) {
        mCirclesDatas.add(circle);
        MagneText view = new MagneText(getContext());
        LayoutParams lytp = new LayoutParams(circle.getCircleR()*2, circle.getCircleR()*2, Gravity.CENTER);
        view.setText(circle.toString());
        view.setGravity(Gravity.CENTER);
        view.setTextSize(10);
        addView(view, lytp);
        locateAnimation(circle, view);
    }

    private int randomSke() {
        return random.nextInt(mOutsideMAX + mOutsideMAX) - mOutsideMAX;
    }

}
