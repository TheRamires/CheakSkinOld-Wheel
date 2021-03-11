package com.example.cheakskin.ui.healthdiary.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cheakskin.Loger;
import com.example.cheakskin.databinding.ItemCardBodyBinding;
import com.example.cheakskin.ui.healthdiary.data.EntityAffected;
import com.example.cheakskin.ui.healthdiary.viewModels.AffectedAreaViewModel;

import java.util.List;

public class RecyclerAdapterAffecteds extends RecyclerView.Adapter<RecyclerAdapterAffecteds.Item> {
    private List<EntityAffected> list;
    private AffectedAreaViewModel viewModel;
    private boolean isDeleted=false;

    public RecyclerAdapterAffecteds(List<EntityAffected> list){
        this.list=list;
    }
    public RecyclerAdapterAffecteds(List<EntityAffected> list,AffectedAreaViewModel viewModel, boolean isDeleted ){
        this.list=list;
        this.viewModel=viewModel;
        this.isDeleted=isDeleted;
    }

    @NonNull
    @Override
    public Item onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItemCardBodyBinding binding=ItemCardBodyBinding.inflate(inflater,parent,false);
        return new Item(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull Item holder, int position) {
        holder.binding.setIsDeleted(isDeleted);
        holder.binding.setEntity(list.get(position));
        /*holder.itemView.setOnClickListener((View v)-> {
                Loger.log("onClick");
                viewModel.deletePosition(list.get(position).getId());
        });*/
        ImageButton button=holder.binding.button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.deletePosition(list.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Item extends RecyclerView.ViewHolder{
        ItemCardBodyBinding binding;

        public Item(@NonNull View itemView) {
            super(itemView);
            binding= DataBindingUtil.bind(itemView);
        }
    }
}