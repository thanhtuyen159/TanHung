package com.example.tanhung.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tanhung.db.CreateDatabase;

public class TaiKhoanAdapter {
    SQLiteDatabase database;

    public TaiKhoanAdapter(Context context){
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }

    public long ThemTaiKhoan(TaiKhoan taiKhoanDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.tbl_TAIKHOAN_TENTAIKHOAN,taiKhoanDTO.getTENTK());
        contentValues.put(CreateDatabase.tbl_TAIKHOAN_MATKHAU,taiKhoanDTO.getMATKHAU());
        contentValues.put(CreateDatabase.tbl_TAIKHOAN_SDT,taiKhoanDTO.getSDT());
        contentValues.put(CreateDatabase.tbl_TAIKHOAN_EMAIL,taiKhoanDTO.getEMAIL());

        long kiemtra = database.insert(CreateDatabase.tbl_TAIKHOAN, null, contentValues);
        return kiemtra;
    }


    public boolean KiemTraDangNhap(String tendangnhap, String matkhau){
        String truyvan = "SELECT * FROM " + CreateDatabase.tbl_TAIKHOAN + " WHERE " + CreateDatabase.tbl_TAIKHOAN_TENTAIKHOAN + " = '" + tendangnhap
                + "' AND " + CreateDatabase.tbl_TAIKHOAN_MATKHAU + " = '" + matkhau + "'";

        Cursor cursor = database.rawQuery(truyvan, null);
        if (cursor.getCount() != 0){
            return true;
        } else {
            return false;
        }
    }
}
