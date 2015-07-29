package com.juanliu.captain.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import com.juanliu.captain.R;
import com.juanliu.captain.activity.DemandDetailActivity;
import com.juanliu.captain.fragment.FindFragment;

/**
 * Created by sjt on 2015/7/29.
 */
public class FindAdapter extends BaseAdapter implements View.OnClickListener {
    private int list_size;
    private LayoutInflater inflater;
    private Intent intent;
    private Context context;

    public FindAdapter(Context context, int list_size) {
        this.list_size = list_size;
        this.context = context;
        inflater = LayoutInflater.from(context);
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
            convertView = inflater.inflate(R.layout.find_item, null);
            viewHolder = new ViewHolder();
            viewHolder.rl = (RelativeLayout) convertView.findViewById(R.id.find_layout);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.rl.setOnClickListener(this);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.find_layout:
                intent = new Intent(context, DemandDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
        }
    }

    public class ViewHolder {
        public RelativeLayout rl;
    }
}
