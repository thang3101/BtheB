package com.example.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String Name;
    private byte[] Thumb;
    private double Price;
    private String Type;
    private String Description;


    public Product(String name, byte[] thumb, double price, String type, String description) {
        Name = name;
        Thumb = thumb;
        Price = price;
        Type = type;
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public byte[] getThumb() {
        return Thumb;
    }

    public void setThumb(byte[] thumb) {
        Thumb = thumb;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
