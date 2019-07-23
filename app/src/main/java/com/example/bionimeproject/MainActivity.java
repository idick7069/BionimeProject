package com.example.bionimeproject;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bionimeproject.Presenter.IPresenter;
import com.example.bionimeproject.Presenter.MainActivityPresenter;
import com.example.bionimeproject.View.IView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {
    private IPresenter iPresenter;
    private ListView aqiList;
    private final String TAG  = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        iPresenter = new MainActivityPresenter(this);
        iPresenter.setDataToListview();
    }
    private void initView() {
        aqiList = (ListView) findViewById(R.id.aqiList);
    }
    @Override
    public void setDataToListview(List<String> stringList) {
        Log.d(TAG,stringList.toString());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList);
        aqiList.setAdapter(arrayAdapter);
    }


}
