package com.saint.ibangandroid.dinner.dinnerfargment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.saint.ibangandroid.R;
import com.saint.ibangandroid.dinner.dinneradapter.NightAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zzh on 16-3-4.
 */
public class NightFragment extends Fragment  implements View.OnClickListener{
    RecyclerView ryView;
    private List<Map<String,Object>> list=new ArrayList<>();
    private Button enter;
    private NightAdapter adapter;
    private  String time[]={"16:30","16:45","17:00","17:15","17:30","17:45","18:00","18:15"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.noon_layout,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.clear();
        ryView= (RecyclerView) view.findViewById(R.id.rytime);
        ryView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        ryView.setHasFixedSize(true);
        enter= (Button) view.findViewById(R.id.enter);
        enter.setOnClickListener(this);

        for (int i=0;i<time.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("time",time[i]);
            list.add(map);
        }
        adapter= new NightAdapter(getActivity(),list);
        ryView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.enter){

        }
    }


}
