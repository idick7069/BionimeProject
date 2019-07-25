package com.example.bionimeproject.Presenter;

import android.content.Context;
import android.util.Log;

import com.android.volley.VolleyError;
import com.example.bionimeproject.Entities.AqiItem;
import com.example.bionimeproject.Model.AqiModel;
import com.example.bionimeproject.Model.IModel;
import com.example.bionimeproject.Model.Model;
import com.example.bionimeproject.Network.OnStringListener;
import com.example.bionimeproject.Network.StringModelImpl;
import com.example.bionimeproject.Network.VolleyRequestHelper;
import com.example.bionimeproject.View.IView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivityPresenter implements IPresenter, OnStringListener {

    private IModel iModel;
    private StringModelImpl stringModel;
    private IView iView;
    private static final String TAG = "MainActivityPresenter";

    /* The request completed listener */
    private VolleyRequestHelper.OnRequestCompletedListener requestCompletedListener = new VolleyRequestHelper.OnRequestCompletedListener() {
        @Override
        public void onRequestCompleted(String requestName, boolean status,
                                       String response, String errorMessage) {

            if (status) {
                Gson gson = new Gson();
                ArrayList<AqiItem> aqiModelList = gson.fromJson(response, new TypeToken<ArrayList<AqiItem>>() {
                }.getType());
                Log.d(TAG,aqiModelList.size()+"");

            }

        }
    };
    private VolleyRequestHelper volleyRequestHelper;

    public MainActivityPresenter(IView iView) {
        this.iView = iView;
        iModel = new AqiModel(iView);
        stringModel = new StringModelImpl((Context) iView);
    }

    @Override
    public void setDataToListview() {
        ArrayList<AqiItem> list = iModel.getListFromDatabase();
//        Log.d(TAG,list.get(0).getSiteName());
//        iView.setDataToListview(list);
        stringModel.load("http://opendata.epa.gov.tw/api/v1/AQI?%24skip=0&%24top=1000&%24format=json",this);
    }


    @Override
    public void onSuccess(String result) {
        Log.d(TAG,result);
    }

    @Override
    public void onError(VolleyError error) {
        Log.e(TAG,error.toString());
    }
}