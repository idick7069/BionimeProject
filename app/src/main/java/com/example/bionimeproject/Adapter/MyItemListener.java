package com.example.bionimeproject.Adapter;

import android.view.View;

import com.example.bionimeproject.Entities.AqiItem;

// 自定義接口
public interface MyItemListener {
    void removeItemFromDatabase(AqiItem item);
}
