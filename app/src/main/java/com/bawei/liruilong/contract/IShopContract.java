package com.bawei.liruilong.contract;

import com.bawei.liruilong.model.bean.Bean;

/**
 * Time:2019/12/3
 * Author:天祈Aa
 * Description:
 */
public interface IShopContract {

    //m层回调p层
    interface IModelCallBack{
        void onShopSuccess(Bean bean);
        void onShopFailure(Throwable throwable);
    }

    //p层回调v层
    interface IView{
        void onShopSuccess(Bean bean);
        void onShopFailure(Throwable throwable);
    }
}
