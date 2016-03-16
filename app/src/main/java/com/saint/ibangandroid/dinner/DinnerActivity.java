package com.saint.ibangandroid.dinner;

import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saint.ibangandroid.R;
import com.saint.ibangandroid.dinner.dinnerfargment.HomeDinnder;
import com.saint.ibangandroid.main.mainfragment.OrderFragment;
import com.saint.ibangandroid.main.mainfragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zzh on 16-3-16.
 */
public class DinnerActivity extends FragmentActivity {


    @Bind(R.id.vpager)
    ViewPager mViewPager;
    //首页
    @Bind(R.id.homepager)
    LinearLayout mHomeLayout;
    @OnClick(R.id.homepager) void setHome(){
        setTab(0);
        mViewPager.setCurrentItem(0);
    }
    @Bind(R.id.home_image)
    ImageView mHomeImage;
    @Bind(R.id.home_text)
    TextView mHomeText;
    //订单
    @Bind(R.id.order)
    LinearLayout mOrderLayout;
    @OnClick(R.id.order) void setOrder(){
        setTab(1);
        mViewPager.setCurrentItem(1);
    }
    @Bind(R.id.order_image)
    ImageView mOrderImage;
    @Bind(R.id.order_text)
    TextView mOrderText;
    //我的
    @Bind(R.id.user)
    LinearLayout mUserLayout;
    @OnClick(R.id.user) void setOur(){
        setTab(2);
        mViewPager.setCurrentItem(2);
    }
    @Bind(R.id.user_image)
    ImageView mUserImage;
    @Bind(R.id.user_text)
    TextView mUserText;

    private FragmentManager fragmentManager=getFragmentManager();
    private List<Fragment> list=new ArrayList<>();
    private FragmentPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        android.support.v4.app.Fragment homePager=new HomeDinnder();
        android.support.v4.app.Fragment order=new OrderFragment();
        android.support.v4.app.Fragment user=new UserFragment();
        list.add(homePager);
        list.add(order);
        list.add(user);

        adapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        };

        mViewPager.setAdapter(adapter);
        setTab(0);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int num=mViewPager.getCurrentItem();
                setTab(num);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void clean(){
        mHomeImage.setImageResource(R.drawable.homepage_nor);
        mOrderImage.setImageResource(R.drawable.ordericon_nor);
        mUserImage.setImageResource(R.drawable.usericon_nor);
        mHomeText.setTextColor(Color.rgb(151, 151, 151));
        mOrderText.setTextColor(Color.rgb(151, 151, 151));
        mUserText.setTextColor(Color.rgb(151, 151, 151));

    }
    private void setTab(int index){
        clean();
        switch (index){
            case 0:
                mHomeImage.setImageResource(R.drawable.homepage_sel);
                mHomeText.setTextColor(Color.rgb(105, 198, 180));
                break;
            case 1:
                mOrderImage.setImageResource(R.drawable.ordericon_sel);
                mOrderText.setTextColor(Color.rgb(105, 198, 180));
                break;
            case 2:
                mUserImage.setImageResource(R.drawable.usericon_sel);
                mUserText.setTextColor(Color.rgb(105, 198, 180));
                break;
        }
    }

}
