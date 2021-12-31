package com.example.model;

public class ItemObject {
    private int idItem;
    private String nameItem;


    public ItemObject(int idItem, String nameItem) {
        this.idItem = idItem;
        this.nameItem = nameItem;
    }

    public ItemObject() {
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }
}