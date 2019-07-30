package com.example.bionimeproject.Presenter;

import com.example.bionimeproject.Entities.AqiItem;

import com.example.bionimeproject.Model.AqiModel;
import com.example.bionimeproject.View.IDetailView;

public class DetailPresenter implements IDetailPresenter{

    private AqiModel iModel;
    private IDetailView iDetailView;
    private AqiItem aqiItem;

   public DetailPresenter(IDetailView view, AqiModel model){
       this.iDetailView = view;
       this.iModel = model;
   }

    @Override
    public void getDetailFromDB(int id) {
        aqiItem = iModel.get(id);
        iDetailView.setDetailData(aqiItem);
    }

}
