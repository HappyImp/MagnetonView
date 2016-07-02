package com.person.kyluzoi.magnetonview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/7/1
 */
public class MagneText extends TextView {

    //animation is running ? boolean
    private boolean mAnimationRunning = false;


    public MagneText(Context context) {
        super(context);
    }

    public MagneText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
