package com.example.bionimeproject.Adapter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.bionimeproject.Entities.AqiItem;
import com.example.bionimeproject.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        if(itemClickListener!=null)
        {
            Log.d("選取",mData.get(position).getSiteId());
            itemClickListener.removeItemFromDatabase(mData.get(position));
        }
        mData.remove(position);
        notifyItemRemoved(position);



    }

    public void setItemClickListener(MyItemListener myItemListener)
    {
        this.itemClickListener = myItemListener;
    }



}