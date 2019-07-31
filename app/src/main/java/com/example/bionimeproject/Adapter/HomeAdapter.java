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
            helper.setText(R.id.item_Status, item.getStatus());
        } else {
            helper.setText(R.id.item_Status, "無資料");
        }

    }


    /**
     * 滑動刪除功能
     **/
    @Override
    public void onItemDissmiss(int position) {


        //移除數據
        Log.d(TAG,"移除:"+position+"");
        if (itemClickListener != null && position != 0 ) {

            if(getHeaderLayoutCount()>0){
                itemClickListener.removeItemFromDatabase(mData.get(position - 1));
                mData.remove(position-1);
            }
            else{
                itemClickListener.removeItemFromDatabase(mData.get(position));
                mData.remove(position);
            }

            notifyItemRemoved(position);
        }else
        {
            removeAllHeaderView();
        }


    }

    public void setItemClickListener(ListItemListener listItemListener) {
        this.itemClickListener = listItemListener;
    }


}