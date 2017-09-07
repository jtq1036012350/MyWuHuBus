package com.marsjiang.mywuhubus.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.google.gson.Gson;
import com.marsjiang.mywuhubus.MyApplication;
import com.marsjiang.mywuhubus.R;
import com.marsjiang.mywuhubus.beans.SearchLineWithBusNum;
import com.marsjiang.mywuhubus.databinding.ActivityMainBinding;
import com.marsjiang.mywuhubus.ui.base.BaseActivity;
import com.marsjiang.mywuhubus.utils.LogUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;
    private ArrayList<Integer> imageLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initDatas();
        initViews();
    }

    /**
     * 初始化数据
     */
    private void initDatas() {
        imageLists = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            imageLists.add(R.mipmap.wuhu);
            imageLists.add(R.mipmap.wuhu1);
            imageLists.add(R.mipmap.wuhu2);
        }
    }

    /**
     * 初始化布局
     */
    private void initViews() {
        binding.setTitle("首页");
        initSliders();
    }

    /**
     * 初始化轮播器
     */
    private void initSliders() {
        binding.sliderView.removeAllSliders();
        for (int i = 0; i < imageLists.size(); i++) {
//            DefaultSliderView：只有图片，没有文字描述
//            TextSliderView：有图片，有文字描述
            DefaultSliderView textSliderView = new DefaultSliderView(MyApplication.getContext());
            textSliderView.image(imageLists.get(i));
//            textSliderView.description(videoList.get(i));
            textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {

                }
            });
            binding.sliderView.addSlider(textSliderView);
        }

        binding.sliderView.setPresetTransformer(SliderLayout.Transformer.Tablet);
        binding.sliderView.setCustomAnimation(new DescriptionAnimation());
        binding.sliderView.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);

        SearchLineWithBusNum searchLineWithBusNum = new SearchLineWithBusNum();
        SearchLineWithBusNum.Params params = searchLineWithBusNum.new Params("56路");
        searchLineWithBusNum.setCmd("lineDetail");
        searchLineWithBusNum.setParams(params);

        String url = "http://220.180.139.42:8980/SmartBusServer/Main";
        OkHttpUtils
                .postString()
                .url(url)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .content(new Gson().toJson(searchLineWithBusNum))
                .build()
                .execute(new MyStringCallback());
    }

    public class MyStringCallback extends StringCallback {
        @Override
        public void onBefore(Request request, int id) {
            setTitle("loading...");
        }

        @Override
        public void onAfter(int id) {
            setTitle("Sample-okHttp");
        }

        @Override
        public void onError(Call call, Exception e, int id) {
            e.printStackTrace();
        }

        @Override
        public void onResponse(String response, int id) {
            LogUtil.e("Tag", "onResponse：complete");

            switch (id) {
                case 100:
                    Toast.makeText(MainActivity.this, "http", Toast.LENGTH_SHORT).show();
                    break;
                case 101:
                    Toast.makeText(MainActivity.this, "https", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public void inProgress(float progress, long total, int id) {
            LogUtil.e("Tag", "inProgress:" + progress);
        }
    }
}
