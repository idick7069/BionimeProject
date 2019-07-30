package com.example.bionimeproject;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.example.bionimeproject.Entities.AqiItem;
import com.example.bionimeproject.Model.AqiModel;
import com.example.bionimeproject.Presenter.DetailPresenter;
import com.example.bionimeproject.View.IDetailView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailActivity extends AppCompatActivity implements IDetailView {

    @BindView(R.id.PollutantText)
    TextView PollutantText;
    @BindView(R.id.StatusText)
    TextView StatusText;
    @BindView(R.id.SO2Text)
    TextView SO2Text;
    @BindView(R.id.COText)
    TextView COText;
    @BindView(R.id.CO_8hrText)
    TextView CO8hrText;
    @BindView(R.id.O3_8hrText)
    TextView O38hrText;
    @BindView(R.id.PM10Text)
    TextView PM10Text;
    @BindView(R.id.PM25Text)
    TextView PM25Text;
    @BindView(R.id.NO2Text)
    TextView NO2Text;
    @BindView(R.id.NOxText)
    TextView NOxText;
    @BindView(R.id.NOText)
    TextView NOText;
    @BindView(R.id.WindSpeedText)
    TextView WindSpeedText;
    @BindView(R.id.WindDirecText)
    TextView WindDirecText;
    @BindView(R.id.PublishTimeText)
    TextView PublishTimeText;
    @BindView(R.id.PM25_AVGText)
    TextView PM25AVGText;
    @BindView(R.id.PM10_AVGText)
    TextView PM10AVGText;
    @BindView(R.id.SO2_AVGText)
    TextView SO2AVGText;
    @BindView(R.id.LongText)
    TextView LongText;
    @BindView(R.id.LatiText)
    TextView LatiText;
    @BindView(R.id.O3Text)
    TextView O3Text;
    @BindView(R.id.AqitText)
    TextView AqitText;
    private DetailPresenter presenter;

    private Toolbar toolbar;
    private final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        int itemId = bundle.getInt("data");
        String siteName = bundle.getString("site","無資料");

        presenter = new DetailPresenter(this, new AqiModel(this));
        presenter.getDetailFromDB(itemId);

        initToolbar(siteName);
    }

    //初始化工具列
    private void initToolbar(String site) {
        toolbar = (Toolbar) findViewById(R.id.app_toolbar2);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle(site+" 目前空氣品質");
        actionbar.setHomeButtonEnabled(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void setDetailData(AqiItem item) {
        if (item != null) {
            Log.d(TAG, item.getSiteId() + ";" + item.getSiteName());
            AqitText.setText(item.getAQI());
            PollutantText.setText(item.getPollutant());
            StatusText.setText(item.getStatus());
            SO2Text.setText(item.getSO2());
            COText.setText(item.getCO());
            CO8hrText.setText(item.getCO_8hr());
            O3Text.setText(item.getO3());
            O38hrText.setText(item.getCO_8hr());
            PM10Text.setText(item.getPM10());
            PM25Text.setText(item.getPM25());
            NO2Text.setText(item.getNO2());
            NOxText.setText(item.getNOx());
            NOText.setText(item.getNO());
            WindSpeedText.setText(item.getWindSpeed());
            WindDirecText.setText(item.getWindDirec());
            PublishTimeText.setText(item.getPublishTime());
            PM25AVGText.setText(item.getPM25());
            PM10AVGText.setText(item.getPM10_AVG());
            SO2AVGText.setText(item.getSO2_AVG());
            LongText.setText(item.getLongitude());
            LatiText.setText(item.getLatitude());

        }


    }
}
