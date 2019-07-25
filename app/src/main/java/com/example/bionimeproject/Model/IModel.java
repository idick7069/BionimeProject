package com.example.bionimeproject.Model;

import com.example.bionimeproject.Entities.AqiItem;

import java.util.ArrayList;

public interface IModel {
    ArrayList<AqiItem> getListFromDatabase();
    int insertToDatabase(AqiItem item);
}