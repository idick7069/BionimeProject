package com.example.bionimeproject.Model;


/**
 * Created by Frank on 2018/2/10.
 */


import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * SQLite處理Helper
 * */
public class DBHelper extends SQLiteOpenHelper {
    //宣告
    private static final String TAG = DBHelper.class.getSimpleName();
    //Json Resources
    private Resources mResources;
    // 資料庫名稱
    public static final String DATABASE_NAME = "mydata.db";
    // 資料庫版本，資料結構改變的時候要更改這個數字，通常是加一
    public static final int VERSION = 2;
    // 資料庫物件，固定的欄位變數
    private static SQLiteDatabase database;

    Context context;

    // 建構子，在一般的應用都不需要修改
    public DBHelper(Context context, String name, CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
        //建立
        mResources = context.getResources();
    }

    // 需要資料庫的元件呼叫這個方法，這個方法在一般的應用都不需要修改
    public static SQLiteDatabase getDatabase(Context context) {
        if (database == null || !database.isOpen()) {
            database = new DBHelper(context, DATABASE_NAME,
                    null, VERSION).getWritableDatabase();
        }

        return database;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 建立應用程式需要的表格
        // 待會再回來完成它
        db.execSQL(AqiModel.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 刪除原有的表格
        // 待會再回來完成它
        // 呼叫onCreate建立新版的表格
        db.execSQL("DROP TABLE IF EXISTS " +AqiModel.TABLE_NAME);
        // 呼叫onCreate建立新版的表格
        onCreate(db);
    }

}