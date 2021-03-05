package com.example.gesture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public abstract class MainActivity2 extends AppCompatActivity implements GestureDetector.OnGestureListener{

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
    public void onLongPress(MotionEvent e) {
        t1.setText("Long Press");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        t1.setText("Single Tap");
        return false;
    }
}