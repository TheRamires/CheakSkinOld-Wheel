package com.example.cheakskin.ui.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.cheakskin.Loger;
import com.example.cheakskin.R;
import com.example.cheakskin.databinding.FragmentLpuDocumentsBinding;
import com.example.cheakskin.ui.home.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LPUDocumentsFrag extends Fragment {
    private AppCompatActivity activity;
    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private FragmentLpuDocumentsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentLpuDocumentsBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();

        expListView = binding.lvExp;
        //Подготавливаем список данных:
        prepareListData();

        listAdapter = new ExpandableListAdapter(requireContext(), listDataHeader, listDataChild);

        //Настраиваем listAdapter:
        expListView.setAdapter(listAdapter);

        return view;
    }
    //------------------------------------------------------------------------------------

    private void prepareListData() {
        Log.d("myLog","prepareListData");
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        //Добавляем данные о пунктах списка:
        listDataHeader.add("Пункт 1");
        listDataHeader.add("Пункт 2");
        listDataHeader.add("Пункт 3");

        //Добавляем данные о подпунктах:
        List<String> top250 = new ArrayList<String>();
        top250.add("Подпункт 1.1");
        top250.add("Подпункт 1.2");
        top250.add("Подпункт 1.3");
        top250.add("Подпункт 1.4");
        top250.add("Подпункт 1.5");
        top250.add("Подпункт 1.6");
        top250.add("Подпункт 1.7");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Подпункт 2.1");
        nowShowing.add("Подпункт 2.2");
        nowShowing.add("Подпункт 2.3");
        nowShowing.add("Подпункт 2.4");
        nowShowing.add("Подпункт 2.5");
        nowShowing.add("Подпункт 2.6");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Подпункт 3.1");
        comingSoon.add("Подпункт 3.2");
        comingSoon.add("Подпункт 3.3");
        comingSoon.add("Подпункт 3.4");
        comingSoon.add("Подпункт 3.5");

        listDataChild.put(listDataHeader.get(0), top250);
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
        //При раскрывании списка
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getContext(),
                        listDataHeader.get(groupPosition) + " Раскрыт",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //Сворачиваем список
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getContext(),
                        listDataHeader.get(groupPosition) + " Свернут",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void backstack(View view){
        Navigation.findNavController(view).popBackStack();
    }
}