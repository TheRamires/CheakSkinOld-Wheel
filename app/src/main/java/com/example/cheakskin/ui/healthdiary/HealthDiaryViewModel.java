package com.example.cheakskin.ui.healthdiary;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HealthDiaryViewModel extends ViewModel {
    public MutableLiveData<String> dateLive=new MutableLiveData<>();


    public void getCurrentDate(){
        // Текущее время
        Date currentDate = new Date();
// Форматирование времени как "день.месяц.год"
        DateFormat dateFormat = new SimpleDateFormat("EEEE, dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);
        dateLive.setValue(dateText);
    }

}