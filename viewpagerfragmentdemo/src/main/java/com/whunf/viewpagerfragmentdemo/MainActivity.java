package com.whunf.viewpagerfragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FragmentManager fragmentManager;
    private ViewPager mVp;
    private int[] viewIds = {R.id.tab_message, R.id.tab_contacts, R.id.tab_news, R.id.tab_setting};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tab_message).setOnClickListener(this);
        findViewById(R.id.tab_contacts).setOnClickListener(this);
        findViewById(R.id.tab_news).setOnClickListener(this);
        findViewById(R.id.tab_setting).setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
        mVp = (ViewPager) findViewById(R.id.fragment_vp);
//初始化Fragment集合
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MessageFragment());
        fragments.add(new ContactsFragment());
        fragments.add(new NewsFragment());
        fragments.add(new SettingFragment());
        //创建Fragment适配器
        PagerAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(), fragments);
        //ViewPager与适配器关联
        mVp.setAdapter(adapter);

        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                //根据位置查找视图的id。根据tab视图的id
                View v = findViewById(viewIds[position]);
                //执行选中指定tab
                doViewSelected(v);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        //设置缓存阈值（yuzhi）大小
        mVp.setOffscreenPageLimit(fragments.size());

        findViewById(R.id.tab_message).performClick();//模拟一个用户的点击事件

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_message:
                //消息
                mVp.setCurrentItem(0);
                break;
            case R.id.tab_contacts:
                //联系人
                mVp.setCurrentItem(1);
                break;
            case R.id.tab_news:
                //动态
                mVp.setCurrentItem(2);
                break;
            case R.id.tab_setting:
                //设置
                mVp.setCurrentItem(3);
                break;
        }
//执行视图选中
        doViewSelected(v);
    }

    private void doViewSelected(View v) {
        ViewGroup parent = (ViewGroup) v.getParent();
        for (int i = 0; i < parent.getChildCount(); i++) {
            View childAt = parent.getChildAt(i);
            if (childAt == v) {//选中当前的
                childAt.setSelected(true);
            } else {
                childAt.setSelected(false);
            }
        }

    }
}
