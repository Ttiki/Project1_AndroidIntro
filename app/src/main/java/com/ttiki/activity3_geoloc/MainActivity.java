package com.ttiki.activity3_geoloc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity {

    TextView lonLab, latLab;
    Button getLonLabBtn;
    private FusedLocationProviderClient geoLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geoLoc = LocationServices.getFusedLocationProviderClient(this);

        latLab = (TextView) findViewById(R.id.latLab);
        lonLab = (TextView) findViewById(R.id.longLab);
        getLonLabBtn = (Button) findViewById(R.id.btnGetLatLong);

//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        geoLoc.getLastLocation()
//                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
//                    @Override
//                    public void onSuccess(Location loc) {
//                        // De temps en temps la géoloc retournée peut être null.
//                        // On test ce cas ici
//                        if (loc != null) {
//                            latLab.setText("Error!");
//                            lonLab.setText("Error!");
//                        }
//                        latLab.setText(Double.toString((double) loc.getLatitude()));
//                        lonLab.setText(Double.toString((double) loc.getLongitude()));
//                    }
//                });

    }
}