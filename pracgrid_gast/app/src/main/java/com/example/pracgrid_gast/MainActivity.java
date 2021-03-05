package com.example.pracgrid_gast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GridView g1=(GridView)findViewById(R.id.g1);
        String list[]={"January","February","March","April","May","June","July",
                "August","September","October","November","December"};

        ArrayAdapter<String> add=new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_dropdown_item_1line,list);
        g1.setAdapter(add);
    }
}