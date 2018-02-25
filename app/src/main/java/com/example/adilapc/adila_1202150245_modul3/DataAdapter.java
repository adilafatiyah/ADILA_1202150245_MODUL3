package com.example.adilapc.adila_1202150245_modul3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by adila pc on 25/02/2018.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<String> kota;
    private ArrayList<Integer> gambar;

    public DataAdapter(ArrayList<String> kota, ArrayList<Integer> gambar){
        this.kota = kota;
        this.gambar =gambar;
    }


    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.txtkota.setText(kota.get(i));

        viewHolder.relativeLayout.setBackgroundResource(gambar.get(i));
    }

    @Override
    public int getItemCount() {
        return kota.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtkota;
        private ImageView imageView;
        private RelativeLayout relativeLayout;
        public ViewHolder(View view) {
            super(view);
            txtkota = (TextView)view.findViewById(R.id.daftar_judul);

            relativeLayout =(RelativeLayout)view.findViewById(R.id.background_list);
        }
    }
}

