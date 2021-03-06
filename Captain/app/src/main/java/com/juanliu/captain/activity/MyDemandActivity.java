package com.juanliu.captain.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;

import com.juanliu.captain.R;
import com.juanliu.captain.adapter.DemandAdapter;

/**
 * Created by Administrator on 2015/7/29.
 */
public class MyDemandActivity extends Activity implements View.OnClickListener{
    private ImageView iv_back;
    private ListView listView;
    private DemandAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_my_demand);

        initView();
    }
    private void initView(){
        iv_back=(ImageView)findViewById(R.id.iv_back);
        listView=(ListView)findViewById(R.id.lv_they);
        adapter=new DemandAdapter(getApplicationContext(),3);
        listView.setAdapter(adapter);
        iv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
               break;
        }
    }
}
