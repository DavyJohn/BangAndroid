package com.saint.ibangandroid.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.saint.ibangandroid.BangBaseActivity;
import com.saint.ibangandroid.LoginActivity;
import com.saint.ibangandroid.R;

import butterknife.Bind;

/**
 * Created by zzh on 16-3-14.
 */
public class BangSplash extends BangBaseActivity {
    @Bind(R.id.bangsplash) ImageView bangsplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bangsplash);
        getSupportActionBar().hide();
        AlphaAnimation animation=new AlphaAnimation(0.3f,1.0f);
        animation.setDuration(3000);
        bangsplash.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                bangsplash.setImageResource(R.drawable.bangsplash);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent=new Intent(BangSplash.this, LoginActivity.class);
                startActivity(intent);
                //进入动画和退出动画
                overridePendingTransition(R.anim.push_left_in,
                        R.anim.push_left_out);
                BangSplash.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });




    }

    @Override
    protected void setUpActionBar() {

    }
}
