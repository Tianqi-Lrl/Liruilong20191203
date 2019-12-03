package com.bawei.liruilong.view.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.bawei.liruilong.R;
import com.bawei.liruilong.base.BaseFragment;
import com.bawei.liruilong.contract.IShopContract;
import com.bawei.liruilong.model.bean.Bean;
import com.bawei.liruilong.presenter.ShopPresenter;
import com.bawei.liruilong.view.activity.MainActivity;
import com.bawei.liruilong.view.adapter.MyAdapter;

import java.util.List;

/**
 * Time:2019/12/3
 * Author:天祈Aa
 * Description:
 */
public class ShopFragment extends BaseFragment implements IShopContract.IView {

    private GridView gv;
    private Button bb;

    @Override
    protected void initView(View view) {
        //找控件
        gv = view.findViewById(R.id.gv);
        bb = view.findViewById(R.id.bb);
        //点击跳转
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.ToHomePage();
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_shop;
    }

    @Override
    protected void initData() {
        //实例化对象
        //调用方法
        ShopPresenter shopPresenter = new ShopPresenter();
        shopPresenter.getShopData(this);
    }

    @Override
    public void onShopSuccess(Bean bean) {
        Toast.makeText(getContext(), "成功", Toast.LENGTH_SHORT).show();
        //设置适配器
        List<Bean.ShopGridDataBean> shopGridData = bean.getShopGridData();
        gv.setAdapter(new MyAdapter(shopGridData));
    }

    @Override
    public void onShopFailure(Throwable throwable) {
        Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();
    }
}
