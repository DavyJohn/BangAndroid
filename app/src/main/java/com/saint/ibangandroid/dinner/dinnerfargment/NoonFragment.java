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
import com.saint.ibangandroid.dinner.dinneradapter.NoonAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zzh on 16-3-4.
 */
public class NoonFragment extends Fragment implements View.OnClickListener{
    private NoonAdapter adapter;
    private RecyclerView ryView;
    private Button mButton;
    private List<Map<String,Object>> list=new ArrayList<>();
    private  String data[] ={"11:00","11:15","11:30","11:45","12:00","12:15","12:30","12:45","13:00"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.noon_layout, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.clear();
        ryView= (RecyclerView) view.findViewById(R.id.rytime);
        ryView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        ryView.setHasFixedSize(true);

        mButton= (Button) view.findViewById(R.id.enter);
        mButton.setOnClickListener(this);
        for (int i=0;i<data.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("data",data[i]);
            list.add(map);
        }

        adapter=new NoonAdapter(getActivity(),list);
        ryView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.enter){

        }
    }
}
