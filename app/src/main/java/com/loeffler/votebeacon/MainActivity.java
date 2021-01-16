package com.loeffler.votebeacon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.uriio.beacons.Beacons;
import com.uriio.beacons.model.Beacon;
import com.uriio.beacons.model.EddystoneURL;

public class MainActivity extends AppCompatActivity {
    boolean beaconOn = false;
    Beacon urlBeacon = new EddystoneURL("https://naleo.org/vote/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Beacons.initialize(this);
        final ImageButton beaconbutton = (ImageButton)findViewById(R.id.beaconbutton);
        beaconbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (beaconOn == false) {
                    beaconbutton.setImageResource(R.drawable.beaconon);  // Display that the beacon is on
                    urlBeacon.start();  // Start broadcasting
                } else {
                    beaconbutton.setImageResource(R.drawable.beaconoff);  // Display that the beacon is off
                    urlBeacon.stop();  // Stop broadcasting
                }
            }
        });
    }
}