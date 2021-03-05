package com.example.workerthread;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ImageView imageview;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn);
        imageview = (ImageView)findViewById(R.id.imageview);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                new DownloadImage().execute();
            }
        });
    }

    private class DownloadImage extends AsyncTask<String, Void, Bitmap>
    {
        @Override
        protected Bitmap doInBackground(String... params)
        {
            Bitmap bitmap = null;
            try
            {
                InputStream input = new java.net.URL("https://wallpapercave.com/wp/enoyJRu.jpg").openStream();
                bitmap = BitmapFactory.decodeStream(input);
            }
            catch (Exception e)
            {
                Log.i("Exception",e.toString());
            }
            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap image)
        {
            pd.dismiss();
            imageview.setImageBitmap(image);
        }

        @Override
        protected void onPreExecute()
        {
            pd = new ProgressDialog(MainActivity.this);
            pd.setTitle("Please wait...");
            pd.setMessage("Downloading Image");
            pd.setCancelable(false);
            pd.setIndeterminate(false);
            pd.show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {}
    }


}

