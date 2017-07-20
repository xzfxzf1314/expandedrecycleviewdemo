package com.touch.xu.expandedrecycleviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.touch.xu.expandedrecycleviewdemo.adapter.ExpandableAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExpandableAdapter mExpandableAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private int mSpacingInPixels;
    private RecycleViewDivider mRecycleViewDivider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        List<String> datas = new ArrayList<>();
        datas.add("啦啦啦啦啦啦....");
        datas.add("啦啦啦啦啦啦");
        datas.add("啦啦啦啦啦啦....");
        datas.add("啦啦啦啦啦啦....");
        datas.add("啦啦啦啦啦啦....");
        datas.add("啦啦啦啦啦啦....");

        mExpandableAdapter = new ExpandableAdapter(this);
        mExpandableAdapter.setDatas(datas);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recycleview);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mSpacingInPixels = getResources().getDimensionPixelSize(R.dimen.dp_10);
        mRecycleViewDivider = new RecycleViewDivider(this, LinearLayoutManager.VERTICAL, mSpacingInPixels, Color.BLACK);
        mRecyclerView.addItemDecoration(mRecycleViewDivider);

        mRecyclerView.setAdapter(mExpandableAdapter);
        mExpandableAdapter.notifyDataSetChanged();
    }
}
