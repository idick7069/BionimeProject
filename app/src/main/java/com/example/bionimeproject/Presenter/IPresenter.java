package com.example.bionimeproject.Presenter;

import com.example.bionimeproject.Entities.AqiItem;

public interface IPresenter {
    void setDataToListview();
//    int insertToDatabase(AqiItem item);
    void loadDataFromApi();

}