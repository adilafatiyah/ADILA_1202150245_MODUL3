package com.example.adilapc.adila_1202150245_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    ImageView imgview, imageView2;
    TextView textView1, textView2;

    public ArrayList<Integer> batray;

    int count=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        int gambar = getIntent().getIntExtra("gambar",0);
        String judul = getIntent().getStringExtra("judul");

        imgview = (ImageView)findViewById(R.id.img_detail);
        textView1 =(TextView)findViewById(R.id.title_detail);
        imgview.setImageResource(gambar);
        textView1.setText(judul.toString());
        imageView2 = (ImageView)findViewById(R.id.gambar_battery);


        batray = new ArrayList<>();
        batray.add(R.drawable.ic_battery_20);
        batray.add(R.drawable.ic_battery_30);
        batray.add(R.drawable.ic_battery_50);
        batray.add(R.drawable.ic_battery_60);
        batray.add(R.drawable.ic_battery_80);
        batray.add(R.drawable.ic_battery_90);
        batray.add(R.drawable.ic_battery_full);

        imageView2.setImageResource(batray.get(count));



    }

    public void tambah(View view) {
        if (count==6){
            Toast.makeText(DetailActivity.this,"Air full",Toast.LENGTH_LONG).show();
        }else {
            count++;
            imageView2.setImageResource(batray.get(count));


        }

    }

    public void kurang(View view) {
        if(count==1){
            Toast.makeText(DetailActivity.this,"Air sedikit",Toast.LENGTH_LONG).show();
        }
        else {
            count--;
            imageView2.setImageResource(batray.get(count));

        }
    }
}
