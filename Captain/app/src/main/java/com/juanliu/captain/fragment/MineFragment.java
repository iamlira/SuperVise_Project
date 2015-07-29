package com.juanliu.captain.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.juanliu.captain.R;
import com.juanliu.captain.activity.MyDemandActivity;
import com.juanliu.captain.activity.MyDetailActivity;
import com.juanliu.captain.activity.SuperviseActivity;

/**
 * Created by sjt on 2015/7/27.
 */
public class MineFragment extends Fragment implements View.OnClickListener {
    private View mview;
    private RelativeLayout rl_my_info, rl_my_demand, rl_supervise;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.mine_fragment_layout, container, false);
        initView();
        return mview;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView() {
        rl_my_info = (RelativeLayout) mview.findViewById(R.id.layout_name);
        rl_my_demand = (RelativeLayout) mview.findViewById(R.id.layout_demand);
        rl_supervise = (RelativeLayout) mview.findViewById(R.id.layout_supervise);

        rl_my_info.setOnClickListener(this);
        rl_my_demand.setOnClickListener(this);
        rl_supervise.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.layout_name:
                intent.setClass(getActivity(), MyDetailActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_demand:
                intent.setClass(getActivity(), MyDemandActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_supervise:
                intent.setClass(getActivity(), SuperviseActivity.class);
                startActivity(intent);
                break;
        }
    }
}
