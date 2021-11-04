package com.example.tanhung.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public void Query_Data(String sql)
    {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public void INSERT_DOAN(String ten,String mota, byte[] hinh){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO DoAn VALUES(null,?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,ten);
        statement.bindString(2,mota);
        statement.bindBlob(3,hinh);

        statement.executeInsert();
    }

    public void UPDATE_DOAN(String ten,String mota, byte[] hinh,int Id){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE DoAn SET Ten = ? , MoTa = ?, HinhAnh = ? WHERE Id="+ Id ;
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,ten);
        statement.bindString(2,mota);
        statement.bindBlob(3,hinh);



        statement.executeInsert();
    }

    public void DELETE_DOAN(int Id){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "DELETE FROM DoAn WHERE Id ="+ Id;
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();


        statement.executeInsert();
    }

    public Cursor Getdata(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);

    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
