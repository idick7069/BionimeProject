package com.example.bionimeproject.Presenter;

import android.util.Log;

import com.example.bionimeproject.Adapter.AqiItem;
import com.example.bionimeproject.Model.IModel;
import com.example.bionimeproject.Model.Model;
import com.example.bionimeproject.View.IView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPresenter implements IPresenter{

    private IModel iModel;
    private IView iView;
    private static final String TAG = "MainActivityPresenter";

    public MainActivityPresenter(IView iView) {
        this.iView = iView;
        iModel = new Model(iView);
    }

    @Override
    public void setDataToListview() {
        ArrayList<AqiItem> list = iModel.getListFromDatabase();
        Log.d(TAG,list.get(0).getSiteName());
        iView.setDataToListview(list);
    }


}