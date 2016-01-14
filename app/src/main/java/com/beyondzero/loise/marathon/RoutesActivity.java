package com.beyondzero.loise.marathon;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class RoutesActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);
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

        // Add a marker in nyayostadium and move the camera
        LatLng nyayostadium = new LatLng(-1.304547, 36.824365);
       // LatLng nyayostadium = new LatLng(-18.142, 178.431);
        mMap.addMarker(new MarkerOptions().position(nyayostadium).title("Nyayo stadium").snippet("Marathon starting point"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nyayostadium, 15));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

        mMap.addPolygon(new PolygonOptions().geodesic(true)
                .add(new LatLng(-1.304711, 36.826273))
                .add(new LatLng(-1.300065, 36.823959))
                .add(new LatLng(-1.295560, 36.817811))
                .add(new LatLng(-1.293704, 36.815730))
                .add(new LatLng(-1.295463, 36.809657))
                .add(new LatLng(-1.297801, 36.803520))
                .add(new LatLng(-1.300075, 36.802973))
                .add(new LatLng(-1.301566, 36.802415))
                .add(new LatLng(-1.314645, 36.809262))
                .add(new LatLng(-1.312671, 36.815388))
        );



    }
}
