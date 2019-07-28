package com.example.bionimeproject;

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
import android.widget.TextView;

import com.example.bionimeproject.Adapter.ListItemListener;
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
    private Toolbar toolbar;
    private final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private HomeAdapter homeAdapter;
    private ArrayList<AqiItem> dataArrayList;
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

    //初始化View
    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        headerView = getLayoutInflater().inflate(R.layout.header_layout, (ViewGroup) mRecyclerView.getParent(), false);
        chiText = (TextView) headerView.findViewById(R.id.chiText);
        engText = (TextView) headerView.findViewById(R.id.engText);
        anchorText = (TextView) headerView.findViewById(R.id.anchorText);
        timeText = (TextView) headerView.findViewById(R.id.timeText);
    }

    //初始化工具列
    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.app_toolbar2);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("空氣品質檢測");
    }

    //初始化轉換器
    private void initAdapter() {
        homeAdapter = new HomeAdapter(R.layout.item_layout, dataArrayList);
        //開啟LoadItem動畫
        homeAdapter.openLoadAnimation();
        //新增Header
        homeAdapter.addHeaderView(headerView);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(homeAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setAdapter(homeAdapter);
        homeAdapter.setItemClickListener(new ListItemListener() {
            @Override
            public void removeItemFromDatabase(AqiItem item) {
                iPresenter.deleteData(item);
            }
        });
    }

    @Override
    public void setDataToListview(ArrayList<AqiItem> dataList) {
        Log.d(TAG, dataList.toString());
        dataArrayList = dataList;
    }

    @Override
    public void setDairyToHeader(final List<String> list) {
        Log.d("list", list.size() + "個");
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 此處執行耗時操作，結束後，執行runOnUiThread將線程切換到主線程去更新ui

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 更新UI
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
