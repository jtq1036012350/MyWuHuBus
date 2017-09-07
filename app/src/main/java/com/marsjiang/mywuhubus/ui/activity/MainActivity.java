package com.marsjiang.mywuhubus.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.marsjiang.mywuhubus.R;
import com.marsjiang.mywuhubus.databinding.ActivityMainBinding;
import com.marsjiang.mywuhubus.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initViews();
        initDatas();
    }

    /**
     * 初始化数据
     */
    private void initDatas() {

    }

    /**
     * 初始化布局
     */
    private void initViews() {
        binding.setTitle("首页");
    }
}
