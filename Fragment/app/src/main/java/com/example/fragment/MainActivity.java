package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cl(View v){
        fragment1 f=new fragment1();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.r1,f,"frag").commit();
    }

}