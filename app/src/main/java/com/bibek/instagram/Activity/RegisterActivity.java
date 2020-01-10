package com.bibek.instagram.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bibek.instagram.R;
import com.bibek.instagram.Adapters.RegisterVP_Adapter;
import com.bibek.instagram.Fragments.Reg1Fragment;
import com.bibek.instagram.Fragments.Reg2Fragment;
import com.google.android.material.tabs.TabLayout;

public class RegisterActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tab;
    private TextView tvGotoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        viewPager = findViewById(R.id.viewpager);
        tab = findViewById(R.id.tab_register);
        tvGotoLogin = findViewById(R.id.tvLogin);

        tvGotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(goBack);
            }
        });

        RegisterVP_Adapter adapter = new RegisterVP_Adapter(getSupportFragmentManager(), 1);

        adapter.addFragment(new Reg1Fragment(), "PHONE");
        adapter.addFragment(new Reg2Fragment(), "EMAIL");

        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);

    }
}
