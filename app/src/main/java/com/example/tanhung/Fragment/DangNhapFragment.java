package com.example.tanhung.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.tanhung.Adapter.TaiKhoanAdapter;
import com.example.tanhung.MainActivity;
import com.example.tanhung.R;


public class DangNhapFragment extends Fragment implements View.OnClickListener{

    private View mView;
    TextView txt_DangKy, txt_QuenMK;
    Button btn_DangNhap;
    EditText edt_TK, edt_MK;
    ImageButton ibtn_exit;
    TaiKhoanAdapter taiKhoanAdapter;
    String mUsername = "";

    public DangNhapFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_dang_nhap, container, false);

        AnhXa();

        return mView;
    }

    private void AnhXa() {
        txt_QuenMK = mView.findViewById(R.id.txtQuenmk);
        btn_DangNhap = mView.findViewById(R.id.btnDangnhap);
        edt_TK = mView.findViewById(R.id.edtTaikhoan);
        edt_MK = mView.findViewById(R.id.edtMatkhau);

        taiKhoanAdapter = new TaiKhoanAdapter(getActivity());
        btn_DangNhap.setOnClickListener(this);
        txt_QuenMK.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnDangnhap:
                setBtn_Login();
                ;break;
        }
    }

    private void setBtn_Login(){
        String sTentaikhoan = edt_TK.getText().toString();
        String sMatkhau = edt_MK.getText().toString();
        boolean kiemtra = taiKhoanAdapter.KiemTraDangNhap(sTentaikhoan, sMatkhau);
        mUsername = sTentaikhoan;

        if (kiemtra){
            Toast.makeText(getActivity(), "????ng Nh???p Th??nh C??ng !", Toast.LENGTH_LONG).show();
            Intent iTrangchu = new Intent(getActivity(), MainActivity.class);
            iTrangchu.putExtra("TenTaiKhoan", edt_TK.getText().toString());
            startActivity(iTrangchu);
        } else {
            Toast.makeText(getActivity(), "????ng Nh???p Th???t B???i !", Toast.LENGTH_LONG).show();
        }
    }

    public String getUsername() {
        return mUsername;
    }
}