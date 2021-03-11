package com.example.cheakskin.ui.fooddiary.components;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentSearchFoodBinding;

public class SearchFoodFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSearchFoodBinding binding=FragmentSearchFoodBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();

        return view;
    }
    public void backStack( View view){
        Navigation.findNavController(view).popBackStack();
    }
}