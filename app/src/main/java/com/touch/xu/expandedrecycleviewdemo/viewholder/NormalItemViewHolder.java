package com.touch.xu.expandedrecycleviewdemo.viewholder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.touch.xu.expandedrecycleviewdemo.R;

/**
 * Created by zfxu on 17/7/19.
 */

public class NormalItemViewHolder extends ExpandableViewHolder<String> {

    private static final String TAG = "NormalItemViewHolder";
    private TextView mTextView;
    private RelativeLayout mBottomRelativeLayout;
    private TextView mExpandableView;
    private int mHiddenViewMeasuredHeight;

    private ValueAnimator mOpenValueAnimator;
    private ValueAnimator mCloseValueAnimator;

    public NormalItemViewHolder(Context context, ViewGroup parent) {
        super(context, LayoutInflater.from(context).inflate(R.layout.item_normal, parent, false));
        mHiddenViewMeasuredHeight = (int) context.getResources().getDimension(R.dimen.dp_40);
    }

    @Override
    protected void initView() {
        mTextView = (TextView) findViewByID(R.id.id_textView);
        mBottomRelativeLayout = (RelativeLayout) findViewByID(R.id.id_top);
        mExpandableView = (TextView) findViewByID(R.id.id_expand_view);
        mBottomRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mExpandableView.getVisibility() == View.VISIBLE) {
                    animClose(mExpandableView);
                } else {
                    animOpen(mExpandableView);
                }
            }
        });
    }

    @Override
    public void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        if (mOpenValueAnimator != null) {
            mOpenValueAnimator.removeAllUpdateListeners();
        }
        if (mCloseValueAnimator != null) {
            mCloseValueAnimator.removeAllUpdateListeners();
        }
    }

    private void animOpen(final View view){
        view.setVisibility(View.VISIBLE);
        view.setAlpha(0);
        if (mOpenValueAnimator == null) {
            mOpenValueAnimator = createDropAnim(view,0, mHiddenViewMeasuredHeight);
        }
        mOpenValueAnimator.start();
    }

    private void animClose(final View view){
        int origHeight = view.getHeight();
        view.setAlpha(1);
        if (mCloseValueAnimator == null) {
            mCloseValueAnimator = createDropAnim(view, origHeight, 0);
            mCloseValueAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    view.setVisibility(View.GONE);
                }
            });
        }
        mCloseValueAnimator.start();
    }

    /**
     * 使用动画的方式来改变高度解决visible不一闪而过出现
     * @param view
     * @param start 初始状态值
     * @param end 结束状态值
     * @return
     */
    private ValueAnimator createDropAnim(final  View view,int start,int end) {
        final ValueAnimator va = ValueAnimator.ofInt(start, end);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();//根据时间因子的变化系数进行设置高度
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = value;

                float alpha = ((float)value) / mHiddenViewMeasuredHeight;
                view.setAlpha(alpha);

                view.setLayoutParams(layoutParams);//设置高度
            }
        });
        return  va;
    }

    @Override
    public void bindHolder(String data, int position) {
        mCurrentData = data;
        mPosition = position;

        mTextView.setText(data);
    }
}
