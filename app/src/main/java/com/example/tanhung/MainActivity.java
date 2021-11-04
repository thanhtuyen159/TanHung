package com.example.tanhung;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tanhung.Adapter.DoAn;
import com.example.tanhung.Adapter.DoAnAdapter;
import com.example.tanhung.db.Database;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnThem;
    public static Database database;
    ListView listViewDoAn;
    ArrayList<DoAn> doAnArrayList;
    DoAnAdapter adapter;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThem = findViewById(R.id.buttonthem);
        listViewDoAn = (ListView) findViewById(R.id.listviewDoVat);
        doAnArrayList = new ArrayList<>();
        adapter = new DoAnAdapter(this,R.layout.dong_do_an,doAnArrayList);
        listViewDoAn.setAdapter(adapter);
        registerForContextMenu(listViewDoAn);

        database = new Database(this,"Database.sqlite",null,2);
        database.Query_Data("CREATE TABLE IF NOT EXISTS DoAn(Id INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", Ten VARCHAR(150), MoTa VARCHAR(250), HinhAnh BLOB)");

        GetDataDoan();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.example.tanhung.ThemDoAnActivity.class);
                startActivity(intent);
            }
        });
    }

    private void GetDataDoan() {
        //get data
        Cursor cursor = database.Getdata("SELECT * FROM DoAn");
        doAnArrayList.clear();
        while (cursor.moveToNext())
        {
            doAnArrayList.add(new DoAn(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getBlob(3)
            ));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_content, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId())
        {
            case R.id.menu_edit_item:
                Intent intent = new Intent(MainActivity.this, com.example.tanhung.SuaDoAnActivity.class);
                intent.putExtra("id",info.position);
                startActivity(intent);
                return true;
            case R.id.menu_delete_item:
                DoAn doAn = DoAnAdapter.doAnList.get(info.position);
                database.DELETE_DOAN(
                        doAn.getID()
                );
                Toast.makeText(MainActivity.this,"Xóa thành công",Toast.LENGTH_LONG).show();
                GetDataDoan();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }



}