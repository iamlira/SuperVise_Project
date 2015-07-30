package com.juanliu.captain.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.juanliu.captain.R;

/**
 * Created by Administrator on 2015/7/29.
 */
public class MyDetailActivity extends Activity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_gender;
    private String gender = "1";//1为男性，0为女性,默认男性

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_person_detail);

        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_gender = (TextView) findViewById(R.id.tv_gender);

        iv_back.setOnClickListener(this);
        tv_gender.setOnClickListener(this);
    }

    private void showdialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.gender_dialog, null);
        final RadioButton rb_male, rb_female;
        rb_male = (RadioButton) view.findViewById(R.id.rb_male);
        rb_female = (RadioButton) view.findViewById(R.id.rb_female);
        if ("1".equals(gender))
            rb_male.setChecked(true);
        else
            rb_female.setChecked(true);
        builder.setView(view);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (rb_male.isChecked()) {
                    gender = "1";
                } else if (rb_female.isChecked()) {
                    gender = "0";
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_gender:
                showdialog();
                break;
        }
    }
}
