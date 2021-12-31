package com.example.model;

public class PaymentMethod {
    String Title;
    String Descrip;
    int Status, Thumb;


    public PaymentMethod(String title, String descrip, int status, int thumb) {
        Title = title;
        Descrip = descrip;
        Status = status;
        Thumb = thumb;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescrip() {
        return Descrip;
    }

    public void setDescrip(String descrip) {
        Descrip = descrip;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getThumb() {
        return Thumb;
    }

    public void setThumb(int thumb) {
        Thumb = thumb;
    }
}
