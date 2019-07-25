package com.example.bionimeproject.View;

import com.example.bionimeproject.Entities.AqiItem;

import java.util.ArrayList;

public interface IView {
    void setDataToListview(ArrayList<AqiItem> categoriesToList);
}