package com.example.cheakskin.ui.healthdiary.components;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentAffectedAreasBinding;
import com.example.cheakskin.ui.healthdiary.adapters.RecyclerAdapterAffecteds;
import com.example.cheakskin.ui.healthdiary.data.EntityAffected;
import com.example.cheakskin.ui.healthdiary.viewModels.AffectedAreaViewModel;

import java.util.List;

public class AffectedAreasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentAffectedAreasBinding binding=FragmentAffectedAreasBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        AffectedAreaViewModel viewModel=new ViewModelProvider(requireActivity()).get(AffectedAreaViewModel.class);
        viewModel.getAffectedLists();

        RecyclerView recyclerView1=binding.recycler1;
        RecyclerView recyclerView2=binding.recycler2;
        viewModel.affectedLive1.observe(getViewLifecycleOwner(),(List<EntityAffected> list)-> {
            RecyclerView.Adapter adapter=new RecyclerAdapterAffecteds(list);
            adapter.notifyDataSetChanged();
            recyclerView1.setAdapter(adapter);
            recyclerView1.setHasFixedSize(false);
        });
        viewModel.affectedLive2.observe(getViewLifecycleOwner(),(List<EntityAffected> list2)-> {
            RecyclerView.Adapter adapter2=new RecyclerAdapterAffecteds(list2);
            adapter2.notifyDataSetChanged();
            recyclerView2.setAdapter(adapter2);
            recyclerView2.setHasFixedSize(false);
        });
        return view;
    }
    public void backStack(View view){
        Navigation.findNavController(view).popBackStack();
    }
    public void toRedact(View view){
        Navigation.findNavController(view).navigate(R.id.action_affectedAreasFragment_to_affectedRedactFragment);
    }
}