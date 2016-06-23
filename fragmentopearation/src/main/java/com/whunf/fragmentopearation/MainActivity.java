package com.whunf.fragmentopearation;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);

        startActivity(new Intent(this,FragmentLifeCycleActivity.class));
    }

//    OneFragment fragment1;
        Fragment fragment=null;
    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btn_one:
//                fragment1 = new OneFragment();
                fragment = new OneFragment();
//        fragmentTransaction.replace(R.id.fragment_container, fragment);
                break;
            case R.id.btn_two:
//        fragmentTransaction.remove(fragment1);
                fragment = new TwoFragment();
                break;
            case R.id.btn_three:
                fragment = new ThreeFragment();
//                fragmentTransaction.replace(R.id.fragment_container, fragment);
                break;
        }
//        fragmentTransaction.replace(R.id.fragment_container, fragment);
//        fragmentTransaction.addToBackStack(null);

//        fragmentTransaction.attach(fragment)//
        fragmentTransaction.detach(fragment);

        fragmentTransaction.commit();
    }


}
