 package com.example.email;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    EditText to;
    EditText subject;
    EditText message;
    Button mailbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        to=(EditText)findViewById(R.id.to);
        subject=(EditText)findViewById(R.id.subject);
        message=(EditText)findViewById(R.id.message);
        mailbtn=(Button)findViewById(R.id.mailbtn);
        mailbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if(to.getText().equals("")||subject.getText().equals("")||message.getText().equals(""))
                {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.setTitle("Alert");
                    alertDialogBuilder.setMessage("Enter all fields");
                    alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener()
                    {@Override public void onClick(DialogInterface dialogInterface, int i) { }});
                    AlertDialog ad = alertDialogBuilder.create();
                    ad.show();
                }
                else{
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{to.getText().toString()});
                    email.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
                    email.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                    startActivity(Intent.createChooser(email, "Choose an Email client :"));

                }
            }
        });

    }
}