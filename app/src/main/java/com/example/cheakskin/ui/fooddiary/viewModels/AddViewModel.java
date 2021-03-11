package com.example.cheakskin.ui.fooddiary.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cheakskin.ui.fooddiary.data.EntityFoodPosition;
import com.example.cheakskin.ui.fooddiary.data.EntityToMeal;
import com.example.cheakskin.ui.fooddiary.data.FoodRepositoriy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;

public class AddViewModel extends ViewModel {
    public String name="";
    public String weight="";
    public String date="";
    public String timeOfMeal="";
    private FoodRepositoriy repo=new FoodRepositoriy();
    public MutableLiveData<List<EntityFoodPosition>> foodList=new MutableLiveData<>();

    public Single<Boolean> addposition(){
        EntityToMeal toMeal=new EntityToMeal(date, timeOfMeal);
        EntityFoodPosition foodPosition=new EntityFoodPosition(name, weight);

        return repo.savePosition(toMeal, foodPosition)
                .map((@NonNull Long id)-> {
                    if (id!=null || id==0){
                        //to clear fields
                        name="";
                        weight="";
                        return true;
                    }else return false;
                })
                .observeOn(AndroidSchedulers.mainThread());
    }

    public boolean validatePos(){
        if (!name.equals("")& !weight.equals("")& !date.equals("")& !timeOfMeal.equals("")){
            return true;
        }else return false;
    }
}
