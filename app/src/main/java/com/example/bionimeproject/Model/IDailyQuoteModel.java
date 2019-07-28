package com.example.bionimeproject.Model;

import com.example.bionimeproject.Network.OnDairyListener;

/**
 * 每日一句獲取資料接口
 * */
public interface IDailyQuoteModel {
    void getData(String url, final OnDairyListener listener);
}
