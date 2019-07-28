package com.example.bionimeproject;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bionimeproject.Adapter.HeaderAdapter;
import com.example.bionimeproject.Adapter.MyItemListener;
import com.example.bionimeproject.Adapter.SimpleItemTouchHelperCallback;
import com.example.bionimeproject.Entities.AqiItem;
import com.example.bionimeproject.Adapter.HomeAdapter;
import com.example.bionimeproject.Presenter.IPresenter;
import com.example.bionimeproject.Presenter.MainActivityPresenter;
import com.example.bionimeproject.View.IView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements IView {
    private IPresenter iPresenter;
    private ListView aqiList;
    private Toolbar toolbar;
    private final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private HomeAdapter homeAdapter;
    private MyItemListener itemListener;
    private ArrayList<AqiItem> dataArrayList;
    private HeaderAdapter headerAdapter;
    private List<String> headlist;
    private TextView chiText, engText, anchorText, timeText;
    private View headerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        initView();

        iPresenter = new MainActivityPresenter(this);
        iPresenter.loadDataFromApi();
        iPresenter.setDataToListview();
        iPresenter.crawlerData();

        initAdapter();

    }


    private void initView() {
//        aqiList = (ListView) findViewById(R.id.aqiList);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        headerView = getLayoutInflater().inflate(R.layout.header_layout, (ViewGroup) mRecyclerView.getParent(), false);
        chiText = (TextView) headerView.findViewById(R.id.chiText);
        engText = (TextView) headerView.findViewById(R.id.engText);
        anchorText = (TextView) headerView.findViewById(R.id.anchorText);
        timeText = (TextView) headerView.findViewById(R.id.timeText);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.app_toolbar2);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("空氣檢測");
    }

    @Override
    public void setDataToListview(ArrayList<AqiItem> dataList) {
        Log.d(TAG, dataList.toString());
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList);
//        aqiList.setAdapter(arrayAdapter);
        dataArrayList = dataList;

    }

    private void initAdapter() {
        homeAdapter = new HomeAdapter(R.layout.item_layout, dataArrayList);

        homeAdapter.openLoadAnimation();


        homeAdapter.addHeaderView(headerView);


        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
        //先实例化Callback
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(homeAdapter);
        //用Callback构造ItemtouchHelper
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
        touchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setAdapter(homeAdapter);
        homeAdapter.setItemClickListener(new MyItemListener() {
            @Override
            public void removeItemFromDatabase(AqiItem item) {
                iPresenter.deleteData(item);
            }
        });
    }

    @Override
    public void setDairyToHeader(final List<String> list) {
        Log.d("list", list.size() + "個");
//        chiText.setText(list.get(0));
//        engText.setText(list.get(1));
//        anchorText.setText(list.get(2));

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 此处执行耗时操作，结束后，执行runOnUiThread将线程切换到主线程去更新ui

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 更新ui操作
                        chiText.setText(list.get(0));
                        engText.setText(list.get(1));
                        anchorText.setText(list.get(2));
                        timeText.setText(list.get(3));
                    }
                });
            }
        }).start();
    }


}
