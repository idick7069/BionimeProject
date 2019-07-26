package com.example.bionimeproject.Adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.bionimeproject.Entities.AqiItem;
import com.example.bionimeproject.R;

import java.util.ArrayList;

public class HomeAdapter extends BaseQuickAdapter<AqiItem, BaseViewHolder> {
    public HomeAdapter(int layoutResId, ArrayList data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, AqiItem item) {
        helper.setText(R.id.item_SiteName, item.getSiteName());
        helper.setText(R.id.item_Country, item.getCountry());
//        helper.setImageResource(R.id.icon, item.getImageResource());
//        // 加载网络图片
//        Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
    }
}