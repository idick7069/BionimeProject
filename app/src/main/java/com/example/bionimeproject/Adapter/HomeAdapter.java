package com.example.bionimeproject.Adapter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.bionimeproject.Entities.AqiItem;
import com.example.bionimeproject.R;

import java.util.ArrayList;
import java.util.Collections;

public class HomeAdapter extends BaseQuickAdapter<AqiItem, BaseViewHolder> implements ItemTouchHelperAdapter{

    //数据
    private  ArrayList data;
    private MyItemListener itemClickListener = null;
    public HomeAdapter(int layoutResId, ArrayList data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, AqiItem item) {
        helper.setText(R.id.item_SiteName, item.getSiteName());
        helper.setText(R.id.item_Country, item.getCountry());
        helper.setText(R.id.item_SiteId,item.getSiteId());
//        helper.setImageResource(R.id.icon, item.getImageResource());
//        // 加载网络图片
//        Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
    }
    /**
     * 滑動刪除功能
     * **/
    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        //交換位置
        Collections.swap(mData,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDissmiss(int position) {
        //移除數據
        mData.remove(position);
        notifyItemRemoved(position);
        if(itemClickListener!=null)
        {
            itemClickListener.removeItemFromDatabase(position);
        }

    }

    public void setItemClickListener(MyItemListener myItemListener)
    {
        this.itemClickListener = myItemListener;
    }



}