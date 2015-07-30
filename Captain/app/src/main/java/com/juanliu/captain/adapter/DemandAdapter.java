package com.juanliu.captain.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.juanliu.captain.R;

/**
 * Created by Administrator on 2015/7/30.
 */
public class DemandAdapter extends BaseAdapter {
    private int list_size;
    private Context context;
    private LayoutInflater inflater;

    public DemandAdapter(Context context, int list_size) {
        this.context = context;
        this.list_size = list_size;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list_size;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.lv_they_item, null);
            viewHolder = new ViewHolder();
            viewHolder.rl = (RelativeLayout) convertView.findViewById(R.id.lv_my_demand);
            viewHolder.btn_approve=(Button)convertView.findViewById(R.id.btn_approve);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.btn_approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return convertView;
    }


    private class ViewHolder {
        public RelativeLayout rl;
        public Button btn_approve;
    }
}
