package com.bawei.liruilong.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.liruilong.R;
import com.bawei.liruilong.model.bean.Bean;
import com.bawei.liruilong.util.NetUtil;

import java.util.List;

/**
 * Time:2019/12/3
 * Author:天祈Aa
 * Description:
 */
public class MyAdapter extends BaseAdapter {
    List<Bean.ShopGridDataBean> list;

    public MyAdapter(List<Bean.ShopGridDataBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (view==null){
            //加载布局
            view=View.inflate(viewGroup.getContext(), R.layout.show,null);
            viewHolder=new ViewHolder();
            viewHolder.imageView=view.findViewById(R.id.iv);
            viewHolder.textView1=view.findViewById(R.id.tv1);
            viewHolder.textView2=view.findViewById(R.id.tv2);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        //根据位置获取对象
        Bean.ShopGridDataBean shopGridDataBean = list.get(i);
        //设置数据
        viewHolder.textView1.setText(shopGridDataBean.getTitle());
        viewHolder.textView2.setText(shopGridDataBean.getPrice());
        NetUtil.getInstance().getPhoto(shopGridDataBean.getImageurl(),viewHolder.imageView);

        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView1,textView2;
    }
}
