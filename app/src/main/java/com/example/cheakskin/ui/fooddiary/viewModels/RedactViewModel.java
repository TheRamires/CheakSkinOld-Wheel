package com.example.cheakskin.ui.fooddiary.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cheakskin.Loger;
import com.example.cheakskin.ui.fooddiary.data.EntityFoodPosition;
import com.example.cheakskin.ui.fooddiary.data.FoodRepositoriy;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class RedactViewModel extends ViewModel {
    public String date="";
    public String timeOfMeal="";
    private FoodRepositoriy repo=new FoodRepositoriy();
    public MutableLiveData<List<EntityFoodPosition>> entityList=new MutableLiveData<>();

    public void getEntityList(){
        Loger.log("date "+date+" timeOfMeal "+timeOfMeal);
        repo.getFoodPOsitions(date,timeOfMeal)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((@NonNull List<EntityFoodPosition> list)-> {
                        entityList.setValue(list);

                });
    }
}
