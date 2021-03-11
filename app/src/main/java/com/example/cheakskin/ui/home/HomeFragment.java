package com.example.cheakskin.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.cheakskin.MainViewModel;
import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentHomeBinding;
import com.example.cheakskin.ui.home.viewmodels.HomeViewModel;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MainViewModel mainViewModel=new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        //--------------------------снова показываем бар
        mainViewModel.barVisibility.set(true);
        FragmentHomeBinding binding=FragmentHomeBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        HomeViewModel viewModel=new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        viewModel.getLPUList();

        return view;
    }
    //------------------------------------------------------------------------------------

    public void toLPUDoc (View view){
        Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_LPUDocumentsFrag);
    }
    public void toLPU(View view){
        Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_LPUConteinerFrag);
    }
}