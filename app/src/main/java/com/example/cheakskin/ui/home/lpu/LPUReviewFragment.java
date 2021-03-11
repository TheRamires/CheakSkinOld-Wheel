package com.example.cheakskin.ui.home.lpu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentLPUReviewBinding;

public class LPUReviewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentLPUReviewBinding binding=FragmentLPUReviewBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();

        return view;
    }
    public void backstack(View view){
        Navigation.findNavController(view).popBackStack();
    }
}