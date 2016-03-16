package com.saint.netlibrary;


import com.saint.netlibrary.model.Demo;
import com.saint.netlibrary.model.DemoPerson;

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
    //demoPost
    public Observable<DemoPerson> test4(String name,int age){
        return getService().test4(name, age)
                .compose(this.<DemoPerson>applySchedulers());
    }
    //demoGet
    public Observable<String> DemoGet(String message){
        return getService().DemoGet(message)
                .compose(this.<String>applySchedulers());

    }
    //demoGet1
    public Observable<String> DemoGet1(String  id){
        return getService().DemoGet1(id)
                .compose(this.<String >applySchedulers());
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
