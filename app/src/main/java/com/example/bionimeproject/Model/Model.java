package com.example.bionimeproject.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bionimeproject.Entities.AqiItem;
import com.example.bionimeproject.View.IView;

import java.util.ArrayList;

/**
 * 棄用DatabaseOpenHelper方式的Model
 * */
public class Model {
    private SQLiteDatabase database;

    public Model(IView iView) {
        database = new DatabaseOpenHelper((Context) iView).getWritableDatabase();
    }


    public ArrayList<AqiItem> getListFromDatabase() {

        ArrayList<AqiItem> result = new ArrayList<>();
        String sqlQueryText = "SELECT * FROM AQI_TABLE";
        Cursor cursor = this.database.rawQuery(sqlQueryText, null);

        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }
        cursor.close();
        return result;
    }





    private AqiItem getRecord(Cursor cursor){
        AqiItem aqiItem = new AqiItem();
        aqiItem.setSiteName(cursor.getString(0));
        aqiItem.setCountry(cursor.getString(1));
        aqiItem.setAQI(cursor.getString(2));

        return aqiItem;
    }

}