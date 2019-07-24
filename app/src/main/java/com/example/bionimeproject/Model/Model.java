package com.example.bionimeproject.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.bionimeproject.Adapter.AqiItem;
import com.example.bionimeproject.View.IView;

import java.util.ArrayList;
import java.util.List;

public class Model implements IModel {
    private SQLiteDatabase database;

    public Model(IView iView) {
        database = new DatabaseOpenHelper((Context) iView).getWritableDatabase();
    }

//    @Override
//    public List<String> getListFromDatabase() {
//
//        List<String> list = new ArrayList<>();
//        String sqlQueryText = "SELECT * FROM AQI_TABLE";
//        Cursor cursor = this.database.rawQuery(sqlQueryText, null);
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            list.add(cursor.getString(0));
//            list.add(cursor.getString(1));
//            list.add(cursor.getString(2));
//            cursor.moveToNext();
//        }
//        cursor.close();
//        database.close();
//        return list;
//    }

    @Override
    public ArrayList<AqiItem> getListFromDatabase() {

//        ArrayList<AqiItem> list = new ArrayList<>();
////        List<String> list = new ArrayList<>();
//        String sqlQueryText = "SELECT * FROM AQI_TABLE";
//        Cursor cursor = this.database.rawQuery(sqlQueryText, null);
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            list.get()
//            cursor.moveToNext();
//        }
//        cursor.close();
//        database.close();
//        return list;

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