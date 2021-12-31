package com.example.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.model.Product;

import java.util.ArrayList;

public class Product_Database_Helper {
    Context context;
    SQLiteDatabase db;
    public Product_Database_Helper(Context context) {
        this.context = context;
        Products_Database assetDB = new Products_Database(context);
        db = assetDB.StoreDatabase();
    }

    private ArrayList<Product> getAllProduct(String sql, String...selectionArgs){
        ArrayList<Product> items = new ArrayList<>();

        Cursor c = db.rawQuery(sql, selectionArgs);
        while(c.moveToNext()){
            items.add(new Product(c.getString(0), c.getBlob(2), c.getInt(1), c.getString(3),c.getString(6)));
        }
        c.close();
        return items;
    }

    public ArrayList<Product> dsAllProducts() {
        String sql = "select * from Product order by random() ";

        return getAllProduct(sql);
    }

    public ArrayList<Product> dsCartProducts() {
        String sql = "select * from Product order by random() limit 2 ";
        return getAllProduct(sql);
    }
}