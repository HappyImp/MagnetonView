package com.person.kyluzoi.magnetonview.view;

/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/7/2
 */
public class CircleViewPoint {

    int translateX;
    int translateY;
    int circleR;

    public CircleViewPoint(int translateX,int translateY,int circleR)
    {
        this.translateX=translateX;
        this.translateY=translateY;
        this.circleR=circleR;
    }

    public int getTranslateX() {
        return translateX;
    }

    public void setTranslateX(int translateX) {
        this.translateX = translateX;
    }

    public int getTranslateY() {
        return translateY;
    }

    public void setTranslateY(int translateY) {
        this.translateY = translateY;
    }

    public int getCircleR() {
        return circleR;
    }

    public void setCircleR(int circleR) {
        this.circleR = circleR;
    }

    @Override
    public String toString() {
        return "当前圆的X偏移量"+translateX+"/n当前圆的Y偏移量"+translateY+"/n当前圆半径应为"+circleR;
    }
}

