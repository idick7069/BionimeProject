package com.example.bionimeproject.Adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.bionimeproject.R;

import java.util.List;

public class HeaderAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public HeaderAdapter(int layoutResId, List<String> list) {
        super(layoutResId,list);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        helper.setText(R.id.chiText,item);
        helper.setText(R.id.engText,item);
    }
}
