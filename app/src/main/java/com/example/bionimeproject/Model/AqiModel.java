package com.example.bionimeproject.Model;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

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
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
//                    SITEID_COLUMN + " INTEGER , " +
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
                    LATITUDE_COLUMN + " TEXT, "+
                    SITEID_COLUMN + " INTEGER )";
//                    LATITUDE_COLUMN + " TEXT )";





    // 資料庫物件
    private SQLiteDatabase db;

    // 建構子，一般的應用都不需要修改
    public AqiModel(Context context) {
        db = DBHelper.getDatabase(context);
    }


    // 關閉資料庫，一般的應用都不需要修改
    public void close() {
        db.close();
    }

    @Override
    public ArrayList<AqiItem> getListFromDatabase() {

        ArrayList<AqiItem> result = new ArrayList<>();
        Cursor cursor = db.query(
                TABLE_NAME, null, null, null, null, null, SITEID_COLUMN, null);

        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }

        cursor.close();
        return result;
    }

    //獲取資料回傳物件
    private AqiItem getRecord(Cursor cursor){
        AqiItem aqiItem = new AqiItem();
        aqiItem.setSiteName(cursor.getString(1));
        aqiItem.setCountry(cursor.getString(2));
        aqiItem.setAQI(cursor.getString(3));
        aqiItem.setPollutant(cursor.getString(4));
        aqiItem.setStatus(cursor.getString(5));
        aqiItem.setSO2(cursor.getString(6));
        aqiItem.setCO(cursor.getString(7));
        aqiItem.setCO_8hr(cursor.getString(8));
        aqiItem.setO3(cursor.getString(9));
        aqiItem.setO3_8h(cursor.getString(10));
        aqiItem.setPM10(cursor.getString(11));
        aqiItem.setPM25(cursor.getString(12));
        aqiItem.setNO2(cursor.getString(13));
        aqiItem.setNOx(cursor.getString(14));
        aqiItem.setNO(cursor.getString(15));
        aqiItem.setWindSpeed(cursor.getString(16));
        aqiItem.setWindDirec(cursor.getString(17));
        aqiItem.setPublishTime(cursor.getString(18));
        aqiItem.setPM25_AVG(cursor.getString(19));
        aqiItem.setPM10_AVG(cursor.getString(20));
        aqiItem.setSO2_AVG(cursor.getString(21));
        aqiItem.setLongitude(cursor.getString(22));
        aqiItem.setLatitude(cursor.getString(23));
        aqiItem.setSiteId(cursor.getInt(24)+"");

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

    // 修改參數指定的物件
    public boolean update(AqiItem item) {
        // 建立準備修改資料的ContentValues物件
        ContentValues cv = new ContentValues();

        // 加入ContentValues物件包裝的修改資料
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
//        cv.put(SITEID_COLUMN,item.getSiteId());


        // 設定修改資料的條件為編號
        // 格式為「欄位名稱＝資料」
        String where = SITEID_COLUMN + "=" + item.getSiteId();

        // 執行修改資料並回傳修改的資料數量是否成功
        return db.update(TABLE_NAME, cv, where, null) > 0;
    }

    // 取得指定編號的資料物件
    public AqiItem get(int id) {
        // 準備回傳結果用的物件
        AqiItem item = null;
        // 使用編號為查詢條件
        String where = SITEID_COLUMN + "=" + id;
        // 執行查詢
        Cursor result = db.query(
                TABLE_NAME, null, where, null, null, null, null, null);
        // 如果有查詢結果
        if (result.moveToFirst()) {
            // 讀取包裝一筆資料的物件
            item = getRecord(result);
        }

        // 關閉Cursor物件
        result.close();
        // 回傳結果
        return item;
    }

    //確認是否存在於資料庫
    public boolean ifExist(int id) {
        // 準備回傳結果用的物件
        String Query = "Select * from " + TABLE_NAME + " where " + SITEID_COLUMN + " = " + id;
        Cursor cursor = db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    // 刪除參數指定編號的資料
    public boolean delete(int id){
        // 設定條件為編號，格式為「欄位名稱=資料」

        String where = SITEID_COLUMN + " = " + id;
        // 刪除指定編號資料並回傳刪除是否成功
        return db.delete(TABLE_NAME, where , null) > 0;
    }

}
