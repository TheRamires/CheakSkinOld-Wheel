package com.example.cheakskin.ui.healthdiary.components;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.swipe.util.Attributes;
import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentRemindersBinding;
import com.example.cheakskin.ui.healthdiary.adapters.SwipeRecyclerViewAdapter;
import com.example.cheakskin.ui.healthdiary.data.EntityReminders;

import java.util.ArrayList;

public class RemindersFragment extends Fragment {

    private TextView tvEmptyTextView;
    private RecyclerView mRecyclerView;
    private ArrayList<EntityReminders> mDataSet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentRemindersBinding binding=FragmentRemindersBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();

        tvEmptyTextView = binding.emptyView;
        mRecyclerView = binding.myRecyclerView;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mDataSet = new ArrayList<EntityReminders>();

        loadData();

        if(mDataSet.isEmpty()){
            mRecyclerView.setVisibility(View.GONE);
            tvEmptyTextView.setVisibility(View.VISIBLE);
        }else{
            mRecyclerView.setVisibility(View.VISIBLE);
            tvEmptyTextView.setVisibility(View.GONE);
        }

        SwipeRecyclerViewAdapter mAdapter = new SwipeRecyclerViewAdapter(getActivity(), mDataSet);
        mAdapter.notifyDataSetChanged();

        ((SwipeRecyclerViewAdapter) mAdapter).setMode(Attributes.Mode.Single);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("RecyclerView", "onScrollStateChanged");
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        return view;
    }
    //for example -----------------------------------------------------------------------------
    public void loadData() {
        for (int i = 0; i <= 20; i++) {
            mDataSet.add(new EntityReminders("Парацетамол"+i,"выпить"+i, "12:00"));
        }
    }
    //------------------------------------------------------------------------------------------
    public void backStack(View view){
        Navigation.findNavController(view).popBackStack();
    }
    public void add (View view){Navigation.findNavController(view).
            navigate(R.id.action_remindersFragment3_to_remindersAddFragment);}
}