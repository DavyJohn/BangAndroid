package com.saint.ibangandroid.dinner.dinneradapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saint.ibangandroid.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zzh on 16-3-10.
 */
public class NightAdapter extends RecyclerView.Adapter<NightAdapter.ViewHolder> {
    private List<Map<String ,Object>> list=new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;
    public NightAdapter(Context context, List list){
        this.context=context;
        this.list=list;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.noon_dis_layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        holder.view= (TextView) view.findViewById(R.id.tmtext);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.view.setText(String.valueOf(list.get(position).get("time")));
            holder.view.setBackgroundColor(Color.parseColor("#f7f7f7f7"));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView view;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
