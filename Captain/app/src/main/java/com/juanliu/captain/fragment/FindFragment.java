package com.juanliu.captain.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.juanliu.captain.R;
import com.juanliu.captain.adapter.FindAdapter;

public class FindFragment extends BaseFragment {
    private View mview;
    private ListView listview;
    private FindAdapter find_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.find_fragment_layout, container, false);
        find_adapter=new FindAdapter(this.getActivity().getApplicationContext(),8);
        initView();
        return mview;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView() {
        listview=(ListView)mview.findViewById(R.id.lv_info);
        listview.setAdapter(find_adapter);
    }
}
