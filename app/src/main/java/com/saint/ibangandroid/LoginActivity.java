package com.saint.ibangandroid;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.saint.ibangandroid.utils.DeviceUtil;
import com.saint.ibangandroid.utils.StringUtil;
import com.saint.netlibrary.ApiWrapper;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.OnClick;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by yyx on 16/3/1.
 */
public class LoginActivity extends BangBaseActivity {

    @Bind(R.id.login_username_et)
    EditText userName;
    @Bind(R.id.login_phonecode_et)
    EditText passWord;
    @Bind(R.id.login_phonecode_btn)
    Button codeBtn;
    @Bind(R.id.login_btn)
    ImageButton loginBtn;
    @BindString(R.string.title_activity_login)
    String title;

    /**
     * 获取短信验证码
     */
    @OnClick(R.id.login_phonecode_btn) void getSmsCode(){
        final ApiWrapper wrapper = new ApiWrapper();
        Subscription subscription = wrapper.getSmsCode(userName.getText().toString().trim(),
                DeviceUtil.DEVICE_TYPE,
                DeviceUtil.getDevice(this),
                StringUtil.getMD5(userName.getText().toString().trim()+DeviceUtil.getDevice(this)))
                .subscribe(newSubscriber(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        debugLog(s);
                    }
                }));
        mCompositeSubscription.add(subscription);
    }

    @OnClick(R.id.login_btn) void login(){
        final ApiWrapper wrapper = new ApiWrapper();
        Subscription subscription = wrapper.login(userName.getText().toString().trim()
                                                    ,passWord.getText().toString().trim())
                                .subscribe(newSubscriber(new Action1<String>() {
                                    @Override
                                    public void call(String s) {
                                        debugLog("login:"+s);
                                    }
                                }));
//        测试4demo
//        Subscription subscription = wrapper.test("Helloo",100).subscribe(newSubscriber(new Action1<Demo>() {
//            @Override
//            public void call(Demo s) {
//                debugLog("test:"+s.toString());
//            }
//        }));
        mCompositeSubscription.add(subscription);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void setUpActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
    }


}
