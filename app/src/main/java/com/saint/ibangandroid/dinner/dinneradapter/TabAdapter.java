package com.saint.ibangandroid.dinner.dinneradapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.saint.ibangandroid.dinner.dinnerfargment.TabFragment;
import com.saint.ibangandroid.utils.Date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Created by zzh on 16-3-14.
 */
public class TabAdapter extends FragmentPagerAdapter {
    private Date date;
    private List<Date> list=new ArrayList<>();
    public static String[] TITLES = new String[]
            { "周一", "周二", "周三", "周四", "周五","周六","周日" };

    public TabAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int postion)
    {
        Date();
        TabFragment fragment = new TabFragment(postion);
        Bundle args=new Bundle();
        args.putString("arg", String.valueOf(list.get(postion)));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return String.valueOf(list.get(position));
    }
    private void Date(){
        SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd");
        Calendar calendar=Calendar.getInstance();
        date.setDate1(dateFormat.format(calendar.getTime()));
        Log.e("今天:", dateFormat.format(calendar.getTime()));
        calendar.roll(Calendar.DAY_OF_YEAR, 1);
        date.setDate2(dateFormat.format(calendar.getTime()));

        Log.e("明天：", dateFormat.format(calendar.getTime()));
        calendar.roll(Calendar.DAY_OF_YEAR, 2);
        date.setDate3(dateFormat.format(calendar.getTime()));

        calendar.roll(Calendar.DAY_OF_YEAR, 3);
        date.setDate4(dateFormat.format(calendar.getTime()));

        calendar.roll(Calendar.DAY_OF_YEAR, 4);
        date.setDate5(dateFormat.format(calendar.getTime()));

        list.add(date);
    }

}
