package com.example.bionimeproject.Presenter;

import com.example.bionimeproject.Entities.AqiItem;

public interface IPresenter {
    void loadDataFromApi();
    void deleteData(AqiItem item);
    void crawlerData();
}