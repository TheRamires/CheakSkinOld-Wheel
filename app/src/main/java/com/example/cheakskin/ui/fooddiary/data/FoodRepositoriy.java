package com.example.cheakskin.ui.fooddiary.data;

import com.example.cheakskin.App;
import com.example.cheakskin.Loger;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class FoodRepositoriy {
    private AppDatabase db= App.getInstance().getDatabase();
    public DaoFood daoFood=db.daoFood();

    public Single<Long> savePosition(EntityToMeal entityToMeal, EntityFoodPosition foodPosition){
        return Single
                .zip(daoFood.saveToMeal(entityToMeal),
                        daoFood.saveFoodPosition(foodPosition),

                        (Long idFood, Long idToMeal)-> {
                    Loger.log("position is saved idFood="+idFood+ " ,idToMeal = "+idToMeal);
                            Long result =
                                    daoFood.saveCompliance_Table(
                                    new Compliance_Table(idFood,idToMeal));

                            return result;
                        })
                .subscribeOn(Schedulers.io());

    }
    public Maybe<List<EntityFoodPosition>> getFoodPOsitions(String date, String timeOfMeal){
        return daoFood.loadFoodPositions(date, timeOfMeal)
                .subscribeOn(Schedulers.io());
    }
}
