package com.ptpmctbdd.nhom13.albums;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Nav_Location extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav__location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        ArrayList<LatLng> location = new ArrayList<>();
        int count = 0;


        location.add(new LatLng(Albums.albumsList.get(0).getPicturesList().get(0).getLongitude(),
                Albums.albumsList.get(0).getPicturesList().get(0).getLatitude()));
        Marker marker = mMap.addMarker(new MarkerOptions()
                .title(Albums.albumsList.get(0).getPicturesList().get(0).getName())
                .position(location.get(count)));
        count++;

        location.add(new LatLng(Albums.albumsList.get(0).getPicturesList().get(2).getLongitude(),
                Albums.albumsList.get(0).getPicturesList().get(2).getLatitude()));
        mMap.addMarker(new MarkerOptions()
                .title(Albums.albumsList.get(0).getPicturesList().get(2).getName())
                .position(location.get(count)));
        count++;

        location.add(new LatLng(Albums.albumsList.get(0).getPicturesList().get(7).getLongitude(),
                Albums.albumsList.get(0).getPicturesList().get(7).getLatitude()));
        mMap.addMarker(new MarkerOptions()
                .title(Albums.albumsList.get(0).getPicturesList().get(7).getName())
                .position(location.get(count)));
        count++;

        location.add(new LatLng(Albums.albumsList.get(1).getPicturesList().get(0).getLongitude(),
                Albums.albumsList.get(1).getPicturesList().get(0).getLatitude()));
        mMap.addMarker(new MarkerOptions()
                .title(Albums.albumsList.get(1).getPicturesList().get(0).getName())
                .position(location.get(count)));
        count++;

        location.add(new LatLng(Albums.albumsList.get(1).getPicturesList().get(1).getLongitude(),
                Albums.albumsList.get(1).getPicturesList().get(1).getLatitude()));
        mMap.addMarker(new MarkerOptions()
                .title(Albums.albumsList.get(1).getPicturesList().get(1).getName())
                .position(location.get(count)));
        count++;

        location.add(new LatLng(Albums.albumsList.get(1).getPicturesList().get(7).getLongitude(),
                Albums.albumsList.get(1).getPicturesList().get(7).getLatitude()));
        mMap.addMarker(new MarkerOptions()
                .title(Albums.albumsList.get(1).getPicturesList().get(7).getName())
                .position(location.get(count)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location.get(0), 13));

    }

}
