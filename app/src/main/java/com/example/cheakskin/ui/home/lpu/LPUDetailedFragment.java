package com.example.cheakskin.ui.home.lpu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentLPUDetailedBinding;
import com.example.cheakskin.ui.home.adapters.RecyclerAdapter_review;
import com.example.cheakskin.ui.home.data.ReviewEntity;
import com.example.cheakskin.ui.home.viewmodels.HomeViewModel;
import com.example.cheakskin.ui.home.viewmodels.MapViewModel;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.List;

public class LPUDetailedFragment extends Fragment implements OnMapReadyCallback {
    GoogleMap mMap;
    MutableLiveData<SupportMapFragment> initMapTrue=new MutableLiveData<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentLPUDetailedBinding binding=FragmentLPUDetailedBinding.inflate(inflater);
        MapViewModel mapViewModel=new ViewModelProvider(requireActivity()).get(MapViewModel.class);
        HomeViewModel homeViewModel=new ViewModelProvider(requireActivity()).get(HomeViewModel.class);

        binding.setFragment(this);
        View view=binding.getRoot();
        int idPosition=getArguments().getInt("id");

        homeViewModel.getReviews();

        RecyclerView recyclerView=binding.recyclerReviews;
        homeViewModel.reviewsLive.observe(getViewLifecycleOwner(), new Observer<List<ReviewEntity>>() {
            @Override
            public void onChanged(List<ReviewEntity> reviews) {
                RecyclerView.Adapter adapter=new RecyclerAdapter_review(reviews);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
                recyclerView.setHasFixedSize(false);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }
        });
        initializeMap(this);
        initMapTrue.observe(getViewLifecycleOwner(), new Observer<SupportMapFragment>() {
            @Override
            public void onChanged(SupportMapFragment supportMapFragment) {
                mapViewModel.mapInit(mMap);
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
    public void toReview(View view){
        Navigation.findNavController(view).navigate(R.id.LPUReviewFragment);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }
    public void backstack (View view){
        Navigation.findNavController(view).popBackStack();
    }
}