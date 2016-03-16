package com.saint.netlibrary;

import com.saint.netlibrary.model.Demo;
import com.saint.netlibrary.model.DemoPerson;

import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
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

    //demoPost
    @FormUrlEncoded
    @POST("test")
    Observable<Response<DemoPerson>> test4(@Field("name")String name ,@Field("age") int age);



    @GET("test/echo{?message}")
    Observable<Response<String>> DemoGet(@Query("message")String message);

    @GET("test/{id}")
    Observable<Response<String>> DemoGet1(@Path("id")String id);
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
