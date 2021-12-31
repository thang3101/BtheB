package com.example.model;

public class Vouchers {
    int imvThumb;
    String txtTittle,txtDescrip;

    public Vouchers(int imvThumb, String txtTittle, String txtDescrip) {
        this.imvThumb = imvThumb;
        this.txtTittle = txtTittle;
        this.txtDescrip = txtDescrip;
    }


    public int getImvThumb() {
        return imvThumb;
    }

    public void setImvThumb(int imvThumb) {
        this.imvThumb = imvThumb;
    }

    public String getTxtTittle() {
        return txtTittle;
    }

    public void setTxtTittle(String txtTittle) {
        this.txtTittle = txtTittle;
    }

    public String getTxtDescrip() {
        return txtDescrip;
    }

    public void setTxtDescrip(String txtDescrip) {
        this.txtDescrip = txtDescrip;
    }
}
