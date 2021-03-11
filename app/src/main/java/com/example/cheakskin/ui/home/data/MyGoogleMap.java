package com.example.cheakskin.ui.home.data;

import com.example.cheakskin.Loger;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MyGoogleMap  {
    private GoogleMap mMap;

    public void googlemapsInit(GoogleMap mMap) {
        init(mMap);
        toMap(mMap);
    }

    private void init(GoogleMap mMap) {
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng) {
                Loger.log("lat "+latLng.latitude + ", lon " + latLng.longitude);
            }
        });

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {

            @Override
            public void onMapLongClick(LatLng latLng) {
                Loger.log("lat "+latLng.latitude + ", lon" + latLng.longitude);
            }
        });

        mMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {

            @Override
            public void onCameraChange(CameraPosition camera) {
                Loger.log("onCameraChange: " + camera.target.latitude + "," + camera.target.longitude);
            }
        });
    }

    private void toMap(GoogleMap mMap) {  //ex button
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL  );
        if (mMap!=null) {
            Loger.log(mMap.toString());
        }else Loger.log("mp is null");
        //init();
/*
        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setMyLocationButtonEnabled(false);
        uiSettings.setCompassEnabled(true);
        uiSettings.setAllGesturesEnabled(true);
        uiSettings.setZoomControlsEnabled(false);
 */

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(45.03686300387497,38.97431217133999))
                .zoom(18)
                // .bearing(45)
                .tilt(20)
                .build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        mMap.animateCamera(cameraUpdate);

        //Задать позиции точек ---------------------------------------------------
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(45.03686300387497,38.97431217133999))
                .anchor(0.5f,1)
                .flat(true)
                .title("Рис Красная"));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(45.06272398515516,38.961551897227764))
                .anchor(0.5f,1)
                .flat(true)
                .title("Рис ФМР"));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(45.030886534863406,38.910713978111744))
                .anchor(0.5f,1)
                .flat(true)
                .title("Рис ЮМР"));
    }

}
