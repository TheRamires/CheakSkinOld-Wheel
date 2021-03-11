package com.example.cheakskin;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.example.cheakskin.databinding.ActivityMainBinding;
import com.example.cheakskin.databinding.FragmentFoodDiaryBinding;
import com.example.cheakskin.ui.fooddiary.viewModels.FoodDiaryViewModel;
import com.example.cheakskin.ui.healthdiary.HealthDiaryViewModel;
import com.example.cheakskin.ui.home.viewmodels.MapViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        Locale locale = getResources().getConfiguration().locale;
        locale.setDefault(new Locale("ru","RU"));

        //View Models --------------------------------------------------------------------------
        MainViewModel mainViewModel=new ViewModelProvider(this).get(MainViewModel.class);
        binding.setViewModel(mainViewModel);
        FoodDiaryViewModel foodDiaryViewModel =
                new ViewModelProvider(this).get(FoodDiaryViewModel.class);
        HealthDiaryViewModel healthDiaryViewModel
                =new ViewModelProvider(this).get(HealthDiaryViewModel.class);
        foodDiaryViewModel.getCurrentDate();
        healthDiaryViewModel.getCurrentDate();


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_food_diary, R.id.navigation_health_diary,
                R.id.navigation_news, R.id.navigation_tests)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);
    }
}