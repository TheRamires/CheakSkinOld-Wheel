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
import com.example.cheakskin.databinding.ItemReviewBinding;
import com.example.cheakskin.ui.home.data.ReviewEntity;

import java.util.List;

public class RecyclerAdapter_review extends RecyclerView.Adapter<RecyclerAdapter_review.ItemList> {
    private List<ReviewEntity> list;
    private Boolean crosVisible=false;

    public RecyclerAdapter_review(List<ReviewEntity> list){
        this.list=list;
    }

    @NonNull
    @Override
    public ItemList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItemReviewBinding binding=ItemReviewBinding.inflate(inflater,parent,false);
        return new RecyclerAdapter_review.ItemList(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ItemList holder, int position) {
        holder.binding.name.setText(list.get(position).getName());
        holder.binding.description.setText(list.get(position).getText());
        holder.binding.date.setText(list.get(position).getDate());
        holder.binding.rating.setText(String.valueOf( list.get(position).getPoint()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemList extends RecyclerView.ViewHolder{
        ItemReviewBinding binding;

        public ItemList(@NonNull View itemView) {
            super(itemView);
            binding= DataBindingUtil.bind(itemView);
        }
    }
}