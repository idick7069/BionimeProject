package com.example.bionimeproject;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

import com.example.bionimeproject.Entities.AqiItem;
import com.example.bionimeproject.Adapter.HomeAdapter;
import com.example.bionimeproject.Presenter.IPresenter;
import com.example.bionimeproject.Presenter.MainActivityPresenter;
import com.example.bionimeproject.View.IView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements IView {
    private IPresenter iPresenter;
    private ListView aqiList;
    private Toolbar toolbar;
    private final String TAG  = "MainActivity";
    private RecyclerView mRecyclerView;
    private HomeAdapter homeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initToolbar();

        iPresenter = new MainActivityPresenter(this);
        iPresenter.setDataToListview();


    }



    private void initView() {
//        aqiList = (ListView) findViewById(R.id.aqiList);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);

    }

    private void initToolbar()
    {
        toolbar = (Toolbar) findViewById(R.id.app_toolbar2);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("空氣檢測");
    }

    @Override
    public void setDataToListview(ArrayList<AqiItem> dataList) {
        Log.d(TAG,dataList.toString());
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList);
//        aqiList.setAdapter(arrayAdapter);
        homeAdapter = new HomeAdapter(R.layout.item_layout,dataList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(homeAdapter);
    }


}
