package com.saint.ibangandroid.dinner.dinnerfargment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saint.ibangandroid.R;
import com.saint.ibangandroid.dinner.dinneradapter.TabAdapter;


@SuppressLint("ValidFragment")
public class TabFragment extends Fragment
{
	private int pos;


	@SuppressLint("ValidFragment")
	public TabFragment(int pos)
	{
		this.pos = pos;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.tabcontent, container, false);
		TextView tv = (TextView) view.findViewById(R.id.text_vv);
		tv.setText(TabAdapter.TITLES[pos]);
		return view;
	}
//	private void Date(){
//		SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd");
//		Calendar calendar=Calendar.getInstance();
//		date.setDate1(dateFormat.format(calendar.getTime()));
//		Log.e("今天:", dateFormat.format(calendar.getTime()));
//		calendar.roll(Calendar.DAY_OF_YEAR, 1);
//		date.setDate2(dateFormat.format(calendar.getTime()));
//
//		Log.e("明天：", dateFormat.format(calendar.getTime()));
//		calendar.roll(Calendar.DAY_OF_YEAR, 2);
//		date.setDate3(dateFormat.format(calendar.getTime()));
//
//		calendar.roll(Calendar.DAY_OF_YEAR, 3);
//		date.setDate4(dateFormat.format(calendar.getTime()));
//
//		calendar.roll(Calendar.DAY_OF_YEAR, 4);
//		date.setDate5(dateFormat.format(calendar.getTime()));
//
//		list.add(date);
//	}

}
