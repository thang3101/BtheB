package com.example.model;

public class Order {
    int imvThumb_Order;
    String txtStatus_order;
    String txtDetail_order;


    public Order(int imvThumb_Order, String txtStatus_order, String txtDetail_order) {
        this.imvThumb_Order = imvThumb_Order;
        this.txtStatus_order = txtStatus_order;
        this.txtDetail_order = txtDetail_order;
    }

    public int getImvThumb_Order() {
        return imvThumb_Order;
    }

    public void setImvThumb_Order(int imvThumb_Order) {
        this.imvThumb_Order = imvThumb_Order;
    }

    public String getTxtStatus_order() {
        return txtStatus_order;
    }

    public void setTxtStatus_order(String txtStatus_order) {
        this.txtStatus_order = txtStatus_order;
    }

    public String getTxtDetail_order() {
        return txtDetail_order;
    }

    public void setTxtDetail_order(String txtDetail_order) {
        this.txtDetail_order = txtDetail_order;
    }
}
