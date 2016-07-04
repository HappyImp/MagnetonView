package com.person.kyluzoi.magnetonview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.person.kyluzoi.magnetonview.R;

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
        initSetView(null);
    }

    public MagneText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initSetView(attrs);

    }

    private void initSetView(AttributeSet attrs) {
        this.setBackground(getResources().getDrawable(R.drawable.bg_circle));
    }
}
