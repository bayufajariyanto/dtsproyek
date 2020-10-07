package com.bayufajariyanto.catatanpengeluaran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class BerandaActivity extends AppCompatActivity {
    // Variabel static untuk mensimulasikan penyimpanan data
    public static ArrayList<String> dataPengeluaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
//        dataPengeluaran = new ArrayList<>();
//        dataPengeluaran.add(getIntent().getStringExtra("DataKeterangan")+" "+getIntent().getStringExtra("DataNominal"));
        if(dataPengeluaran == null){
            // Inisialisasi
            dataPengeluaran = new ArrayList<>();
            dataPengeluaran.add("Sarapan - 8000");
            dataPengeluaran.add("Bensin - 10000");
        }else{
            if(TextUtils.isEmpty(getIntent().getStringExtra("DataKeterangan")) || TextUtils.isEmpty(getIntent().getStringExtra("DataNominal"))){

            }else{
                dataPengeluaran.add(getIntent().getStringExtra("DataKeterangan")+" - "+getIntent().getStringExtra("DataNominal"));
            }
        }
        if(TextUtils.isEmpty(getIntent().getStringExtra("DataKeterangan")) || TextUtils.isEmpty(getIntent().getStringExtra("DataNominal"))){
            Toast.makeText(getBaseContext(), "Data Kosong", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getBaseContext(), "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnTambahPengeluaran(View view){
        Intent i = new Intent(BerandaActivity.this, TambahPengeluaranActivity.class);
        this.startActivity(i);
    }

    public void btnLihatPengeluaran(View view){
        Intent i = new Intent(BerandaActivity.this, LihatPengeluaranActivity.class);
        this.startActivity(i);
    }
}