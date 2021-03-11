package com.example.cheakskin.ui.home.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cheakskin.R;
import com.example.cheakskin.databinding.ItemLpuBinding;
import com.example.cheakskin.ui.home.data.LPU;

import java.util.List;

public class RecyclerAdapter_lpu extends RecyclerView.Adapter<RecyclerAdapter_lpu.ItemList> {
    private List<LPU> list;
    private Boolean crosVisible=false;

    public RecyclerAdapter_lpu(List<LPU> list){
        this.list=list;
    }

    @NonNull
    @Override
    public ItemList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItemLpuBinding binding=ItemLpuBinding.inflate(inflater,parent,false);
        return new ItemList(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ItemList holder, int position) {
        holder.binding.setEntity(list.get(position));
        Bundle bundle=new Bundle();
        bundle.putInt("id",list.get(position).getId());
        holder.itemView.setOnClickListener((View v)->{
            Navigation.findNavController(v).navigate(R.id.LPUDetailedFragment,bundle);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemList extends RecyclerView.ViewHolder{
        ItemLpuBinding binding;

        public ItemList(@NonNull View itemView) {
            super(itemView);
            binding= DataBindingUtil.bind(itemView);
        }
    }
}
