package com.example.bionimeproject.Model;

import com.example.bionimeproject.Adapter.AqiItem;

import java.util.ArrayList;

public interface IModel {
    ArrayList<AqiItem> getListFromDatabase();
}