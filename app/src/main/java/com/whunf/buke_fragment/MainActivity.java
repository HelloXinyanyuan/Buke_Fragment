package com.whunf.buke_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //拿到fragment管理器
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        //拿到事务.操作fragment增减
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        //创建fragment
        Fragment dynamicFragment = new DynamicFragment();
        //添加到FragmentManager中去，并且显示
        fragmentTransaction.add(R.id.dynamic_fragment, dynamicFragment, "dynamic");
        //提交事务
        fragmentTransaction.commit();
    }
}
