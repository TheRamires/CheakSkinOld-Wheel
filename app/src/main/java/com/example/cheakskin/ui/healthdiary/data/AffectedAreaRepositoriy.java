package com.example.cheakskin.ui.healthdiary.data;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class AffectedAreaRepositoriy {
    public void loadAffectedsLists(MutableLiveData<List<EntityAffected>> affectedLive1,
                                   MutableLiveData<List<EntityAffected>> affectedLive2){
        //forExample
        EntityAffected enity11=new EntityAffected(1,"торс","body_torso");
        EntityAffected enity12=new EntityAffected(2,"нога","body_leg");
        EntityAffected enity13=new EntityAffected(3,"торс","body_torso");
        EntityAffected enity14=new EntityAffected(4,"торс","body_torso");

        EntityAffected enity21=new EntityAffected(5,"нога","body_leg");
        EntityAffected enity22=new EntityAffected(6,"нога","body_leg");

        List<EntityAffected> list1=new ArrayList<>();
        list1.add(enity11); list1.add(enity12); list1.add(enity13); list1.add(enity14);

        List<EntityAffected> list2=new ArrayList<>();
        list2.add(enity21);list2.add(enity22);

        affectedLive1.setValue(list1);
        affectedLive2.setValue(list2);
    }
}
