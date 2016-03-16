package com.saint.ibangandroid.dinner.dinneradapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.saint.ibangandroid.R;

import java.util.List;
import java.util.Map;

/**
 * Created by zzh on 16-3-2.
 */
public class ShopAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String,Object>> list;
    public ShopAdapter(Context context, List list){
            this.context=context;
            this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=null;
        if (convertView==null){
            holder=new Holder();
            convertView= LayoutInflater.from(context).inflate(R.layout.shopdisplay_layout,null);
            holder.text= (TextView) convertView.findViewById(R.id.shoptext);
            holder.image= (ImageView) convertView.findViewById(R.id.shopimage);
            convertView.setTag(holder);
        }else {
            holder= (Holder) convertView.getTag();

        }
        holder.image.setImageResource((Integer) list.get(position).get("image"));
        holder.text.setText(String.valueOf(list.get(position).get("shops")));

        return convertView;
    }
    public class Holder{
        ImageView image;
        TextView text;
    }
}
