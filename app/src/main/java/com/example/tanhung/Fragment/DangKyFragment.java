package com.example.tanhung.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.tanhung.Adapter.TaiKhoan;
import com.example.tanhung.Adapter.TaiKhoanAdapter;
import com.example.tanhung.DangNhapActivity;
import com.example.tanhung.R;

public class DangKyFragment extends Fragment implements View.OnClickListener{

    private  View mView;
    EditText edt_TaiKhoan, edt_MatKhau, edt_NgaySinh, edt_SDT, edt_Email;
    Button btn_DangKy;
    TaiKhoanAdapter taiKhoanAdapter;

    public DangKyFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_dang_ky, container, false);

        AnhXa();

        return mView;
    }


    private void AnhXa() {
        edt_TaiKhoan = mView.findViewById(R.id.edtTaikhoan);
        edt_MatKhau = mView.findViewById(R.id.edtMatkhau);
        edt_SDT = mView.findViewById(R.id.edtSDT);
        edt_Email = mView.findViewById(R.id.edtEmail);
        btn_DangKy = mView.findViewById(R.id.btnDangky);

        btn_DangKy.setOnClickListener(this);

        taiKhoanAdapter = new TaiKhoanAdapter(getActivity());
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
                    Toast.makeText(getActivity(), "Vui lòng nhập tài khoản !", Toast.LENGTH_LONG).show();
                } else if (sMatKhau == null || sMatKhau.equals("")) {
                    Toast.makeText(getActivity(), "Vui lòng nhập mật khẩu !", Toast.LENGTH_LONG).show();
                } else if (sEmail == null || sEmail.equals("")) {
                    Toast.makeText(getActivity(), "Vui lòng nhật email !", Toast.LENGTH_LONG).show();
                } else {
                    TaiKhoan taiKhoanDTO = new TaiKhoan();
                    taiKhoanDTO.setTENTK(sTaiKhoan);
                    taiKhoanDTO.setMATKHAU(sMatKhau);
                    taiKhoanDTO.setSDT(sSDT);
                    taiKhoanDTO.setEMAIL(sEmail);

                    long kiemtra = taiKhoanAdapter.ThemTaiKhoan(taiKhoanDTO);
                    if (kiemtra != 0){
                        Toast.makeText(getActivity(), "Đăng ký thành công !", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getActivity(), DangNhapActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity(), "Đăng ký thất bại !", Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }

    }
}