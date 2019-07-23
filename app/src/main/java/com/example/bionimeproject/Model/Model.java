package com.example.bionimeproject.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bionimeproject.View.IView;

import java.util.ArrayList;
import java.util.List;

public class Model implements IModel {
    private SQLiteDatabase database;

    public Model(IView iView) {
        database = new DatabaseOpenHelper((Context) iView).getWritableDatabase();
    }

    @Override
    public List<String> getListFromDatabase() {

        List<String> list = new ArrayList<>();
        String sqlQueryText = "SELECT adam, til FROM makal";
        Cursor cursor = this.database.rawQuery(sqlQueryText, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        database.close();
        return list;
    }

}