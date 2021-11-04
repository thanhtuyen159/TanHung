package com.example.tanhung.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tanhung.R;

import java.util.List;

public class DoAnAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    public static List<DoAn> doAnList;
    int id;

    public DoAnAdapter(Context context, int layout, List<DoAn> doAnList) {
        this.context = context;
        this.layout = layout;
        this.doAnList = doAnList;
    }

    @Override
    public int getCount() {
        return doAnList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtTen,txtMoTa;
        ImageView imgHinh;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view ==null )
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txtTen = (TextView) view.findViewById(R.id.textviewTenCustom);
            holder.txtMoTa= (TextView) view.findViewById(R.id.textviewMoTaCustom);
            holder.imgHinh = (ImageView) view.findViewById(R.id.imageHinhCustom);
            view.setTag(holder);



        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }
        DoAn doAn = doAnList.get(i);
        holder.txtTen.setText(doAn.getTen());
        holder.txtMoTa.setText(doAn.getMoTa());
        id = doAn.getID();
        // chuyen byte[] -> ve bitmap
        byte[] hinhAnh = doAn.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
        holder.imgHinh.setImageBitmap(bitmap);
        return view;
    }


}
