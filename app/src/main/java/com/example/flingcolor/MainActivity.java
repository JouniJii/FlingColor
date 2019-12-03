package com.example.flingcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class MainActivity extends AppCompatActivity {

    Context context;
    GestureDetector gestureDetector;
    static View myView;
    static int maxVelocity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (context == null) {
            this.context = getApplicationContext();
        }

        gestureDetector = new GestureDetector(context, new MySimpleOnGestureListener());

        myView = findViewById(R.id.frameLayout);

        maxVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
