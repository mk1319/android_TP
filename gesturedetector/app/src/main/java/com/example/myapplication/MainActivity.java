package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public  class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    private TextView t1;
    private GestureDetectorCompat detect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=(TextView)findViewById(R.id.t1);
        this.detect=new GestureDetectorCompat(this,this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.detect.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        t1.setText("Scroll");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        t1.setText("Down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
            t1.setText("Show Press");
    }

    @Override
    public void onLongPress(MotionEvent e) {
        t1.setText("Long Press");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            t1.setText("Filling");
        return true;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        t1.setText("Single Tap");
        return false;
    }
}