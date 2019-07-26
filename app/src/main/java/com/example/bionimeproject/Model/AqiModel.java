package com.example.bionimeproject.Model;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bionimeproject.Entities.AqiItem;
import com.example.bionimeproject.View.IView;
import com.google.gson.Gson;

import java.util.ArrayList;

public class AqiModel implements IModel{
    //宣告
    private static final String TAG = DBHelper.class.getSimpleName();
    //Json Resources
    private Resources mResources;
    Context context;

    //Gson
    Gson gson = new Gson();

    // 表格名稱
    public static final String TABLE_NAME = "aqi";

    // 編號表格欄位名稱，固定不變
    public static final String KEY_ID = "_id";

    // 其它表格欄位名稱
    public static final String SITENAME_COLUMN = "SiteName";
    public static final String COUNTRY_COLUMN = "County";
    public static final String AQI_COLUMN = "AQI";
    public static final String POLLUTANT_COLUMN = "Pollutant";
    public static final String STATUS_COLUMN = "Status";
    public static final String SO2_COLUMN = "SO2";
    public static final String CO_COLUMN = "CO";
    public static final String CO_8HR_COLUMN = "CO_8hr";
    public static final String O3_COLUMN = "O3";
    public static final String O3_8HR_COLUMN = "O3_8hr";
    public static final String PM10_COLUMN = "PM10";
    public static final String PM25_COLUMN = "PM25";
    public static final String NO2_COLUMN = "NO2";
    public static final String NOX_COLUMN = "NOx";
    public static final String NO_COLUMN =  "NO";
    public static final String WINDSPEED_COLUMN =  "WindSpeed";
    public static final String WINDDIREC_COLUMN =  "WindDirec";
    public static final String PUBLISHTIME_COLUMN = "PublishTime";
    public static final String PM25_AVG_COLUMN = "PM25_AVG";
    public static final String PM10_ANG_COLUMN =  "PM10_AVG";
    public static final String SO2_AVG_COLUMN =  "SO2_AVG";
    public static final String LONGITUDE_COLUMN =  "Longitude";
    public static final String LATITUDE_COLUMN =  "Latitude";
    public static final String SITEID_COLUMN =  "SiteId";



    // 使用上面宣告的變數建立表格的SQL指令
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    SITENAME_COLUMN + " TEXT , " +
                    COUNTRY_COLUMN + " TEXT, " +
                    AQI_COLUMN + " TEXT, " +
                    POLLUTANT_COLUMN + " TEXT, " +
                    STATUS_COLUMN + " TEXT, " +
                    SO2_COLUMN + " TEXT, " +
                    CO_COLUMN + " TEXT, " +
                    CO_8HR_COLUMN + " TEXT, " +
                    O3_COLUMN + " TEXT, " +
                    O3_8HR_COLUMN + " TEXT, " +
                    PM10_COLUMN + " TEXT, " +
                    PM25_COLUMN +" TEXT, " +
                    NO2_COLUMN + " TEXT, " +
                    NOX_COLUMN + " TEXT, " +
                    NO_COLUMN + " TEXT, " +
                    WINDSPEED_COLUMN + " TEXT, " +
                    WINDDIREC_COLUMN + " TEXT, " +
                    PUBLISHTIME_COLUMN + " TEXT, " +
                    PM25_AVG_COLUMN + " TEXT, " +
                    PM10_ANG_COLUMN + " TEXT, " +
                    SO2_AVG_COLUMN + " TEXT, " +
                    LONGITUDE_COLUMN + " TEXT, " +
                    LATITUDE_COLUMN + " TEXT, " +
                    SITEID_COLUMN + " TEXT )";





    // 資料庫物件
    private SQLiteDatabase db;

    // 建構子，一般的應用都不需要修改
    public AqiModel(IView iView) {
        db = DBHelper.getDatabase((Context) iView);
    }


    // 關閉資料庫，一般的應用都不需要修改
    public void close() {
        db.close();
    }

    @Override
    public ArrayList<AqiItem> getListFromDatabase() {

        ArrayList<AqiItem> result = new ArrayList<>();
        Cursor cursor = db.query(
                TABLE_NAME, null, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }

        cursor.close();
        return result;
    }
    private AqiItem getRecord(Cursor cursor){
        AqiItem aqiItem = new AqiItem();
        aqiItem.setSiteName(cursor.getString(0));
        aqiItem.setCountry(cursor.getString(1));
        aqiItem.setAQI(cursor.getString(2));

        return aqiItem;
    }

    // 新增參數指定的物件
    @Override
    public int insertToDatabase(AqiItem item) {
        // 建立準備新增資料的ContentValues物件
        ContentValues cv = new ContentValues();

        // 加入ContentValues物件包裝的新增資料
        // 第一個參數是欄位名稱， 第二個參數是欄位的資料
        cv.put(SITENAME_COLUMN, item.getSiteName());
        cv.put(COUNTRY_COLUMN, item.getCountry());
        cv.put(AQI_COLUMN, item.getAQI());
        cv.put(POLLUTANT_COLUMN, item.getPollutant());
        cv.put(STATUS_COLUMN, item.getStatus() );
        cv.put(SO2_COLUMN, item.getSO2() );
        cv.put(CO_COLUMN, item.getCO() );
        cv.put(CO_8HR_COLUMN, item.getCO_8hr() );
        cv.put(O3_COLUMN, item.getO3() );
        cv.put(O3_8HR_COLUMN, item.getO3_8h() );
        cv.put(PM10_COLUMN, item.getPM10() );
        cv.put(PM25_COLUMN, item.getPM25());
        cv.put(NO2_COLUMN, item.getNO2());
        cv.put(NOX_COLUMN, item.getNOx() );
        cv.put(NO_COLUMN, item.getNO() );
        cv.put(WINDSPEED_COLUMN, item.getWindSpeed() );
        cv.put(WINDDIREC_COLUMN, item.getWindDirec() );
        cv.put(PUBLISHTIME_COLUMN, item.getPublishTime() );
        cv.put(PM25_AVG_COLUMN, item.getPM25_AVG() );
        cv.put(PM10_ANG_COLUMN, item.getPM10() );
        cv.put(SO2_AVG_COLUMN, item.getSO2() );
        cv.put(LONGITUDE_COLUMN, item.getLongitude() );
        cv.put(LATITUDE_COLUMN, item.getLatitude() );
        cv.put(SITEID_COLUMN,item.getSiteId());





        // 新增一筆資料並取得編號
        // 第一個參數是表格名稱
        // 第二個參數是沒有指定欄位值的預設值
        // 第三個參數是包裝新增資料的ContentValues物件
        int id = (int)db.insert(TABLE_NAME, null, cv);

        // 回傳結果
        return id;
    }
}
