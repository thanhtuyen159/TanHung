package com.example.tanhung;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tanhung.Adapter.DoAn;
import com.example.tanhung.Adapter.DoAnAdapter;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SuaDoAnActivity extends AppCompatActivity {

    EditText Tendoan;
    EditText MoTadoan;
    ImageView imgHinh;
    int REQUEST_CODE_CAMERA=123;
    int REQUEST_CODE_FOLDER=456;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_do_an);
        Anhxa();
        Intent intent = getIntent();
        id = intent.getIntExtra("id",1123);
        Toast.makeText(SuaDoAnActivity.this,"id cua ban la"+id,Toast.LENGTH_LONG).show();

        GetDataDoan();
    }



    private void Anhxa() {
        Tendoan = (EditText) findViewById(R.id.editTextTen_Sua);
        MoTadoan = (EditText) findViewById(R.id.editTextMoTa_Sua);
        imgHinh = (ImageView) findViewById(R.id.imageViewHinh_Sua);
        ImageButton ibtnCamera = (ImageButton) findViewById(R.id.imageButtonCamera);
        ImageButton ibtnFolder = (ImageButton) findViewById(R.id.imageButtonFolder);
        Button btnCancel = (Button) findViewById(R.id.buttonHuy);

        Button button_Sua = (Button) findViewById(R.id.buttonSua);
        button_Sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imgHinh.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArray);
                byte[] hinhAnh = byteArray.toByteArray();
                Intent intent = getIntent();


                DoAn doAn = DoAnAdapter.doAnList.get(id);
                MainActivity.database.UPDATE_DOAN(
                        Tendoan.getText().toString().trim(),
                        MoTadoan.getText().toString().trim(),
                        hinhAnh,
                        doAn.getID()
                );
                Toast.makeText(SuaDoAnActivity.this," Sửa thành công !",Toast.LENGTH_LONG).show();
                startActivity(new Intent(SuaDoAnActivity.this,MainActivity.class));

            }
        });

        ibtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CODE_CAMERA);

            }
        });
        ibtnFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_FOLDER);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuaDoAnActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgHinh.setImageBitmap(bitmap);
        }
        if(requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null)
        {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgHinh.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    private void GetDataDoan() {
        //get data
        DoAn doAn = DoAnAdapter.doAnList.get(id);
        String ten = doAn.getTen();
        String mota = doAn.getMoTa();
        Tendoan.setText(ten);
        MoTadoan.setText(mota);
        byte[] hinhAnh = doAn.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
        imgHinh.setImageBitmap(bitmap);


    }

}