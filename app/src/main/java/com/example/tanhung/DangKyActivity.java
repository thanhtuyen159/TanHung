package com.example.tanhung;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tanhung.Adapter.TaiKhoan;
import com.example.tanhung.Adapter.TaiKhoanAdapter;

public class DangKyActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener{

    EditText edt_TaiKhoan, edt_MatKhau, edt_SDT, edt_Email;
    Button btn_DangKy;
    TaiKhoanAdapter taiKhoanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        AnhXa();
    }

    private void AnhXa() {
        edt_TaiKhoan = findViewById(R.id.edtTaikhoan);
        edt_MatKhau = findViewById(R.id.edtMatkhau);
        edt_SDT = findViewById(R.id.edtSDT);
        edt_Email = findViewById(R.id.edtEmail);
        btn_DangKy = findViewById(R.id.btnDangky);

        btn_DangKy.setOnClickListener(this);

        taiKhoanAdapter = new TaiKhoanAdapter(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnDangky:
                String sTaiKhoan = edt_TaiKhoan.getText().toString();
                String sMatKhau = edt_MatKhau.getText().toString();
                int sSDT = Integer.parseInt(edt_SDT.getText().toString());
                String sEmail = edt_Email.getText().toString();

                if (sTaiKhoan == null || sTaiKhoan.equals("")){
                    Toast.makeText(this, "Vui lòng nhập tài khoản!", Toast.LENGTH_LONG).show();
                } else if (sMatKhau == null || sMatKhau.equals("")) {
                    Toast.makeText(this, "Vui lòng nhập mật khẩu !", Toast.LENGTH_LONG).show();
                } else if (sEmail == null || sEmail.equals("")) {
                    Toast.makeText(this, "Vui lòng nhập email !", Toast.LENGTH_LONG).show();
                } else {
                    TaiKhoan taiKhoan = new TaiKhoan();
                    taiKhoan.setTENTK(sTaiKhoan);
                    taiKhoan.setMATKHAU(sMatKhau);
                    taiKhoan.setSDT(sSDT);
                    taiKhoan.setEMAIL(sEmail);

                    long kiemtra = taiKhoanAdapter.ThemTaiKhoan(taiKhoan);
                    if (kiemtra != 0){
                        Toast.makeText(this, "Đăng ký thành công !", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(this, com.example.tanhung.DangNhapActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Đăng ký thất bại !", Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

    }
}