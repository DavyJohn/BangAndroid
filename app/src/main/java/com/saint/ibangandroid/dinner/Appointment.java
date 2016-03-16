package com.saint.ibangandroid.dinner;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.saint.ibangandroid.R;
import com.saint.ibangandroid.dinner.dinnerfargment.NightFragment;
import com.saint.ibangandroid.dinner.dinnerfargment.NoonFragment;

import butterknife.ButterKnife;

/**
 * Created by zzh on 16-3-3.
 *
 *
 */
public class Appointment extends Activity implements View.OnClickListener{
    private NoonFragment noonFragment;
    private NightFragment nightFragment;
    private RelativeLayout reNight,reNoon;
    private TextView noText,ngText;
    private ImageView noImage,ngImage;
    private View noLIne,ngLine;

//    @Bind(R.id.tabhost)TabHost tabHost;
//    @Bind(R.id.night) RelativeLayout reNight;
//    @OnClick(R.id.night) void OnClickNight(){
//        Toast.makeText(this,"点击night",Toast.LENGTH_SHORT).show();
//        SetTabSelection(1);
//    }
//    @Bind(R.id.noon) RelativeLayout reNoon;
//    @OnClick(R.id.noon) void OnClickNoon(){
//        Toast.makeText(this, "点击noon", Toast.LENGTH_SHORT).show();
//        SetTabSelection(0);
//    }
//    @Bind(R.id.noon_text)
//    TextView noText;
//    @Bind(R.id.night_text)
//    TextView ngText;
//    @Bind(R.id.noon_image)
//    ImageView noImage;
//    @Bind(R.id.night_image)
//    ImageView ngImage;



    private FragmentManager fragmentManager=getFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment_main);
        ButterKnife.bind(this);
        noImage= (ImageView) findViewById(R.id.noon_image);
        ngImage= (ImageView) findViewById(R.id.night_image);
        noText= (TextView) findViewById(R.id.noon_text);
        ngText= (TextView) findViewById(R.id.night_text);
        reNight= (RelativeLayout) findViewById(R.id.night);
        reNoon= (RelativeLayout) findViewById(R.id.noon);
        noLIne=findViewById(R.id.noLine);
        ngLine=findViewById(R.id.ngLine);
        reNoon.setOnClickListener(this);
        reNight.setOnClickListener(this);
        SetTabSelection(0);
        if (savedInstanceState!=null){
            noonFragment= (NoonFragment) fragmentManager.findFragmentByTag("noon");
            nightFragment= (NightFragment) fragmentManager.findFragmentByTag("night");
        }
        setTab();

    }

    private void setTab(){
        TabHost tabHost= (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        TabHost.TabSpec tabSpec1=tabHost.newTabSpec("tab1").setIndicator("星期一").setContent(R.id.tab1);
        TabHost.TabSpec tabSpec2=tabHost.newTabSpec("tab2").setIndicator("星期二").setContent(R.id.tab2);
        TabHost.TabSpec tabSpec3=tabHost.newTabSpec("tab3").setIndicator("星期三").setContent(R.id.tab3);
        TabHost.TabSpec tabSpec4=tabHost.newTabSpec("tab4").setIndicator("星期四").setContent(R.id.tab4);
        TabHost.TabSpec tabSpec5=tabHost.newTabSpec("tab5").setIndicator("星期五").setContent(R.id.tab5);

        tabHost.addTab(tabSpec1);
        tabHost.addTab(tabSpec2);
        tabHost.addTab(tabSpec3);
        tabHost.addTab(tabSpec4);
        tabHost.addTab(tabSpec5);
    }

    private void SetTabSelection(int index){
        clean();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        HideFragment(transaction);
        switch (index){
            case 0:
                noText.setTextColor(Color.parseColor("#f34747"));
                noImage.setImageResource(R.drawable.sun_icon);
                noLIne.setBackgroundColor(Color.parseColor("#f34747"));
                if (noonFragment==null){
                    noonFragment=new NoonFragment();
                    transaction.add(R.id.fragment,noonFragment,"noon");
                }else
                transaction.show(noonFragment);
                break;
            case 1:
                ngText.setTextColor(Color.parseColor("#f34747"));
                ngImage.setImageResource(R.drawable.night_red);
                ngLine.setBackgroundColor(Color.parseColor("#f34747"));
                if (nightFragment==null){
                   nightFragment=new NightFragment();
                    transaction.add(R.id.fragment,nightFragment,"night");
                }else
                transaction.show(nightFragment);
                break;
        }
        transaction.commit();
    }
    private void  clean(){
        noText.setTextColor(Color.parseColor("#000000"));
        ngText.setTextColor(Color.parseColor("#000000"));
        noImage.setImageResource(R.drawable.sun_black);
        ngImage.setImageResource(R.drawable.night_icon);
        ngLine.setBackgroundColor(Color.parseColor("#000000"));
        noLIne.setBackgroundColor(Color.parseColor("#000000"));
    }
    private void HideFragment(FragmentTransaction transaction){
        if (noonFragment!=null){
            transaction.hide(noonFragment);
        }
        if (nightFragment!=null){
            transaction.hide(nightFragment);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.noon:
                SetTabSelection(0);
                break;
            case R.id.night:
                SetTabSelection(1);
                break;
        }
    }
}
