package com.sunny.acadgild.mock3.locateacadgild;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMapClickListener {
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }

            mMap.setOnMapClickListener(this);
        }
    }

    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(12.961727, 77.638462)).title("ACADGILD"));

        CameraUpdate center=
                CameraUpdateFactory.newLatLng(new LatLng(12.9618373, 77.638049));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(17);
        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        mMap.addMarker(new MarkerOptions().position(latLng).title("Title")) ;
    }
}