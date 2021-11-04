package com.example.tanhung;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.tanhung.Fragment.DangKyFragment;
import com.example.tanhung.Fragment.DangNhapFragment;

public class DangNhapActivity extends AppCompatActivity{

    TextView login_btn, signup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        AnhXa();

    }

    private void AnhXa() {
        login_btn = findViewById(R.id.login);
        signup_btn = findViewById(R.id.signup);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadLoginFragment();
            }
        });

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadSignUpFragment();
            }
        });

        loadLoginFragment();
    }

    private void loadLoginFragment()
    {
        DangNhapFragment dangNhapFragment = new DangNhapFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.log_sign_layout, dangNhapFragment);
        transaction.commit();
    }

    private void loadSignUpFragment()
    {
        DangKyFragment dangKyFragment = new DangKyFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.log_sign_layout, dangKyFragment);
        transaction.commit();
    }


}