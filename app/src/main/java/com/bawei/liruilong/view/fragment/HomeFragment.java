package com.bawei.liruilong.view.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.bawei.liruilong.R;
import com.bawei.liruilong.base.BaseFragment;
import com.bawei.liruilong.util.NetUtil;
import com.bawei.liruilong.view.activity.MainActivity;

/**
 * Time:2019/12/3
 * Author:天祈Aa
 * Description:
 */
public class HomeFragment extends BaseFragment {

    private TextView tv;
    private RelativeLayout rl;
    private Button b;

    @Override
    protected void initView(View view) {
        tv = view.findViewById(R.id.tv);
        rl = view.findViewById(R.id.rl);
        b = view.findViewById(R.id.b);

        //点击切换页面
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.ToShopPage();
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        //有网文本无网图片
        if (NetUtil.getInstance().HasNet(getContext())){
            tv.setVisibility(View.VISIBLE);
            rl.setVisibility(View.GONE);
        }else {
            tv.setVisibility(View.GONE);
            rl.setVisibility(View.VISIBLE);
        }
    }
}
