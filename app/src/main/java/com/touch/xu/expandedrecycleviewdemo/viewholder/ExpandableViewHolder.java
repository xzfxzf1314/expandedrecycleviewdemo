package com.touch.xu.expandedrecycleviewdemo.viewholder;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by zfxu on 17/7/19.
 */

public abstract class ExpandableViewHolder<T> extends RecyclerView.ViewHolder {

    protected T mCurrentData;
    protected int mPosition;
    protected Context mContext;

    public ExpandableViewHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        initView();
    }

    protected final View findViewByID(@IdRes int id) {
        return this.itemView.findViewById(id);
    }

    protected String getString(@StringRes int id) {
        return mContext.getResources().getString(id);
    }

    protected int getColor(@ColorRes int id) {
        return mContext.getResources().getColor(id);
    }

    protected abstract void initView();

    public abstract void bindHolder(T t, int position);

    public void onViewDetachedFromWindow() {
        //TODO
    }

    public void onViewAttachedToWindow() {
        //TODO
    }
}
