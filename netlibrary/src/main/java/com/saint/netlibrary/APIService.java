package com.saint.netlibrary;

import com.saint.netlibrary.model.Demo;

import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by yyx on 16/3/1.
 */
public interface APIService {

    /*************测试块*************/
    /**
     * 基本测试4
     * @return
     */
    @FormUrlEncoded
    @POST("test")
    Observable<Response<Demo>> test(@Field("name") String name,@Field("age") int age);

    /*************测试块*************/

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("auth/login")
    Observable<Response<String>> login(@Field("username") String username,@Field("password") String password);

    /**
     * 获取短信验证码
     * @param phone
     * @param device
     * @param device_token
     * @param sign
     * @return
     */
    @FormUrlEncoded
    @POST("auth/captcha")
    Observable<Response<String>> getSmsCode(@Field("phone") String phone,
                                            @Field("device") String device,
                                            @Field("device_token") String device_token,
                                            @Field("sign") String sign);


}
