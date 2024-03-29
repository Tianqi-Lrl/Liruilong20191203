package com.bawei.liruilong.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bawei.liruilong.R;
import com.bawei.liruilong.base.BaseActivity;
import com.bawei.liruilong.view.fragment.HomeFragment;
import com.bawei.liruilong.view.fragment.MyFragment;
import com.bawei.liruilong.view.fragment.ShopFragment;

import java.util.ArrayList;
/**
 *@date:2019/12/3
 *@author:天祈
 *@description
 */
public class MainActivity extends BaseActivity {


    private ViewPager vp;
    private RadioGroup rg;
    ArrayList<Fragment> list=new ArrayList<>();

    @Override
    protected void initData() {
        //添加fragment
        list.add(new HomeFragment());
        list.add(new ShopFragment());
        list.add(new MyFragment());

        //设置适配器
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    @Override
    protected void initView() {
        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);

        //联动
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb1:

                        vp.setCurrentItem(0);

                        break;
                    case R.id.rb2:

                        vp.setCurrentItem(1);

                        break;
                    case R.id.rb3:

                        vp.setCurrentItem(2);

                        break;

                }
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
    public void ToShopPage(){
        vp.setCurrentItem(1);
    }
    public void ToHomePage(){
        vp.setCurrentItem(0);
    }
}
