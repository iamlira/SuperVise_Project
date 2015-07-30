package com.juanliu.captain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.juanliu.captain.R;
import com.juanliu.captain.adapter.FragmentAdapter;
import com.juanliu.captain.widget.CustomViewPager;


public class MainActivity extends FragmentActivity implements View.OnClickListener {
    public final static int FIND_TAB = 0;
    public final static int MINE_TAB = 1;
    private CustomViewPager viewpager;
    private RadioButton rb_find, rb_mine;
    private FragmentAdapter adapter;
    private ImageView iv_add;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        addListener();
    }


    public void initView() {
        viewpager = (CustomViewPager) findViewById(R.id.custom_viewpager);
        rb_find = (RadioButton) findViewById(R.id.rb_find);
        rb_mine = (RadioButton) findViewById(R.id.rb_mine);
        iv_add=(ImageView)findViewById(R.id.iv_add);
        rb_find.setOnClickListener(this);
        rb_mine.setOnClickListener(this);
        iv_add.setOnClickListener(this);

        adapter = new FragmentAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
    }

    public void addListener() {
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                Log.d("scrolled",i+"   "+v+"   "+i2);
            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case FIND_TAB:
                        rb_find.setChecked(true);
                        break;
                    case MINE_TAB:
                        rb_mine.setChecked(true);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_find:
                viewpager.setCurrentItem(FIND_TAB);
                break;
            case R.id.rb_mine:
                viewpager.setCurrentItem(MINE_TAB);
                break;
            case R.id.iv_add:
                intent=new Intent(this,AddDemandActivity.class);
                startActivity(intent);
                break;
        }
    }
}
