package com.example.practical4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.DialogInterface;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button b1=(Button)findViewById(R.id.button);
       final EditText e1=(EditText)findViewById(R.id.editText);

       b1.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v)
           {
               AlertDialog.Builder a= new AlertDialog.Builder(MainActivity.this);
               a.setMessage("Do you want to call ?");
               a.setPositiveButton("Yes", (dialog, which) -> {
                    Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:91"+e1.getText()));
                    startActivity(i);
               });
               a.setNegativeButton("No", new DialogInterface.OnClickListener()  {
                   @Override
                   public void onClick(DialogInterface dialog,int which){
                       dialog.cancel();
                   }
               });
               a.create().show();
           }
       });

    }
}
