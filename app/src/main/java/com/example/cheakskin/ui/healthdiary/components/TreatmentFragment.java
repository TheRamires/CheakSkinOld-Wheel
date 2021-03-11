package com.example.cheakskin.ui.healthdiary.components;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentTreatmentBinding;

public class TreatmentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTreatmentBinding binding=FragmentTreatmentBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();

        return view;
    }
    public void backStack (View view){
        Navigation.findNavController(view).popBackStack();
    }
    public void toTreatmentRedact (View view){
        Navigation.findNavController(view).navigate(R.id.action_treatmentFragment_to_treatmentRedactFragment);
    }
}