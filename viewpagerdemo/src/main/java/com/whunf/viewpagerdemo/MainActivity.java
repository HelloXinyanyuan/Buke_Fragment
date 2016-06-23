package com.whunf.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int[] imgResids = {R.drawable.start_i0,
            R.drawable.start_i1,
            R.drawable.start_i2,
            R.drawable.start_i3,
            R.drawable.start_i4,
            R.drawable.start_i5,
            R.drawable.start_i6,
            R.drawable.start_i7};
    ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVp = (ViewPager) findViewById(R.id.vp);

        //初始化view
        List<View> views = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            View v = View.inflate(this, R.layout.guide_item, null);

            View loginBtn = v.findViewById(R.id.login_reg_btn);
            loginBtn.setOnClickListener(this);
            loginBtn.setTag("login" + i);

            View exp = v.findViewById(R.id.exp_btn);
            exp.setTag("exp" + i);
            exp.setOnClickListener(this);
            //加入到集合中
            views.add(v);
        }
        PagerAdapter adapter = new MyPagerAdapter(views, imgResids);
        mVp.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        String tag = (String) v.getTag();
        Toast.makeText(MainActivity.this, "tag:" + tag, Toast.LENGTH_SHORT).show();
    }
}
