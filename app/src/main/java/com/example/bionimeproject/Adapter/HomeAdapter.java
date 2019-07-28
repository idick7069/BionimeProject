package com.example.bionimeproject.Adapter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.bionimeproject.Entities.AqiItem;
import com.example.bionimeproject.R;

import java.util.ArrayList;


/**
 * 主頁轉換器
 */
public class HomeAdapter extends BaseQuickAdapter<AqiItem, BaseViewHolder> implements ItemTouchHelperAdapter {


    private ArrayList data;
    private ListItemListener itemClickListener = null;

    public HomeAdapter(int layoutResId, ArrayList data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull BaseViewHolder helper, AqiItem item) {

        helper.setText(R.id.item_SiteName, item.getSiteName());
        helper.setText(R.id.item_Country, item.getCountry());
        helper.setText(R.id.item_SiteId, item.getSiteId());

        //AQI數值
        if (!item.getAQI().equals("")) {
            helper.setText(R.id.item_Aqi, item.getAQI());
        } else {
            helper.setText(R.id.item_Aqi, "無資料");
        }
    }


    /**
     * 滑動刪除功能
     **/
    @Override
    public void onItemDissmiss(int position) {
        //移除數據

        if (itemClickListener != null) {
            Log.d("選取", mData.get(position - 1).getSiteId());
            itemClickListener.removeItemFromDatabase(mData.get(position - 1));
        }
        mData.remove(position - 1);
        notifyItemRemoved(position);


    }

    public void setItemClickListener(ListItemListener listItemListener) {
        this.itemClickListener = listItemListener;
    }


}