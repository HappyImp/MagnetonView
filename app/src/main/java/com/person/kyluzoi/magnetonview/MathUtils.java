package com.person.kyluzoi.magnetonview;


import com.person.kyluzoi.magnetonview.view.CircleViewPoint;

/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/7/2
 */
public class MathUtils {

    public static boolean measureDistance(CircleViewPoint p1 , CircleViewPoint p2)
    {
        int distanceMin=p1.getCircleR()+p2.getCircleR();  //get circle min distance
        int _dx=Math.abs(p1.getTranslateX()-p2.getTranslateX());
        int _dy=Math.abs(p1.getTranslateY()-p2.getTranslateY());
        int tempDis= (int) Math.sqrt(
                (_dx*_dx) +
                (_dy*_dy));
        return tempDis-distanceMin>0?true:false;
    }
}
