package com.example.cheakskin.ui.healthdiary.data;

public class EntityReminders {
    private int id;
    private String name;
    private String description;
    private String time;

    public EntityReminders(String name, String description, String time ){
        this.name=name; this.description=description; this.time=time;
    }

    public void setId (int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public  void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setTime(String time){
        this.time=time;
    }
    public String getTime(){
        return time;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }
}
