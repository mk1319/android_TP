package com.example.camera;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.graphics.Bitmap;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn=(Button)findViewById(R.id.btn);
        imageview=(ImageView)findViewById(R.id.iv);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent camera=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera,9999);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (!(resultCode != 9999 && resultCode != Activity.RESULT_OK)) {
            Bitmap photo;
            photo = (Bitmap) data.getExtras().get("data");

            imageview.setImageBitmap(photo);
        }
    }
}