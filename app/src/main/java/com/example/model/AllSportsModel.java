package com.example.model;

public class AllSportsModel {
    private int Thumb;
    private  String Name;


    public AllSportsModel(int thumb, String name) {
        Thumb = thumb;
        Name = name;
    }

    public int getThumb() {
        return Thumb;
    }

    public void setThumb(int thumb) {
        Thumb = thumb;
    }

    public AllSportsModel() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
