package com.example.cheakskin.ui.fooddiary;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cheakskin.Loger;
import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentFoodDiaryBinding;
import com.example.cheakskin.ui.fooddiary.adapters.RecyclerAdapter_food;
import com.example.cheakskin.ui.fooddiary.data.EntityFoodPosition;
import com.example.cheakskin.ui.fooddiary.viewModels.FoodDiaryViewModel;
import com.example.cheakskin.ui.home.adapters.RecyclerAdapter_lpu;
import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.cheakskin.ui.fooddiary.Util.TIME_OF_MEALS;

public class FoodDiaryFragment extends Fragment {
    private int rawPosition=0;
    private DialogFragment dialogfragment;
    private WheelView wheelView;
    private ArrayList<Drawable> drawablesList;
    private FoodDiaryViewModel viewModel;
    private RecyclerView recyclerView;
    private MutableLiveData<Integer> rawPositionLive=new MutableLiveData<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Loger.log("• onCreateView");
        viewModel = new ViewModelProvider(requireActivity()).get(FoodDiaryViewModel.class);
        FragmentFoodDiaryBinding binding=FragmentFoodDiaryBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        recyclerView=binding.recycler;
        wheelView=binding.wheelView;

        dialogfragment = new DatePickerTheme(viewModel.dateLive);

        Drawable drawableFood=getResources().getDrawable(R.drawable.food);
        drawablesList = new ArrayList<>();
        Drawable drawable1=new MyDrawable(drawableFood, "Завтрак");

        drawablesList.add(new MyDrawable(drawableFood, "Завтрак")); //завтрак
        drawablesList.add(new MyDrawable(drawableFood, "Перекус")); //перекус
        drawablesList.add(new MyDrawable(drawableFood, "Обед")); //обед
        drawablesList.add(new MyDrawable(drawableFood, "Ужин")); //ужин
        wheelView.setAdapter(new WheelAdapter() {

            @Override
            public Drawable getDrawable(int position) {
                return drawablesList.get(position);
            }

            @Override
            public int getCount() {
                return drawablesList.size();
            }

        });
        wheelView.setOnWheelItemSelectedListener((WheelView parent, Drawable itemDrawable, int position)-> {
            rawPositionLive.setValue(position);
        });

        wheelView.setOnWheelItemClickListener((WheelView parent, int position, boolean isSelected)-> {
            Bundle bundle=new Bundle();
            bundle.putInt("position", position);
            bundle.putString("date",viewModel.dateLive.getValue());
            bundle.putString("timeOfMeal",TIME_OF_MEALS[rawPosition]);
            Navigation.findNavController(view).navigate(R.id.redactFoodFragment, bundle);

        });
        rawPositionLive.observe(getViewLifecycleOwner(), (Integer raw)-> {
            rawPosition=raw;
            String date=viewModel.dateLive.getValue();
            String timeOfMeals=TIME_OF_MEALS[rawPosition];
            Loger.log("rawPositionLive date: "+date+", timeOfMeals: "+timeOfMeals);
            binding.timeOfMeal.setText(timeOfMeals);
            viewModel.refreshFoodList(date, timeOfMeals);
        });

        wheelView.setSelected(rawPosition);
        viewModel.dateLive.observe(getViewLifecycleOwner(), (String date) ->{
            String timeOfMeals=TIME_OF_MEALS[rawPosition];
            Loger.log("viewModel.dateLive date: "+date+", timeOfMeals: "+timeOfMeals);
            binding.date.setText(date);
            viewModel.refreshFoodList(date,timeOfMeals);
        });
        viewModel.foodLive.observe(getViewLifecycleOwner(),(List<EntityFoodPosition> list)-> {
                RecyclerView.Adapter adapter=new RecyclerAdapter_food(list);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
                recyclerView.setHasFixedSize(false);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
        });
        return view;
    }
    public void clickDate(View view){
        dialogfragment.show(requireActivity().getSupportFragmentManager(), "theme");
    }
    public void add(View view){
        Navigation.findNavController(view).navigate(R.id.addFoodFragment);
    }
    public void toSearch(View view){
        Navigation.findNavController(view).navigate(R.id.searchFoodFragment);
    }
}