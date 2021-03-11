package com.example.cheakskin.ui.home.lpu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cheakskin.MainViewModel;
import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentLPUConteinerBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class LPUConteinerFrag extends Fragment {
    private final String [] titleList= {"Список", "На карте"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainViewModel mainViewModel=new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        //---------------------------------Прячем бар
        mainViewModel.barVisibility.set(false);
        FragmentLPUConteinerBinding binding=FragmentLPUConteinerBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();

        TabLayout tabLayout=binding.tabs;
        ViewPager2 viewPager=binding.pager;
        FragmentStateAdapter adapter=new PagerAdapter(requireActivity());
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titleList[position]);
            }
        }).attach();
        // Inflate the layout for this fragment
        return view;
    }
    public void backstack (View view){
        Navigation.findNavController(view).popBackStack();
    }
}