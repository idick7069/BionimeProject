package com.example.bionimeproject.Presenter;

import com.example.bionimeproject.Entities.AqiItem;

public interface IPresenter {
    void setDataToListview();
    void loadDataFromApi();
    void deleteData(int position);
}