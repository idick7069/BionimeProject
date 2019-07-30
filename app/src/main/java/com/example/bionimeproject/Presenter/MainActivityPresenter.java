package com.example.bionimeproject.Presenter;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.android.volley.VolleyError;
import com.example.bionimeproject.Adapter.ItemTouchHelperAdapter;
import com.example.bionimeproject.Entities.AqiItem;
import com.example.bionimeproject.Model.AqiModel;
import com.example.bionimeproject.Model.DairyQuoteModel;
import com.example.bionimeproject.Network.OnDairyListener;
import com.example.bionimeproject.Network.OnStringListener;
import com.example.bionimeproject.Network.StringModelImpl;
import com.example.bionimeproject.View.IView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPresenter implements IPresenter, OnStringListener, ItemTouchHelperAdapter, OnDairyListener {

    private AqiModel iModel;
    private StringModelImpl stringModel;
    private DairyQuoteModel dairyQuoteModel;
    private IView iView;
    private static final String TAG = "MainActivityPresenter";
    private Handler mHandler = new Handler();



    public MainActivityPresenter(IView iView,AqiModel aqiModel) {
        this.iView = iView;
        this.iModel = aqiModel;
        stringModel = new StringModelImpl((Context) iView);
        dairyQuoteModel = new DairyQuoteModel((Context) iView);

    }


    @Override
    public void loadDataFromApi() {
        stringModel.load("http://opendata.epa.gov.tw/api/v1/AQI?%24skip=0&%24top=1000&%24format=json", this);
    }

    @Override
    public void deleteData(AqiItem item) {
        Log.d(TAG,"嘗試刪除編號:"+Integer.parseInt(item.getSiteId()));
        if(iModel.delete(Integer.parseInt(item.getSiteId()))){
            Log.d(TAG,"成功刪除編號:"+Integer.parseInt(item.getSiteId()));
        }else {
            Log.d(TAG,"失敗刪除編號:"+Integer.parseInt(item.getSiteId()));
        }
    }

    @Override
    public void crawlerData() {
        dairyQuoteModel.getData("https://tw.appledaily.com/index/dailyquote/",this);
    }




    @Override
    public void onSuccess(String result) {
        Log.d(TAG, result);
        Gson gson = new Gson();

        try {
            ArrayList<AqiItem> aqiModelList = gson.fromJson(result, new TypeToken<ArrayList<AqiItem>>() {
            }.getType());
            Log.d(TAG, "load" + aqiModelList.size() + "");

            for (int i = 0; i < aqiModelList.size(); i++) {

                if (aqiModelList.get(i).getSiteId() != null) {
                    if (iModel.ifExist(Integer.parseInt(aqiModelList.get(i).getSiteId()))) {
                        iModel.update(aqiModelList.get(i));
                    } else {
                        iModel.insertToDatabase(aqiModelList.get(i));
                    }
                }
            }
            Log.d(TAG, "有"+aqiModelList.size() + "個");

            ArrayList<AqiItem> list = iModel.getListFromDatabase();
            Log.d(TAG, list.size() + "個");
            iView.setDataToListview(list);
        }catch (Exception e)
        {
            Log.e(TAG,e.toString());
        }


    }




    @Override
    public void onError(VolleyError error) {
        Log.e(TAG, error.toString());
    }


    @Override
    public void onItemDissmiss(int position) {
//        Log.d(TAG,"嘗試刪除編號:"+position);
//        boolean success = iModel.delete(position);
//        Log.d("TAG",success+"");
    }


    @Override
    public void onLoadSuccess(List<String> result) {
        iView.setDairyToHeader(result);
    }

    @Override
    public void onLoadError(Exception error) {
        Log.e(TAG,error.toString());
    }
}