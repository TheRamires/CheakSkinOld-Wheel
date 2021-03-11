package com.example.cheakskin.ui.healthdiary.components;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentAffectedRedactBinding;
import com.example.cheakskin.ui.healthdiary.adapters.RecyclerAdapterAffecteds;
import com.example.cheakskin.ui.healthdiary.data.EntityAffected;
import com.example.cheakskin.ui.healthdiary.viewModels.AffectedAreaViewModel;

import java.util.List;

public class AffectedRedactFragment extends Fragment{
    private FragmentAffectedRedactBinding binding;
    private Button lastClickedButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentAffectedRedactBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        AffectedAreaViewModel viewModel=new ViewModelProvider(requireActivity()).get(AffectedAreaViewModel.class);
        viewModel.getAffectedLists();

        RecyclerView recyclerView1=binding.recycler1;
        RecyclerView recyclerView2=binding.recycler2;
        viewModel.affectedLive1.observe(getViewLifecycleOwner(),(List<EntityAffected> list)-> {
            RecyclerView.Adapter adapter=new RecyclerAdapterAffecteds(list, viewModel,true);
            adapter.notifyDataSetChanged();
            recyclerView1.setAdapter(adapter);
            recyclerView1.setHasFixedSize(false);
        });
        viewModel.affectedLive2.observe(getViewLifecycleOwner(),(List<EntityAffected> list2)-> {
            RecyclerView.Adapter adapter2=new RecyclerAdapterAffecteds(list2,viewModel,true);
            adapter2.notifyDataSetChanged();
            recyclerView2.setAdapter(adapter2);
            recyclerView2.setHasFixedSize(false);
        });

        return view;
    }
    public void backStack (View view){
        Navigation.findNavController(view).popBackStack();
    }
    public void clickListener (View view){
        if (lastClickedButton==null){
            lastClickedButton= (Button) view;
            //lastClickedButton.setBackgroundColor(getResources().getColor(R.color.teal_700));
            lastClickedButton.setBackground(getResources().getDrawable(R.drawable.button_on));
            lastClickedButton.setTextColor(Color.WHITE);
        }
        else if (lastClickedButton!=view & lastClickedButton!=null){
            Button button= (Button) view;

            //button.setBackgroundColor(getResources().getColor(R.color.teal_700));
            button.setBackground(getResources().getDrawable(R.drawable.button_on));
            button.setTextColor(Color.WHITE);

            lastClickedButton.setBackground(getResources().getDrawable(R.drawable.button_off));
            lastClickedButton.setTextColor(getResources().getColor(R.color.teal_700));

            lastClickedButton = button;
        } else if(lastClickedButton==view){
            lastClickedButton.setBackground(getResources().getDrawable(R.drawable.button_off));
            lastClickedButton.setTextColor(getResources().getColor(R.color.teal_700));
        }
    }
}