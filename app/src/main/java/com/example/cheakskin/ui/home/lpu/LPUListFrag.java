package com.example.cheakskin.ui.home.lpu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentLPUListBinding;
import com.example.cheakskin.ui.home.adapters.RecyclerAdapter_lpu;
import com.example.cheakskin.ui.home.data.LPU;
import com.example.cheakskin.ui.home.viewmodels.HomeViewModel;

import java.util.List;

public class LPUListFrag extends Fragment {
    @Override
    public void onResume() {
        super.onResume();
        ViewPager2 viewPager=requireActivity().findViewById(R.id.pager);
        viewPager.setUserInputEnabled(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        FragmentLPUListBinding binding=FragmentLPUListBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        HomeViewModel viewModel=new ViewModelProvider(requireActivity()).get(HomeViewModel.class);

        RecyclerView recyclerView=binding.recycler;

        viewModel.lpuLive.observe(getViewLifecycleOwner(), new Observer<List<LPU>>() {
            @Override
            public void onChanged(List<LPU> lpus) {
                RecyclerView.Adapter adapter=new RecyclerAdapter_lpu(lpus);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });

        return view;
    }
}