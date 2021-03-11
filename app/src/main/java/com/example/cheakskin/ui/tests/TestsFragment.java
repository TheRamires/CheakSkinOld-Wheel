package com.example.cheakskin.ui.tests;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.cheakskin.Loger;
import com.example.cheakskin.R;
import com.example.cheakskin.databinding.TestsFragmentBinding;

public class TestsFragment extends Fragment {
    private AppCompatActivity activity;

    private TestsViewModel mViewModel;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.button:
                Loger.log("button is clicked");
            default:
                break;
        }
        return true;
    }

    public static TestsFragment newInstance() {
        return new TestsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        TestsFragmentBinding binding=TestsFragmentBinding.inflate(inflater);
        View view=binding.getRoot();
        mViewModel = new ViewModelProvider(this).get(TestsViewModel.class);
        Toolbar toolbar=binding.tToolbar;
        setHasOptionsMenu(true);
        activity=((AppCompatActivity)getActivity());

        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Test");
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.profile);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Loger.log("profile");
            }
        });
        return view;
    }

}