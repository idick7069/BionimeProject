package com.example.bionimeproject.View;

import com.example.bionimeproject.Entities.AqiItem;

import java.util.ArrayList;
import java.util.List;

public interface IView {
    void setDataToListview(ArrayList<AqiItem> categoriesToList);
    void setDairyToHeader(List<String> list);
}