package com.whunf.fragment_qq;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FragmentManager fragmentManager;

    private Fragment messageFragment;//消息
    private Fragment contactsFragment;//联系人
    private Fragment newsFragment;//动态
    private Fragment settingFragment;//设置


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tab_message).setOnClickListener(this);
        findViewById(R.id.tab_contacts).setOnClickListener(this);
        findViewById(R.id.tab_news).setOnClickListener(this);
        findViewById(R.id.tab_setting).setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
        findViewById(R.id.tab_message).performClick();//模拟一个用户的点击事件

    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment priviousFrag = fragmentManager.findFragmentById(R.id.fragment_content);
        if (priviousFrag != null) {//第一次是空的
            fragmentTransaction.detach(priviousFrag);
        }
        switch (v.getId()) {
            case R.id.tab_message:
//                messageFragment=fragmentManager.findFragmentByTag("msg");
                //消息
                if (messageFragment == null) {//为空的时候创建一个新的，并且add到Fragment并且显示
                    messageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.fragment_content, messageFragment, "message");
                } else {
                    fragmentTransaction.attach(messageFragment);
                }
                break;
            case R.id.tab_contacts:
                //联系人
                if (contactsFragment == null) {
                    contactsFragment = new ContactsFragment();
                    fragmentTransaction.add(R.id.fragment_content, contactsFragment, "contacts");
                } else {
                    fragmentTransaction.attach(contactsFragment);
                }
                break;
            case R.id.tab_news:
                //动态
                if (newsFragment == null) {
                    newsFragment = new NewsFragment();
                    fragmentTransaction.add(R.id.fragment_content, newsFragment, "news");
                } else {
                    fragmentTransaction.attach(newsFragment);
                }
                break;
            case R.id.tab_setting:
                //设置
                if (settingFragment == null) {
                    settingFragment = new SettingFragment();
                    fragmentTransaction.add(R.id.fragment_content, settingFragment, "setting");
                } else {
                    fragmentTransaction.attach(settingFragment);
                }
                break;
        }
        fragmentTransaction.commit();

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
