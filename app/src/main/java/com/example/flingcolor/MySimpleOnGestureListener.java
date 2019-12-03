package com.example.flingcolor;

import android.graphics.Color;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MySimpleOnGestureListener extends GestureDetector.SimpleOnGestureListener {

    private int[] colors = new int[]{Color.BLACK, Color.WHITE};
    private int colorIndex = 0;

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        colorIndex++;
        MainActivity.myView.setBackgroundColor(colors[colorIndex % colors.length]);
        return super.onDoubleTap(e);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        float xPercent = Math.abs(velocityX) / MainActivity.maxVelocity;
        float yPercent = Math.abs(velocityY) / MainActivity.maxVelocity;

        int red = (int) (xPercent * 255);
        int green = 0;
        int blue = (int) (yPercent * 255);
        int flingColor = 0xff << 24 | red << 16 | green << 8 | blue;

        MainActivity.myView.setBackgroundColor(flingColor);

        return super.onFling(e1, e2, velocityX, velocityY);
    }
}
