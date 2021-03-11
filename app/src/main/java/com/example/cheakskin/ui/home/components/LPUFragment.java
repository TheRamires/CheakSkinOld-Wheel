package com.example.cheakskin.ui.home.components;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentLpuBinding;
import com.example.cheakskin.ui.home.data.LPU;
import com.example.cheakskin.ui.home.viewmodels.HomeViewModel;

import java.util.List;

public class LPUFragment extends Fragment {
    private FragmentLpuBinding binding;
    private Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentLpuBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        bundle=new Bundle();
        HomeViewModel viewModel=new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        viewModel.lpuLive.observe(getViewLifecycleOwner(), new Observer<List<LPU>>() {
            @Override
            public void onChanged(List<LPU> lpus) {
                LPU entity=lpus.get(0);
                binding.setEntity(entity);
                bundle.putInt("id",entity.getId());
            }
        });

        return view;
    }
    public void toDetail(View view){

        Navigation.findNavController(view).navigate(R.id.LPUDetailedFragment,bundle);
    }
}