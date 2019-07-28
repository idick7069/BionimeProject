package com.example.bionimeproject.Network;

import java.util.List;

public interface OnDairyListener {

    void onLoadSuccess(List<String> list);

    void onLoadError(Exception error);
}
