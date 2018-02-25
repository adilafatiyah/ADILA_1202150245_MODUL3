package com.example.adilapc.adila_1202150245_modul3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by adila pc on 25/02/2018.
 */

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> kota;
    private ArrayList<Integer> img;
    private  ArrayList<String> diksripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }
    private void initView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        img = new ArrayList<>();
        img.add(R.drawable.a);
        img.add(R.drawable.b);
        img.add(R.drawable.c);
        img.add(R.drawable.d);
        img.add(R.drawable.e);
        img.add(R.drawable.f);
        img.add(R.drawable.g);
        img.add(R.drawable.h);
        img.add(R.drawable.i);
        img.add(R.drawable.j);
        img.add(R.drawable.k);

        kota = new ArrayList<>();
        kota.add("Ades");
        kota.add("Amidis");
        kota.add("Aqua");
        kota.add("Cleo");
        kota.add("Club");
        kota.add("Equil");
        kota.add("Evian");
        kota.add("Mineral");
        kota.add("Nestle");
        kota.add("Prestine");
        kota.add("VIT");

        diksripsi = new ArrayList<>();
        diksripsi.add(
                "Ades (sebelumnya pernah disebut AdeS) adalah merek air mineral atau air minum dalam kemasan (AMDK) yang diproduksi oleh PT. Coca-Cola Bottling Indonesia, Bekasi. Air mineral tersebut juga dikenal sebagai I-Lohas di Jepang. Kini The Coca-Cola Company merupakan pemilik merek dagang Ades, menggantikan PT. Akasha Wira Internasional atau PT. AdeS Waters Indonesia, pemilik merek dagang Ades sebelumnya.");
        diksripsi.add("");

        RecyclerView.Adapter adapter = new DataAdapter(kota , img);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

                public boolean onSingleTapUp(MotionEvent e){
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && gestureDetector.onTouchEvent(e)){
                    int position = rv.getChildAdapterPosition(child);
                    Intent intent = new Intent(getBaseContext(), DetailActivity.class);
                    intent.putExtra("gambar",img.get(position));
                    intent.putExtra("judul",kota.get(position));
                    startActivity(intent);
                    //Toast.makeText(getApplicationContext(), kota.get(position), Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }
}
