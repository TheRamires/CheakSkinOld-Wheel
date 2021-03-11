package com.example.cheakskin.ui.healthdiary.components;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentBodyBinding;

public class Body extends Fragment {
    FragmentBodyBinding binding;
    Drawable drawableFront;
    Drawable drawableBack;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentBodyBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();

        drawableFront=getResources().getDrawable(R.drawable.body2);
        drawableBack=getResources().getDrawable(R.drawable.body1);

        return view;
    }
    public void rotate (View view){
        Boolean isBack=binding.getIsBack();
        if (isBack==null || !isBack){
            binding.setIsBack(true);
        }
        else{
            binding.setIsBack(false);
        }
        /*
        if (binding.image.getDrawable()==drawableFront) {
            binding.image.setImageResource(R.drawable.body1);
            //binding.image.setBackground(drawableBack);
        }else binding.image.setImageResource(R.drawable.body2);
        */
    }
}