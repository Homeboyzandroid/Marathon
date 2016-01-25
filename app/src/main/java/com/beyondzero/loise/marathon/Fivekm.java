package com.beyondzero.loise.marathon;

import android.graphics.Color;
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
            // Add a marker in nyayostadium and move the camera
            LatLng nyayostadium = new LatLng(-1.302789, 36.825455);
            LatLng endpoint=new LatLng(-1.302810, 36.825393);
            // LatLng nyayostadium = new LatLng(-18.142, 178.431);
            mMap.addMarker(new MarkerOptions().position(nyayostadium).title("STARTING POINT").flat(true));
            mMap.addMarker(new MarkerOptions().position(endpoint).title("FINISH POINT").rotation(-90));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nyayostadium, 15));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

        PolylineOptions fivekms= new PolylineOptions()
                .add(new LatLng(-1.302789, 36.825455),
                        new LatLng(-1.301370, 36.824792),
                        new LatLng(-1.300225, 36.824250),
                        new LatLng(-1.300091, 36.824191),
                        new LatLng(-1.300005, 36.824161),
                        new LatLng(-1.299994, 36.824110),
                        new LatLng(-1.299975, 36.824051),
                        new LatLng(-1.299948, 36.824021),
                        new LatLng(-1.299889, 36.823989),
                        new LatLng(-1.299776, 36.824005),
                        new LatLng(-1.299738, 36.824035),
                        new LatLng(-1.299692, 36.824043),
                        new LatLng(-1.299574, 36.824027),
                        new LatLng(-1.299247, 36.823965),
                        new LatLng(-1.299014, 36.823919),
                        new LatLng(-1.298644, 36.823820),
                        new LatLng(-1.298502, 36.823772),
                        new LatLng(-1.298349, 36.823689),
                        new LatLng(-1.297893, 36.823432),
                        new LatLng(-1.297493, 36.823183),
                        new LatLng(-1.296672, 36.822711),
                        new LatLng(-1.295833, 36.822220),
                        new LatLng(-1.295275, 36.821874),
                        new LatLng(-1.295149, 36.821820),
                        new LatLng(-1.294591, 36.821463),
                        new LatLng(-1.293403, 36.820741),
                        new LatLng(-1.292928, 36.820459),
                        new LatLng(-1.292860, 36.820437),
                        new LatLng(-1.292868, 36.820389),
                        new LatLng(-1.292863, 36.820354),
                        new LatLng(-1.292834, 36.820298),
                        new LatLng(-1.292759, 36.820252),
                        new LatLng(-1.292695, 36.820231),
                        new LatLng(-1.292633, 36.820247),
                        new LatLng(-1.292579, 36.820268),
                        new LatLng(-1.292533, 36.820271),
                        new LatLng(-1.292415, 36.820212),
                       //after haile sellase round about
                        new LatLng(-1.292166, 36.820083),
                        new LatLng(-1.290190, 36.819093),
                        new LatLng(-1.288742, 36.818363),
                        new LatLng(-1.287015, 36.817507),
                        new LatLng(-1.286862, 36.817428),
                        //moi avenue roundabout
                        new LatLng(-1.286782, 36.817398),
                        new LatLng(-1.286785, 36.817355),
                        new LatLng(-1.286774, 36.817291),
                        new LatLng(-1.286747, 36.817227),
                        new LatLng(-1.286699, 36.817173),
                        new LatLng(-1.286712, 36.817114),
                        new LatLng(-1.286720, 36.817055),



                        /*//HAILE SELLASE ROUND ABOUT
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
                        new LatLng(-1.286718, 36.817178),*/
                       new LatLng(-1.286760, 36.817025),
                        new LatLng(-1.286787, 36.816979),
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
                        new LatLng(-1.302483, 36.825244),
                        new LatLng(-1.302810, 36.825393)


                ).width(12).color(Color.BLUE);;
        Polyline shortrace=mMap.addPolyline(fivekms);
                           }

}
