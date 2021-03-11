package com.example.cheakskin.ui.fooddiary.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cheakskin.Loger;
import com.example.cheakskin.ui.fooddiary.adapters.RecyclerAdapter_food;
import com.example.cheakskin.ui.fooddiary.data.Compliance_Table;
import com.example.cheakskin.ui.fooddiary.data.EntityFoodPosition;
import com.example.cheakskin.ui.fooddiary.data.EntityToMeal;
import com.example.cheakskin.ui.fooddiary.data.FoodRepositoriy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class FoodDiaryViewModel extends ViewModel {
    private FoodRepositoriy repo=new FoodRepositoriy();
    public MutableLiveData<String> dateLive=new MutableLiveData<>();
    public MutableLiveData<List<EntityFoodPosition>> foodLive=new MutableLiveData<>();

    public void getCurrentDate(){
        // Текущее время
        Date currentDate = new Date();
// Форматирование времени как "день.месяц.год"
        DateFormat dateFormat = new SimpleDateFormat("EEEE, dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);
        dateLive.setValue(dateText);
    }
    public void refreshFoodList(String date, String timeOfMeal){
        repo.getFoodPOsitions(date, timeOfMeal)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((@io.reactivex.annotations.NonNull List<EntityFoodPosition> list)-> {
                        foodLive.setValue(list);

                        for (EntityFoodPosition entity: list) {
                            Loger.log(entity.getName()+" "+entity.getWeight());
                        }
                });
    }
}