package com.saint.ibangandroid.dinner;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.saint.ibangandroid.R;
import com.saint.ibangandroid.dinner.dinneradapter.TabAdapter;
import com.saint.ibangandroid.dinner.dinnerfargment.NightFragment;
import com.saint.ibangandroid.dinner.dinnerfargment.NoonFragment;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zzh on 16-3-3.
 *
 *
 */
public class Appointment extends FragmentActivity implements View.OnClickListener {
    private NoonFragment noonFragment;
    private NightFragment nightFragment;

    @Bind(R.id.viewpager)
    ViewPager pager;
    @Bind(R.id.indicator)
    TabPageIndicator indicator;
    private List<Fragment> list = new ArrayList<>();
    private TabAdapter adapter;


    private FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment_main);
        ButterKnife.bind(this);
        adapter = new TabAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        indicator.setViewPager(pager,0);
    }

    @Override
    public void onClick(View v) {

    }
}
