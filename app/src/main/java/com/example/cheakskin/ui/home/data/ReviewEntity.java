package com.example.cheakskin.ui.home.data;

public class ReviewEntity {
    private int id;
    private int idOfLpu;

    private double point;
    private String name;
    private String text;
    private String date;

    public ReviewEntity(int idOfLpu, double point, String name,String text, String date){
        this.point=point;
        this.name=name;
        this.text=text;
        this.date=date;
        this.idOfLpu=idOfLpu;
    }
    public void  setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setIdOfLpu(int idOfLpu){
        this.idOfLpu=idOfLpu;
    }
    public int getIdOfLpu(){
        return idOfLpu;
    }

    public void setPoint(double point){
        this.point=point;
    }
    public double getPoint(){
        return point;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return  name;
    }
    public void setText(String text){
        this.text=text;
    }
    public String getText(){
        return text;
    }
    public void setDate(String date){
        this.date=date;
    }
    public String getDate(){
        return  date;
    }
}
