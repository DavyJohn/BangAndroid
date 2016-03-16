package com.saint.ibangandroid.main.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.saint.ibangandroid.R;

import java.util.List;
import java.util.Map;

import bang.saint.com.recyclerlibrary.recyclerview.BaseRecyclerAdapter;

/**
 * Created by zzh on 16-3-1.
 */
public class HomeAdapter extends BaseRecyclerAdapter<HomeAdapter.ViewHolder>  {
    private List<Map<String,Object>> list;
    private LayoutInflater inflater;
    private Context context;
    public HomeAdapter(Context context, List list){
        this.list=list;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view,false);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view=inflater.inflate(R.layout.recycler_main,parent,false);
        ViewHolder holder=new ViewHolder(view,true);
//        holder.image= (ImageView) view.findViewById(R.id.image);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position, boolean isItem) {
        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inSampleSize=2;
        Bitmap bitmap=BitmapFactory.decodeResource(context.getResources(), (Integer) list.get(position).get("image"),options);
        holder.image.setImageBitmap(bitmap);

//        Picasso.with(context).load(String.valueOf(list.get(position).get("image"))).into(holder.image);
//        holder.image.setImageResource((Integer) list.get(position).get("image"));

        if (onItemClickLisener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickLisener.onItemClick(holder.itemView,position);
                }
            });
        }
    }
    @Override
    public int getAdapterItemCount() {
        return list.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder  {
        ImageView image;
        public ViewHolder(View itemView,boolean isItem) {
            super(itemView);
            if (isItem){
                image= (ImageView) itemView.findViewById(R.id.image);
            }
        }




    }
    //
    public  interface OnItemClickLisener{
        void onItemClick(View view, int posttion);
    }
    public  OnItemClickLisener onItemClickLisener;

    public void setOnItemClickLisener(OnItemClickLisener onItemClickLisener){
         this.onItemClickLisener=onItemClickLisener;
    }
}
