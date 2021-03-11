package com.example.cheakskin.ui.home.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.cheakskin.ui.home.data.MyGoogleMap;
import com.google.android.gms.maps.GoogleMap;

public class MapViewModel extends AndroidViewModel {
    MyGoogleMap myGoogleMap=new MyGoogleMap();

    public MapViewModel(@NonNull Application application) {
        super(application);
    }
    public void mapInit(GoogleMap mMap){
        myGoogleMap.googlemapsInit(mMap);
    }
}
