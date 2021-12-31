package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Products_Database {
    private static final String DB_NAME = "product_db.db";
    private Context context;


    public Products_Database(Context context) {
        this.context = context;
    }

    public SQLiteDatabase StoreDatabase() {
        String path = "/data/data/com.example.btheb/databases";
        File pathDb = new File(path);
        try {
            if (!pathDb.exists()){
                pathDb.mkdir();
            }
            if (!new File(path + "/" + DB_NAME).exists()) {
                copy(path);
            }
        } catch (IOException e) {
            Log.d("IOException", e.getMessage());
        }
        Log.i("DB",context.getDatabasePath(DB_NAME).getPath());
        return SQLiteDatabase.openDatabase(context.getDatabasePath(DB_NAME).getPath(), null, SQLiteDatabase.OPEN_READONLY);
    }

    private void copy(String path) throws IOException {

        InputStream is = context.getAssets().open(DB_NAME);
        FileOutputStream fos = new FileOutputStream(path + "/" + DB_NAME);
        byte buffer[] = new byte[1024];
        int length;

        while ((length = is.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }
        is.close();
        fos.flush();
        fos.close();
    }
}
