package com.example.model;

import java.io.Serializable;

public class CustomerService implements Serializable {
    private String CustomerService_Name;
    private int CustomerService_Icon;


    public CustomerService(String customerService_Name, int customerService_Icon) {
        CustomerService_Name = customerService_Name;
        CustomerService_Icon = customerService_Icon;
    }


    public String getCustomerService_Name() {
        return CustomerService_Name;
    }

    public void setCustomerService_Name(String customerService_Name) {
        CustomerService_Name = customerService_Name;
    }
    public int getCustomerService_Icon() {
        return CustomerService_Icon;
    }

    public void setCustomerService_Icon(int customerService_Icon) {
        CustomerService_Icon = customerService_Icon;
    }
}

