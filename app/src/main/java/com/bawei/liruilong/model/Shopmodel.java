package com.bawei.liruilong.model;

import com.bawei.liruilong.contract.IShopContract;
import com.bawei.liruilong.model.bean.Bean;
import com.bawei.liruilong.util.NetUtil;
import com.google.gson.Gson;

/**
 * Time:2019/12/3
 * Author:天祈Aa
 * Description:
 */
public class Shopmodel {
    public void getShopData(final IShopContract.IModelCallBack iModelCallBack){
        //model层获取数据
        NetUtil.getInstance().getJson("http://blog.zhaoliang5156.cn/api/mall/mall.json", new NetUtil.MyCallBack() {
            @Override
            public void getjson(String json) {
                //成功获取数据
                Bean bean = new Gson().fromJson(json, Bean.class);
                iModelCallBack.onShopSuccess(bean);
            }

            @Override
            public void error(Throwable throwable) {
                //失败报错
                iModelCallBack.onShopFailure(throwable);
            }
        });
    }
}
