package com.example.bionimeproject.Adapter;

import android.view.View;

import com.example.bionimeproject.Entities.AqiItem;

/**
 *  清單項目數值接口
 * */
public interface ListItemListener {
    //刪除資料用
    void removeItemFromDatabase(AqiItem item);
}
