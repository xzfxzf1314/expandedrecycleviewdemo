package com.touch.xu.expandedrecycleviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.touch.xu.expandedrecycleviewdemo.ViewItemType;
import com.touch.xu.expandedrecycleviewdemo.viewholder.ExpandableViewHolder;
import com.touch.xu.expandedrecycleviewdemo.viewholder.NormalItemViewHolder;

import java.util.List;

/**
 * Created by zfxu on 17/7/19.
 */

public class ExpandableAdapter extends RecyclerView.Adapter<ExpandableViewHolder> {

    private List<String> mDatas;
    private final Context mContext;

    public ExpandableAdapter(Context context) {
        mContext = context;
    }

    public void setDatas(List<String> datas) {
        mDatas = datas;
    }


    @Override
    public ExpandableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ViewItemType.TYPE_NORMAL:
                return new NormalItemViewHolder(mContext, parent);
        }
        return null;
    }

    @Override
    public void onViewAttachedToWindow(ExpandableViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.onViewAttachedToWindow();
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public void onViewDetachedFromWindow(ExpandableViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.onViewDetachedFromWindow();
    }

    @Override
    public void onBindViewHolder(ExpandableViewHolder holder, int position) {
        holder.bindHolder(getData(position), position);
    }

    public String getData(int position) {
        return mDatas.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return ViewItemType.TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

}
