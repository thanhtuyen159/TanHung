package com.example.tanhung.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CreateDatabase extends SQLiteOpenHelper {
    public static String tbl_TAIKHOAN = "TAIKHOAN";

    public static String tbl_TAIKHOAN_IDTK = "IDTAIKHOAN";
    public static String tbl_TAIKHOAN_TENTAIKHOAN = "TENTAIKHOAN";
    public static String tbl_TAIKHOAN_MATKHAU = "MATKHAU";
    public static String tbl_TAIKHOAN_SDT = "SDT";
    public static String tbl_TAIKHOAN_EMAIL = "EMAIL";



    public CreateDatabase(@Nullable Context context) {
        super(context, "Database.sqlite", null, 2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String TAIKHOAN = "CREATE TABLE " + tbl_TAIKHOAN + " (" + tbl_TAIKHOAN_IDTK + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + tbl_TAIKHOAN_TENTAIKHOAN + " TEXT , " + tbl_TAIKHOAN_MATKHAU + " TEXT, " + tbl_TAIKHOAN_SDT + " INTEGER, "
                + tbl_TAIKHOAN_EMAIL + " TEXT)";


        db.execSQL(TAIKHOAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase open() {
        return this.getWritableDatabase();
    }
}
