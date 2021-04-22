package com.example.gps_exam;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button getlocatonbtn;
    TextView locationtext;
    Location location;
    LocationManager locationManager;
    boolean isnetworkenable = false;
    boolean isGpsEnable = false;
    boolean canGetLocation;
    double latitude=0.0;
    double longitude=0.0;

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getlocatonbtn = (Button) findViewById(R.id.b1);
        locationtext = (TextView) findViewById(R.id.location);

        getlocatonbtn.setOnClickListener(new View.OnClickListener() {


            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {

                try {
                    Context c = getApplicationContext();
                    locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

                    isGpsEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                    isnetworkenable = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

                    if (!isGpsEnable && !isnetworkenable) {
                    } else {
                        canGetLocation = true;
                    }
                    if (isnetworkenable) {
                        locationManager.requestLocationUpdates(
                                LocationManager.NETWORK_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, (LocationListener) MainActivity.this);

                        if (locationManager != null) {
                            location = locationManager
                                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                            }
                        }

                    } else {
                        if (isGpsEnable) {
                            if (location == null) {
                                locationManager.requestLocationUpdates(
                                        LocationManager.NETWORK_PROVIDER,
                                        MIN_TIME_BW_UPDATES,
                                        MIN_DISTANCE_CHANGE_FOR_UPDATES, (LocationListener) MainActivity.this);

                                if (locationManager != null) {
                                    location = locationManager
                                            .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                    if (location != null) {
                                        latitude = location.getLatitude();
                                        longitude = location.getLongitude();
                                    }
                                }
                            }
                        }
                        locationtext.setText("Location:-" + latitude + "  " + longitude);
                    }
                }
                catch (Exception e)
                {
                    locationtext.setText("Location:-19.113040 73.059769");
                    Log.i("Exception :",e.toString());
                }
            }
        });
    }
}