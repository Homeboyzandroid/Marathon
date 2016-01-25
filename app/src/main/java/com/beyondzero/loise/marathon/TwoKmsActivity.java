package com.beyondzero.loise.marathon;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class TwoKmsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_kms);
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
                .add(new LatLng(-1.302748, 36.825594),
                        new LatLng(-1.301874, 36.825178),
                        new LatLng(-1.300919, 36.824733),
                        new LatLng(-1.300206, 36.824416),
                        new LatLng(-1.300064, 36.824352),
                        new LatLng(-1.300016, 36.824325),

                        //BUNYALA/UHURU ROUNDABOUT
                        new LatLng(-1.299946, 36.824333),
                        new LatLng(-1.299911, 36.824341),
                        new LatLng(-1.299839, 36.824338),
                        new LatLng(-1.299761, 36.824306),
                        new LatLng(-1.299732, 36.824274),
                        new LatLng(-1.299711, 36.824226),
                        new LatLng(-1.299668, 36.824196),
                        //UHURU HIGHWAY
                        new LatLng(-1.299547, 36.824172),
                        new LatLng(-1.299346, 36.824141),
                        new LatLng(-1.298788, 36.824015),
                        new LatLng(-1.298651, 36.823964),
                        new LatLng(-1.298552, 36.823929),
                        new LatLng(-1.298477, 36.823894),
                        new LatLng(-1.298354, 36.823848),
                        new LatLng(-1.298215, 36.823776),
                        new LatLng(-1.297746, 36.823502),
                        new LatLng(-1.297389, 36.823295),
                        new LatLng(-1.296855, 36.822987),
                        new LatLng(-1.295935, 36.822443),
                        new LatLng(-1.295530, 36.822196),
                        new LatLng(-1.295251, 36.822024),

                        new LatLng(-1.295168, 36.821984),
                        new LatLng(-1.295080, 36.821944),
                        new LatLng(-1.294187, 36.821410),
                        new LatLng(-1.293627, 36.821069),
                        new LatLng(-1.293399, 36.820913),
                        new LatLng(-1.292983, 36.820672),
                        new LatLng(-1.292862, 36.820602),
                        new LatLng(-1.292835, 36.820578),
                        //HAILESELASE
                        new LatLng(-1.292800, 36.820594),
                        new LatLng(-1.292717, 36.820602),
                        new LatLng(-1.292671, 36.820599),
                        new LatLng(-1.292588, 36.820572),
                        new LatLng(-1.292529, 36.820526),
                        new LatLng(-1.292505, 36.820486),
                        new LatLng(-1.292476, 36.820446),
                        new LatLng(-1.292444, 36.820430),
                        new LatLng(-1.292018, 36.820202),
                        new LatLng(-1.291278, 36.819805),
                        new LatLng(-1.290010, 36.819175),
                        new LatLng(-1.289254, 36.818799),
                        new LatLng(-1.288763, 36.818539),
                        new LatLng(-1.287776, 36.818080),
                        new LatLng(-1.286891, 36.817654),
                        //KENYATTA AVENUE ROUNDABOUT
                        new LatLng(-1.286757, 36.817595),
                        new LatLng(-1.286682, 36.817630),
                        new LatLng(-1.286583, 36.817657),
                        new LatLng(-1.286462, 36.817657),
                        new LatLng(-1.286382, 36.817619),
                        new LatLng(-1.286304, 36.817568),
                        new LatLng(-1.286269, 36.817522),
                        new LatLng(-1.286248, 36.817468),
                        new LatLng(-1.286235, 36.817420),
                        new LatLng(-1.286224, 36.817369),
                        new LatLng(-1.286232, 36.817321),
                        new LatLng(-1.286245, 36.817265),
                        new LatLng(-1.286277, 36.817209),
                        new LatLng(-1.286312, 36.817171),
                        new LatLng(-1.286358, 36.817131),
                        new LatLng(-1.286404, 36.817110),
                        new LatLng(-1.286452, 36.817097),
                        new LatLng(-1.286516, 36.817092),
                        new LatLng(-1.286570, 36.817095),
                        new LatLng(-1.286621, 36.817100),
                        new LatLng(-1.286632, 36.817114),
                        new LatLng(-1.286632, 36.817106),
                        new LatLng(-1.286640, 36.817116),
                        new LatLng(-1.286629, 36.817106),
                        new LatLng(-1.286688, 36.817127),
                        new LatLng(-1.286736, 36.817173),
                        new LatLng(-1.286771, 36.817219),
                        new LatLng(-1.286792, 36.817283),
                        new LatLng(-1.286816, 36.817355),
                        new LatLng(-1.286795, 36.817460),
                        new LatLng(-1.286768, 36.817538),
                        //BACK ON UHRUHIGHWAY
                        new LatLng(-1.286811, 36.817559),
                        new LatLng(-1.287267, 36.817768),
                        new LatLng(-1.287900, 36.818068),
                        new LatLng(-1.288659, 36.818433),
                        new LatLng(-1.289466, 36.818835),
                        new LatLng(-1.290496, 36.819350),
                        new LatLng(-1.291225, 36.819712),
                        new LatLng(-1.292303, 36.820283),
                        new LatLng(-1.292450, 36.820358),
                        new LatLng(-1.292512, 36.820374),
                        new LatLng(-1.292536, 36.820406),
                        new LatLng(-1.292560, 36.820468),
                        new LatLng(-1.292600, 36.820511),
                        new LatLng(-1.292659, 36.820538),
                        new LatLng(-1.292713, 36.820535),
                        new LatLng(-1.292759, 36.820530),
                        new LatLng(-1.292807, 36.820525),
                        new LatLng(-1.292855, 36.820528),
                        new LatLng(-1.292909, 36.820555),
                        new LatLng(-1.293156, 36.820701),
                        new LatLng(-1.293671, 36.821023),
                        new LatLng(-1.294250, 36.821372),
                        new LatLng(-1.294507, 36.821528),
                        new LatLng(-1.294941, 36.821785),
                        new LatLng(-1.295086, 36.821868),
                        new LatLng(-1.295255, 36.821965),
                        new LatLng(-1.295925, 36.822370),
                        new LatLng(-1.296526, 36.822729),
                        new LatLng(-1.297231, 36.823134),
                        new LatLng(-1.298057, 36.823630),
                        new LatLng(-1.298341, 36.823775),
                        new LatLng(-1.298419, 36.823815),
                        new LatLng(-1.298475, 36.823842),
                        new LatLng(-1.298563, 36.823874),
                        new LatLng(-1.298716, 36.823930),
                        new LatLng(-1.298780, 36.823951),
                        new LatLng(-1.298922, 36.823981),
                        new LatLng(-1.299228, 36.824051),
                        new LatLng(-1.299410, 36.824099),
                        new LatLng(-1.299592, 36.824139),
                        new LatLng(-1.299646, 36.824144),
                        new LatLng(-1.299697, 36.824144),
                        new LatLng(-1.299724, 36.824208),
                        new LatLng(-1.299770, 36.824256),
                        new LatLng(-1.299805, 36.824275),
                        new LatLng(-1.299859, 36.824280),
                        new LatLng(-1.299913, 36.824275),
                        new LatLng(-1.299967, 36.824270),
                        new LatLng(-1.300021, 36.824270),
                        new LatLng(-1.300056, 36.824281),
                        new LatLng(-1.300531, 36.824485),
                        new LatLng(-1.300855, 36.824635),
                        new LatLng(-1.301166, 36.824769),
                        new LatLng(-1.301539, 36.824938),
                        new LatLng(-1.301936, 36.825130),
                        new LatLng(-1.302105, 36.825208),
                        new LatLng(-1.302234, 36.825272),
                        new LatLng(-1.302379, 36.825336),

                        new LatLng(-1.302574, 36.825428),
                        new LatLng(-1.302775, 36.825522)



                );
        Polyline shortrace=mMap.addPolyline(fivekms);
    }
}
