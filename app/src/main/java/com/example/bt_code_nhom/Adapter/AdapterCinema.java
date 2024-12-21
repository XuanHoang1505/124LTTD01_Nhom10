package com.example.bt_code_nhom.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bt_code_nhom.R;
import com.example.bt_code_nhom.cinema;

import java.util.List;

public class AdapterCinema extends BaseAdapter {

    private Context context;
    private int layout;
    private List<cinema> arraylist;

    public AdapterCinema(Context context, int layout, List<cinema> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        cinema cn = arraylist.get(i);
        ImageView img = view.findViewById(R.id.hinhanh_cinema);
        TextView name = view.findViewById(R.id.ten_cinema);
        TextView address = view.findViewById(R.id.diachi_cinema);
        TextView phone = view.findViewById(R.id.sdt_cinema);

        img.setImageResource(cn.getHinh());
        name.setText(cn.getTenrap());
        address.setText(cn.getDiachi());
        phone.setText(cn.getSdt());
        return view;
    }
}