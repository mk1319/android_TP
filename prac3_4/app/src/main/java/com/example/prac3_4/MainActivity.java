package com.example.prac3_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView a1;
        a1 = (AutoCompleteTextView) findViewById(R.id.t1);
        String country_list[]={"india","indonasia","australia","england","usa"};
        ArrayAdapter<String> ad=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,country_list);
        a1.setAdapter(ad);
        a1.setThreshold(1);
        }
    }


        

