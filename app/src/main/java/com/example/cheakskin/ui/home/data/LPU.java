package com.example.cheakskin.ui.home.data;

public class LPU {
    private int id;

    private double point;
    private String city;
    private String name;
    private String number;

    private String description="";
    private String schedule="";
    private String website="";

    public LPU (double point, String city, String name, String number,
                String description, String schedule, String website){
        this.point=point;
        this.city=city;
        this.name=name;
        this.number=number;
        this.description=description;
        this.schedule=schedule;
        this.website=website;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public void setPoint(double point){
        this.point=point;
    }
    public double getPoint(){
        return point;
    }
    public void setCity(String city){
        this.city=city;
    }
    public String getCity(){
        return city;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setNumber(String number){
        this.number=number;
    }
    public String getNumber(){
        return number;
    }

    public void setDescription(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }
    public void setSchedule(String schedule){
        this.schedule=schedule;
    }
    public String getSchedule(){
        return schedule;
    }
    public void setWebsite(String website){
        this.website=website;
    }
    public String getWebsite(){
        return website;
    }

}
