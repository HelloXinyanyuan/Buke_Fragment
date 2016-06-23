package com.whunf.fragmentopearation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FragmentLifeCycleActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_lifecycle);

        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_remove).setOnClickListener(this);
        findViewById(R.id.btn_detach).setOnClickListener(this);
        findViewById(R.id.btn_attach).setOnClickListener(this);
        findViewById(R.id.btn_replace).setOnClickListener(this);
    }

    Fragment fragment = null;

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btn_add:
                fragment = new OneFragment();
                fragmentTransaction.add(R.id.fragment_container, fragment);
                break;
            case R.id.btn_remove:
                fragmentTransaction.remove(fragment);
                break;
            case R.id.btn_detach:
                fragmentTransaction.detach(fragment);
                break;
            case R.id.btn_attach:
                fragmentTransaction.attach(fragment);
                break;
            case R.id.btn_replace:
                fragment= new OneFragment();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                break;
        }
        fragmentTransaction.commit();
    }


}
