package com.example.cheakskin.ui.healthdiary.viewModels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cheakskin.Loger;
import com.example.cheakskin.ui.healthdiary.data.AffectedAreaRepositoriy;
import com.example.cheakskin.ui.healthdiary.data.EntityAffected;

import java.util.List;

public class AffectedAreaViewModel extends ViewModel {
    public MutableLiveData<List<EntityAffected>> affectedLive1=new MutableLiveData<>();
    public MutableLiveData<List<EntityAffected>> affectedLive2=new MutableLiveData<>();

    AffectedAreaRepositoriy repo=new AffectedAreaRepositoriy();

    public void getAffectedLists(){
        repo.loadAffectedsLists(affectedLive1,affectedLive2);
    }
    public void deletePosition(int id){
        Loger.log("delete"+id);
    }
}
