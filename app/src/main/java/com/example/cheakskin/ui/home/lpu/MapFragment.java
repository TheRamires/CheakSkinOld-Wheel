package com.example.cheakskin.ui.home.lpu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentMapBinding;
import com.example.cheakskin.ui.home.viewmodels.MapViewModel;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    GoogleMap mMap;
    MutableLiveData<SupportMapFragment> initMapTrue=new MutableLiveData<>();

    @Override
    public void onResume() {
        super.onResume();
        ViewPager2 viewPager=requireActivity().findViewById(R.id.pager);
        viewPager.setUserInputEnabled(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMapBinding binding=FragmentMapBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();

        MapViewModel viewModel=new ViewModelProvider(this).get(MapViewModel.class);

        initializeMap(this);
        initMapTrue.observe(getViewLifecycleOwner(), new Observer<SupportMapFragment>() {
            @Override
            public void onChanged(SupportMapFragment supportMapFragment) {
                viewModel.mapInit(mMap);
            }
        });

        return view;
    }
    private void initializeMap(OnMapReadyCallback onMapReadyCallback) {
        if (mMap == null) {
            SupportMapFragment mapFrag = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
            mapFrag.getMapAsync(onMapReadyCallback);
            initMapTrue.postValue(mapFrag);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }
}