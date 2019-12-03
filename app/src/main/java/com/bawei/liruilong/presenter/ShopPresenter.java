package com.bawei.liruilong.presenter;

import com.bawei.liruilong.contract.IShopContract;
import com.bawei.liruilong.model.Shopmodel;
import com.bawei.liruilong.model.bean.Bean;

/**
 * Time:2019/12/3
 * Author:天祈Aa
 * Description:
 */
public class ShopPresenter {
    public void getShopData(final IShopContract.IView iView){
        //p层调用m层
        //实例化对象
        Shopmodel shopmodel = new Shopmodel();
        //调用方法
        shopmodel.getShopData(new IShopContract.IModelCallBack() {
            @Override
            public void onShopSuccess(Bean bean) {
                //成功
                iView.onShopSuccess(bean);
            }

            @Override
            public void onShopFailure(Throwable throwable) {
                //失败
                iView.onShopFailure(throwable);
            }
        });
    }
}
