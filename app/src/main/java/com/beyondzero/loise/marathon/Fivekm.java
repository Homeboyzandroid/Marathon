package com.beyondzero.loise.marathon;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class Fivekm extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fivekm);
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
        LatLng mapCenter = new LatLng(-1.302810, 36.825408);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter, 13));

        // Flat markers will rotate when the map is rotated,
        // and change perspective when the map is tilted.
        mMap.addMarker(new MarkerOptions()

                .position(mapCenter)
                .flat(true)
                .rotation(245));

        CameraPosition cameraPosition = CameraPosition.builder()
                .target(mapCenter)
                .zoom(13)
                .bearing(90)
                .build();

        // Animate the change in camera view over 2 seconds
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
                2000, null);

        PolylineOptions fivekms= new PolylineOptions()
                .add(new LatLng(-1.302810, 36.825408),
                        new LatLng(-1.302665, 36.825349),
                        new LatLng(-1.302477, 36.825279),
                        new LatLng(-1.302338, 36.825215),
                        new LatLng(-1.302188, 36.825151),
                        new LatLng(-1.302032, 36.825076),
                        new LatLng(-1.301882, 36.824990),
                        new LatLng(-1.301726, 36.824920),
                        new LatLng(-1.301463, 36.824791),
                        new LatLng(-1.301265, 36.824705),
                        new LatLng(-1.301056, 36.824608),
                        new LatLng(-1.300895, 36.824538),
                        new LatLng(-1.300718, 36.824447),
                        new LatLng(-1.300321, 36.824265),
                        new LatLng(-1.300085, 36.824168),
                        new LatLng(-1.300031, 36.824147),
                        new LatLng(-1.300036, 36.824088),
                        new LatLng(-1.300015, 36.824018),
                        new LatLng(-1.299956, 36.823980),
                        new LatLng(-1.299870, 36.823953),
                        new LatLng(-1.299768, 36.824007),
                        new LatLng(-1.299682, 36.824039),
                        new LatLng(-1.299623, 36.824007),
                        new LatLng(-1.299382, 36.823969),
                        new LatLng(-1.299261, 36.823949),
                        new LatLng(-1.299111, 36.823919),
                        new LatLng(-1.298969, 36.823881),
                        new LatLng(-1.298846, 36.823860),
                        new LatLng(-1.298717, 36.823812),
                        new LatLng(-1.298615, 36.823782),
                        new LatLng(-1.298543, 36.823744),
                        new LatLng(-1.298452, 36.823709),
                        new LatLng(-1.298355, 36.823671),
                        new LatLng(-1.298285, 36.823636),
                        new LatLng(-1.298186, 36.823585),
                        new LatLng(-1.298073, 36.823507),
                        new LatLng(-1.297971, 36.823459),
                        //large gaps
                        new LatLng(-1.296917, 36.822815),
                        new LatLng(-1.296027, 36.822289),
                        new LatLng(-1.295721, 36.822101),
                        new LatLng(-1.295378, 36.821903),
                        new LatLng(-1.295126, 36.821764),
                        new LatLng(-1.294737, 36.821520),
                        new LatLng(-1.294461, 36.821346),
                        new LatLng(-1.294158, 36.821166),
                        new LatLng(-1.293820, 36.820954),
                        new LatLng(-1.293520, 36.820782),
                        new LatLng(-1.293281, 36.820632),
                        new LatLng(-1.293107, 36.820525),
                        new LatLng(-1.293005, 36.820463),
                        new LatLng(-1.292927, 36.820428),


                        //HAILE SELLASE ROUND ABOUT
                        new LatLng(-1.292884, 36.820278),
                        new LatLng(-1.292777, 36.820203),
                        new LatLng(-1.292605, 36.820278),
                        new LatLng(-1.292530, 36.820224),
                        //stl on uhuru highway
                        new LatLng(-1.292423, 36.820149),
                        new LatLng(-1.291179, 36.819537),
                        new LatLng(-1.289763, 36.818840),
                        new LatLng(-1.288230, 36.818068),
                        new LatLng(-1.286889, 36.817414),
                        new LatLng(-1.286814, 36.817350),
                        new LatLng(-1.286782, 36.817221),
                        new LatLng(-1.286718, 36.817178),
                        new LatLng(-1.286718, 36.817071),
                        new LatLng(-1.286793, 36.816953),
                        new LatLng(-1.286847, 36.816803),
                        new LatLng(-1.286944, 36.816610),
                        new LatLng(-1.287255, 36.815998),
                        new LatLng(-1.287834, 36.814818),
                        new LatLng(-1.287888, 36.814721),
                        //PROCESIONAL WAY TURN LEFT
                        new LatLng(-1.287985, 36.814667),
                        new LatLng(-1.288103, 36.814721),
                        new LatLng(-1.288725, 36.815054),
                        //Procesional way
                        new LatLng(-1.289283, 36.815365),
                        new LatLng(-1.289819, 36.815655),
                        new LatLng(-1.290977, 36.816224),
                        new LatLng(-1.291331, 36.816396),
                        new LatLng(-1.291513, 36.816439),
                        new LatLng(-1.291652, 36.816471),
                        new LatLng(-1.292639, 36.816546),
                        new LatLng(-1.293036, 36.816589),
                        new LatLng(-1.293175, 36.816600),
                        new LatLng(-1.293263, 36.816617),
                        new LatLng(-1.293373, 36.816647),
                        new LatLng(-1.293373, 36.816647),
                        new LatLng(-1.293419, 36.816666),
                        //hailesellase turn left
                        new LatLng(-1.293454, 36.816696),
                        new LatLng(-1.293414, 36.816960),
                        new LatLng(-1.293267, 36.817741),
                        new LatLng(-1.292959, 36.819227),
                        new LatLng(-1.292865, 36.819788),
                        new LatLng(-1.292844, 36.819863),
                        new LatLng(-1.292847, 36.820166),
                        new LatLng(-1.292866, 36.820244),
                        new LatLng(-1.292890, 36.820319),
                        //UHURU HIGHWAY BACK T STARTING POINT
                        new LatLng(-1.292914, 36.820383),
                        new LatLng(-1.293045, 36.820455),
                        new LatLng(-1.293558, 36.820764),
                        new LatLng(-1.294167, 36.821134),
                        new LatLng(-1.294167, 36.821134),
                        new LatLng(-1.295028, 36.821688),
                        new LatLng(-1.295125, 36.821739),
                        new LatLng(-1.295415, 36.821897),
                        new LatLng(-1.296284, 36.822407),
                        new LatLng(-1.297046, 36.822863),
                        new LatLng(-1.298038, 36.823440),
                        new LatLng(-1.298384, 36.823641),
                        new LatLng(-1.298540, 36.823721),
                        new LatLng(-1.298934, 36.823839),
                        new LatLng(-1.299285, 36.823922),
                        new LatLng(-1.299518, 36.823954),
                        new LatLng(-1.299698, 36.823978),
                        //BUNYALA ROUND ABOUT
                        new LatLng(-1.299730, 36.823973),
                        new LatLng(-1.299794, 36.823943),
                        new LatLng(-1.299842, 36.823932),
                        new LatLng(-1.299896, 36.823935),
                        new LatLng(-1.299963, 36.823970),
                        new LatLng(-1.300006, 36.824018),
                        new LatLng(-1.300041, 36.824093),
                        new LatLng(-1.300084, 36.824141),
                        new LatLng(-1.300540, 36.824334),
                        new LatLng(-1.301044, 36.824562),
                        new LatLng(-1.301757, 36.824903),
                        new LatLng(-1.301958, 36.824994),
                        new LatLng(-1.302000, 36.825024),
                        new LatLng(-1.302483, 36.825244)
                );
        Polyline shortrace=mMap.addPolyline(fivekms);
                           }

}
