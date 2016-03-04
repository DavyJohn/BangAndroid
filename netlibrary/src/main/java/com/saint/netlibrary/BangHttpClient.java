package com.saint.netlibrary;

import android.util.Log;

import com.saint.netlibrary.utils.ConstantUtil;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yyx on 16/3/1.
 */
public class BangHttpClient {

    private static Retrofit retrofit;
    private static APIService service;

    public static APIService getService(){
        if (service == null){
            service = getRetrofit().create(APIService.class);
        }
        return service;
    }

    private static Retrofit getRetrofit(){
        if (retrofit == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger(){

                @Override
                public void log(String message) {
                    Log.i("BangAndroidRxJava:", message);
                }
            });

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(ConstantUtil.API_HOST)
                    .addConverterFactory(MyGsonConverter.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }

        return retrofit;
    }

    /**
     * 对网络接口返回的Response进行分割操作
     *
     * @param response
     * @param <T>
     * @return
     */
    public <T> Observable<T> flatResponse(final Response<T> response) {
        return Observable.create(new Observable.OnSubscribe<T>() {

            @Override
            public void call(Subscriber<? super T> subscriber) {
                if (response.isSuccess()) {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext(response.body());
                    }
                } else {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onError(new APIException(response.code(), response.message()));
                    }
                    return;
                }

                if (!subscriber.isUnsubscribed()) {
                    subscriber.onCompleted();
                }

            }
        });
    }

    /**
     * 自定义异常，当接口返回的{@link Response#code}大于300时，需要跑出此异常
     * eg：登陆时验证码错误；参数为传递等
     */
    public static class APIException extends Exception {
        public int code;
        public String message;

        public APIException(int code, String message) {
            this.code = code;
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    final Observable.Transformer transformer = new Observable.Transformer() {
        @Override
        public Object call(Object observable) {
            return ((Observable) observable).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap(new Func1() {
                        @Override
                        public Object call(Object response) {
                            return flatResponse((Response<Object>)response);
                        }
                    })
                    ;
        }
    };

    protected <T> Observable.Transformer<Response<T>, T> applySchedulers() {
        return (Observable.Transformer<Response<T>, T>) transformer;
    }


}
