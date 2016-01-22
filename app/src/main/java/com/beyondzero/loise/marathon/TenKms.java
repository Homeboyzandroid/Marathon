package com.beyondzero.loise.marathon;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.w3c.dom.Document;

import java.util.ArrayList;

public class TenKms extends FragmentActivity implements OnMapReadyCallback {

GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_kms);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        // Add a marker in nyayostadium and move the camera
        LatLng nyayostadium = new LatLng(-1.302810, 36.825408);
        // LatLng nyayostadium = new LatLng(-18.142, 178.431);
        mMap.addMarker(new MarkerOptions().position(nyayostadium).title("STARTING POINT").flat(true));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nyayostadium, 15));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);



        //final LatLng target = new  LatLng (-1.304128, 36.824233);
        /*final long duration = 400;
        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
         final Marker marker=mMap.addMarker(new MarkerOptions().position(new LatLng(-1.302810, 36.825408)).flat(true));
        final Projection proj = mMap.getProjection();

        // Add a marker in nyayostadium and move the camera
        LatLng nyayostadium = new LatLng(-1.302810, 36.825408);
        // LatLng nyayostadium = new LatLng(-18.142, 178.431);
        mMap.addMarker(new MarkerOptions().position(nyayostadium).title("STARTING POINT").flat(true));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nyayostadium, 15));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

        Point startPoint = proj.toScreenLocation(marker.getPosition());
        final LatLng startLatLng = proj.fromScreenLocation(startPoint);

        final Interpolator interpolator = new LinearInterpolator();
        handler.post(new Runnable() {
            @Override
            public void run() {
                long elapsed = SystemClock.uptimeMillis() - start;
                float t = interpolator.getInterpolation((float) elapsed / duration);
                double lng = t * target.longitude + (1 - t) * startLatLng.longitude;
                double lat = t * target.latitude + (1 - t) * startLatLng.latitude;
                marker.setPosition(new LatLng(-1.302810, 36.825408));
                if (t < 1.0) {
                    // Post again 10ms later.
                    handler.postDelayed(this, 10);
                } else {
                    // animation ended
                }
            }
        });*/

        PolylineOptions tenkms= new PolylineOptions()
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

                        //cathedral left turn
                       // new LatLng(-1.293203, 36.816620),
                        new LatLng(-1.293172, 36.816587),
                        new LatLng(-1.293164, 36.816536),
                        new LatLng(-1.293142, 36.816421),
                        //cathedral road
                        new LatLng(-1.293091, 36.816316),
                        new LatLng(-1.293059, 36.816295),
                        new LatLng(-1.293013, 36.816271),
                        new LatLng(-1.292892, 36.816223),
                        new LatLng(-1.292726, 36.816159),
                        new LatLng(-1.292605, 36.816105),
                        new LatLng(-1.292412, 36.815998),
                        new LatLng(-1.292305, 36.815939),
                        new LatLng(-1.292139, 36.815826),
                        new LatLng(-1.292046, 36.815761),
                        new LatLng(-1.291958, 36.815694),
                        new LatLng(-1.291851, 36.815622),
                        new LatLng(-1.291451, 36.815389),
                        new LatLng(-1.291116, 36.815209),
                        new LatLng(-1.290698, 36.815002),
                        new LatLng(-1.290572, 36.814922),
                        new LatLng(-1.290513, 36.814879),
                        new LatLng(-1.290457, 36.814815),
                        new LatLng(-1.290398, 36.814740),
                        new LatLng(-1.290342, 36.814617),
                        new LatLng(-1.290296, 36.814518),
                        new LatLng(-1.290258, 36.814435),
                        new LatLng(-1.290237, 36.814365),
                        new LatLng(-1.290245, 36.814250),
                        //cathedral-ngong road turn left
                        new LatLng(-1.290261, 36.814199),
                        new LatLng(-1.290285, 36.814186),
                        new LatLng(-1.290331, 36.814205),
                        new LatLng(-1.290387, 36.814251),
                        new LatLng(-1.290446, 36.814283),
                        new LatLng(-1.290497, 36.814315),
                        new LatLng(-1.290575, 36.814361),
                        new LatLng(-1.290658, 36.814388),
                        new LatLng(-1.290757, 36.814415),
                        new LatLng(-1.290848, 36.814426),
                        new LatLng(-1.290955, 36.814406),
                        new LatLng(-1.291062, 36.814374),
                        new LatLng(-1.291185, 36.814299),
                        new LatLng(-1.291241, 36.814256),
                        new LatLng(-1.291292, 36.814200),
                        new LatLng(-1.291330, 36.814146),
                        new LatLng(-1.291373, 36.814041),
                        new LatLng(-1.291416, 36.813936),
                        new LatLng(-1.291456, 36.813791),
                        new LatLng(-1.291475, 36.813702),
                        new LatLng(-1.291558, 36.813490),
                        new LatLng(-1.291641, 36.813340),
                        new LatLng(-1.291732, 36.813270),
                        new LatLng(-1.291823, 36.813195),
                        new LatLng(-1.291968, 36.813104),
                        new LatLng(-1.292121, 36.813007),
                        new LatLng(-1.292722, 36.812610),
                        new LatLng(-1.293269, 36.812232),
                        new LatLng(-1.293400, 36.812152),
                        new LatLng(-1.293467, 36.812104),
                        new LatLng(-1.293502, 36.812056),
                        new LatLng(-1.293545, 36.812013),
                        new LatLng(-1.293596, 36.811973),
                        new LatLng(-1.293666, 36.811925),
                        new LatLng(-1.293741, 36.811869),
                        new LatLng(-1.293864, 36.811756),
                        new LatLng(-1.294028, 36.811608),
                        new LatLng(-1.294342, 36.811241),
                        new LatLng(-1.294479, 36.811072),
                        new LatLng(-1.294594, 36.810927),
                        new LatLng(-1.294693, 36.810710),
                        new LatLng(-1.294816, 36.810541),
                        new LatLng(-1.294993, 36.810270),
                        new LatLng(-1.295140, 36.810031),
                        new LatLng(-1.295392, 36.809658),
                        new LatLng(-1.295456, 36.809572),
                        new LatLng(-1.295660, 36.809277),
                        new LatLng(-1.296003, 36.808781),
                        new LatLng(-1.296164, 36.808499),
                        new LatLng(-1.296373, 36.808182),
                        new LatLng(-1.296574, 36.807874),
                        new LatLng(-1.296754, 36.807557),
                        new LatLng(-1.296872, 36.807348),
                        new LatLng(-1.296893, 36.807292),
                        new LatLng(-1.296912, 36.807230),
                        new LatLng(-1.296952, 36.807128),
                        new LatLng(-1.296995, 36.806954),
                        new LatLng(-1.297006, 36.806868),
                        new LatLng(-1.297049, 36.806712),
                        new LatLng(-1.297111, 36.806471),
                        new LatLng(-1.297218, 36.805999),
                        new LatLng(-1.297293, 36.805715),
                        new LatLng(-1.297583, 36.804371),
                        new LatLng(-1.297617, 36.804271),
                        new LatLng(-1.297681, 36.804056),
                        new LatLng(-1.297761, 36.803898),
                        new LatLng(-1.297785, 36.803796),
                        new LatLng(-1.297814, 36.803673),
                        //mbagathi roundabout
                        new LatLng(-1.297896, 36.803462),
                        new LatLng(-1.297943, 36.803359),
                        new LatLng(-1.298050, 36.803281),
                        new LatLng(-1.298216, 36.803174),
                        new LatLng(-1.298329, 36.803088),
                        new LatLng(-1.298401, 36.803050),
                        //MBANGATHI ROAD
                        new LatLng(-1.298425, 36.803047),
                        new LatLng(-1.298776, 36.803068),
                        new LatLng(-1.299444, 36.803162),
                        new LatLng(-1.299538, 36.803166),
                        new LatLng(-1.299669, 36.803171),
                        new LatLng(-1.299857, 36.803158),
                        new LatLng(-1.300227, 36.803072),
                        new LatLng(-1.300291, 36.803053),
                        new LatLng(-1.300342, 36.803032),
                        new LatLng(-1.300436, 36.802978),
                        new LatLng(-1.300573, 36.802906),
                        new LatLng(-1.300892, 36.802699),
                        new LatLng(-1.300970, 36.802648),
                        new LatLng(-1.301050, 36.802610),
                        new LatLng(-1.301106, 36.802575),
                        new LatLng(-1.301205, 36.802521),
                        new LatLng(-1.301334, 36.802454),
                        new LatLng(-1.301401, 36.802427),
                        new LatLng(-1.301530, 36.802376),
                        new LatLng(-1.301616, 36.802360),
                        new LatLng(-1.301699, 36.802355),
                        new LatLng(-1.301785, 36.802360),
                        new LatLng(-1.301823, 36.802360),
                        new LatLng(-1.301866, 36.802360),
                        new LatLng(-1.301912, 36.802363),
                        new LatLng(-1.302014, 36.802384),
                        new LatLng(-1.302116, 36.802408),
                        new LatLng(-1.302465, 36.802494),
                        new LatLng(-1.302588, 36.802532),
                        new LatLng(-1.302947, 36.802629),
                        new LatLng(-1.303515, 36.802779),
                        new LatLng(-1.304105, 36.802913),
                        new LatLng(-1.304488, 36.802999),
                        new LatLng(-1.305140, 36.803136),
                        new LatLng(-1.305805, 36.803292),
                        new LatLng(-1.306052, 36.803379),
                        new LatLng(-1.306406, 36.803500),
                        new LatLng(-1.306481, 36.803535),
                        new LatLng(-1.306685, 36.803632),
                        new LatLng(-1.307060, 36.803782),
                        new LatLng(-1.307435, 36.803959),
                        new LatLng(-1.307617, 36.804042),
                        new LatLng(-1.308277, 36.804375),
                        new LatLng(-1.308856, 36.804681),
                        new LatLng(-1.309845, 36.805156),
                        new LatLng(-1.311113, 36.805798),
                        new LatLng(-1.311714, 36.806117),
                        new LatLng(-1.312728, 36.806659),
                        new LatLng(-1.313085, 36.806857),
                        new LatLng(-1.313300, 36.806996),
                        new LatLng(-1.313665, 36.807275),
                        new LatLng(-1.313909, 36.807490),
                        new LatLng(-1.314188, 36.807753),
                        new LatLng(-1.314475, 36.808161),
                        new LatLng(-1.314606, 36.808443),
                        new LatLng(-1.314657, 36.808612),
                        new LatLng(-1.314695, 36.808856),
                        new LatLng(-1.314722, 36.809242),
                        new LatLng(-1.314682, 36.809693),
                        new LatLng(-1.314620, 36.810095),
                        new LatLng(-1.314505, 36.810403),
                        new LatLng(-1.314309, 36.810945),
                        new LatLng(-1.313794, 36.812203),
                        new LatLng(-1.313231, 36.813716),
                        new LatLng(-1.312697, 36.815159),
                        new LatLng(-1.312544, 36.815585),
                        //T-MALL ROUNDABOUT
                        new LatLng(-1.312480, 36.815683),
                        new LatLng(-1.312459, 36.815707),
                        new LatLng(-1.312438, 36.815737),
                        new LatLng(-1.312417, 36.815838),
                        new LatLng(-1.312379, 36.815948),
                        new LatLng(-1.312341, 36.815995),
                        //langata road
                        new LatLng(-1.312279, 36.816070),
                        new LatLng(-1.312169, 36.816175),
                        new LatLng(-1.311576, 36.816674),
                        new LatLng(-1.310991, 36.817125),
                        new LatLng(-1.310452, 36.817573),
                        new LatLng(-1.309666, 36.818166),
                        new LatLng(-1.309068, 36.818606),
                        new LatLng(-1.308666, 36.818863),
                        new LatLng(-1.308403, 36.818989),
                        new LatLng(-1.307953, 36.819153),
                        new LatLng(-1.307575, 36.819306),
                        new LatLng(-1.307208, 36.819470),
                        ///madaraka roundabout
                        new LatLng(-1.307152, 36.819508),
                        new LatLng(-1.307037, 36.819500),
                        new LatLng(-1.306959, 36.819532),
                        new LatLng(-1.306905, 36.819567),
                        new LatLng(-1.306876, 36.819613),
                        new LatLng(-1.306855, 36.819684),
                        new LatLng(-1.306820, 36.819722),
                        new LatLng(-1.306726, 36.819840),
                        new LatLng(-1.306659, 36.819931),
                        new LatLng(-1.306568, 36.820070),
                        new LatLng(-1.306412, 36.820293),
                        new LatLng(-1.306235, 36.820532),
                        //aedrome road and entrancce to nyayostadium
                        new LatLng(-1.306037, 36.820749),
                        new LatLng(-1.305809, 36.821092),
                        new LatLng(-1.305594, 36.821441),
                        new LatLng(-1.305211, 36.822203),
                        new LatLng(-1.305053, 36.822463),
                        new LatLng(-1.304900, 36.822670),
                        new LatLng(-1.304777, 36.822812),
                        new LatLng(-1.305099, 36.823134),

                        new LatLng(-1.305002, 36.824137),
                        //nyayo stadium arena

                        new LatLng(-1.304846, 36.824378),
                        new LatLng(-1.304916, 36.824228),
                        new LatLng(-1.304849, 36.824317),
                        new LatLng(-1.304828, 36.824377),
                        new LatLng(-1.304868, 36.824417),
                        new LatLng(-1.304903, 36.824484),
                        new LatLng(-1.304924, 36.824548),
                        new LatLng(-1.304945, 36.824647),
                        new LatLng(-1.304883, 36.824872),
                        new LatLng(-1.304840, 36.824928),
                        new LatLng(-1.304794, 36.824963),
                        new LatLng(-1.304730, 36.825017),
                        new LatLng(-1.304636, 36.825055),
                        new LatLng(-1.304539, 36.825079),
                        new LatLng(-1.304418, 36.825079),
                        new LatLng(-1.303839, 36.825074),
                        new LatLng(-1.303708, 36.825074),
                        new LatLng(-1.303593, 36.825058),
                        new LatLng(-1.303550, 36.825037),
                        new LatLng(-1.303499, 36.825013),
                        new LatLng(-1.303443, 36.824981),
                        new LatLng(-1.303408, 36.824949),
                        new LatLng(-1.303373, 36.824917),
                        new LatLng(-1.303338, 36.824879),
                        new LatLng(-1.303335, 36.824801),
                        new LatLng(-1.303308, 36.824702),
                        new LatLng(-1.303321, 36.824616),
                        new LatLng(-1.303342, 36.824536),
                        new LatLng(-1.303390, 36.824472),
                        new LatLng(-1.303444, 36.824402),
                        new LatLng(-1.303484, 36.824364),
                        new LatLng(-1.303554, 36.824324),
                        new LatLng(-1.303616, 36.824316),
                        new LatLng(-1.303715, 36.824305),
                        new LatLng(-1.303715, 36.824305),
                        new LatLng(-1.304122, 36.824279),
                        new LatLng(-1.304128, 36.824233)


                ).width(12).color(Color.BLUE);

        Polyline halfmarathon=mMap.addPolyline(tenkms);

    }

    public void animateMarker(final Marker marker, final LatLng toPosition,final boolean hideMarker) {
        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        Projection proj = mMap.getProjection();
        Point startPoint = proj.toScreenLocation(marker.getPosition());
        final LatLng startLatLng = proj.fromScreenLocation(startPoint);
        final long duration = 500;

        final Interpolator interpolator = new LinearInterpolator();

        handler.post(new Runnable() {
            @Override
            public void run() {
                long elapsed = SystemClock.uptimeMillis() - start;
                float t = interpolator.getInterpolation((float) elapsed
                        / duration);
                double lng = t * toPosition.longitude + (1 - t)
                        * startLatLng.longitude;
                double lat = t * toPosition.latitude + (1 - t)
                        * startLatLng.latitude;
                marker.setPosition(new LatLng(-1.302810, 36.825408));

                if (t < 1.0) {
                    // Post again 16ms later.
                    handler.postDelayed(this, 16);
                } else {
                    if (hideMarker) {
                        marker.setVisible(false);
                    } else {
                        marker.setVisible(true);
                    }
                }
            }
        });
    }
}
