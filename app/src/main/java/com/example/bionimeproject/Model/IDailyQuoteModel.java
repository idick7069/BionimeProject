package com.example.bionimeproject.Model;

import com.example.bionimeproject.Network.OnDairyListener;

public interface IDailyQuoteModel {
    void getData(String url, final OnDairyListener listener);
}
