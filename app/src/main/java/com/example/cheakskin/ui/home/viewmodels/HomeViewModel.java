package com.example.cheakskin.ui.home.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cheakskin.ui.home.data.HomeRepositoriy;
import com.example.cheakskin.ui.home.data.LPU;
import com.example.cheakskin.ui.home.data.ReviewEntity;

import java.util.List;

import io.reactivex.functions.Consumer;

public class HomeViewModel extends ViewModel {
    private HomeRepositoriy repo=new HomeRepositoriy();
    public MutableLiveData<List<LPU>> lpuLive=new MutableLiveData<>();
    public MutableLiveData<List<ReviewEntity>> reviewsLive=new MutableLiveData<>();

    public void getLPUList(){
        repo.getLPU().subscribe((List<LPU> lpus)-> {
            lpuLive.setValue(lpus);
        });
    }
    public void getReviews(){
        repo.getReviews().subscribe(new Consumer<List<ReviewEntity>>() {
            @Override
            public void accept(List<ReviewEntity> reviewEntities) throws Exception {
                reviewsLive.setValue(reviewEntities);
            }
        });
    }
}