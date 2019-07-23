package com.example.bionimeproject.Presenter;

import com.example.bionimeproject.Model.IModel;
import com.example.bionimeproject.Model.Model;
import com.example.bionimeproject.View.IView;

import java.util.List;

public class MainActivityPresenter implements IPresenter{

    private IModel iModel;
    private IView iView;

    public MainActivityPresenter(IView iView) {
        this.iView = iView;
        iModel = new Model(iView);
    }

    @Override
    public void setDataToListview() {
        List<String> list = iModel.getListFromDatabase();
        iView.setDataToListview(list);
    }


}