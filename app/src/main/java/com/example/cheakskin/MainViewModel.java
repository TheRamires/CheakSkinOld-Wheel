package com.example.cheakskin;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public ObservableField<Boolean> barVisibility=new ObservableField<>(true);
}
