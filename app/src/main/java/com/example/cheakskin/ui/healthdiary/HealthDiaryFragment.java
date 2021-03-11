package com.example.cheakskin.ui.healthdiary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.cheakskin.Loger;
import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentHealthDiaryBinding;
import com.example.cheakskin.ui.fooddiary.DatePickerTheme;

import static com.example.cheakskin.ui.fooddiary.Util.TIME_OF_MEALS;

public class HealthDiaryFragment extends Fragment {
    private DialogFragment dialogfragment;

    private HealthDiaryViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FragmentHealthDiaryBinding binding=FragmentHealthDiaryBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        viewModel =
                new ViewModelProvider(requireActivity()).get(HealthDiaryViewModel.class);

        dialogfragment = new DatePickerTheme(viewModel.dateLive);

        viewModel.dateLive.observe(getViewLifecycleOwner(), (String date) ->{
            binding.date.setText(date);
        });
        return view;
    }
    public void clickDate(View view){
        dialogfragment.show(requireActivity().getSupportFragmentManager(), "theme2");
    }
    public void toState(View view){
        Navigation.findNavController(view).navigate(R.id.action_navigation_health_diary_to_stateFragment);
    }
    public void toTreatment(View view){
        Navigation.findNavController(view).navigate(R.id.action_navigation_health_diary_to_treatmentFragment);
    }
    public void toRating(View view){
        Navigation.findNavController(view).navigate(R.id.action_navigation_health_diary_to_ratingFragment);
    }
    public void toComment (View view){
        Navigation.findNavController(view).navigate(R.id.action_navigation_health_diary_to_commentFragment);
    }
    public void toAffectedAreas (View view){
        Navigation.findNavController(view).navigate(R.id.action_navigation_health_diary_to_affectedAreasFragment);
    }
    public void toReminders(View view){
        Navigation.findNavController(view).navigate(R.id.action_navigation_health_diary_to_remindersFragment3);
    }
}