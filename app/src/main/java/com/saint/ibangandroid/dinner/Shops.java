package com.saint.ibangandroid.dinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.saint.ibangandroid.R;
import com.saint.ibangandroid.dinner.dinneradapter.ShopAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zzh on 16-3-1.
 */
public class Shops extends Activity {
    private GridView gridView;
    private ShopAdapter adapter;

    private  int [] image={R.drawable.order,R.drawable.order_button
            ,R.drawable.coupon_button,R.drawable.payment_button};
    private String[] shops={"预约","点菜","优惠卷","支付"};
    private List<Map<String,Object>> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopservice_layout);

        gridView= (GridView) findViewById(R.id.gridview);
        for (int i=0;i<image.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("image",image[i]);
            map.put("shops",shops[i]);
            list.add(map);
        }
        adapter=new ShopAdapter(this,list);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Shops.this,"点击第"+position,Toast.LENGTH_SHORT).show();
                if (position==0){
                    Intent intent=new Intent(Shops.this,Appointment.class);
                    startActivity(intent);
                }else if (position==1){
                    //点菜
                    startActivity(new Intent(Shops.this,Dishes.class));
//                    Intent intent=new Intent(Shops.this,Dishes.class);
//                    startActivity(intent);
                }else if (position==2){
                    //优惠卷
                }else {
                    //支付
                }

            }
        });


    }




}
