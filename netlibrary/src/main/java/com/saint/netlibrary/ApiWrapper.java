package com.saint.netlibrary;


import com.saint.netlibrary.model.Demo;

import rx.Observable;

/**
 * Created by yyx on 16/3/1.
 */
public class ApiWrapper extends BangHttpClient {

    /*************测试块*************/
    /**
     * 基本测试4
     * @return
     */
    public Observable<Demo> test(String name,int age){
        return getService().test(name,age)
                .compose(this.<Demo>applySchedulers());
    }

    /*************测试块*************/

    /**
     * 获取短信验证码接口
     * @param phone
     * @param device
     * @param device_token
     * @param sign
     * @return
     */
    public Observable<String> getSmsCode(String phone,String device,String device_token,String sign){
        return getService().getSmsCode(phone,device,device_token,sign)
                .compose(this.<String>applySchedulers());
    }


    /**
     * 登陆接口
     * @param userName
     * @param password
     * @return
     */
    public Observable<String> login(String userName,String password){
        return getService().login(userName,password)
                .compose(this.<String>applySchedulers());
    }
}
