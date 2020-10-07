package com.bayufajariyanto.catatanpengeluaran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class TambahPengeluaranActivity extends AppCompatActivity {
    EditText edtKeterangan, edtNominal;
    public static final String Key_RegisterActivity = "Key_RegisterActivity";

    public static ArrayList<String> dataPengeluaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pengeluaran);
        edtKeterangan = findViewById(R.id.edt_keterangan);
        edtNominal = findViewById(R.id.edt_nominal);
    }

    public void clickSubmit(View view){
        String keterangan = edtKeterangan.getText().toString();
        String nominal = edtNominal.getText().toString();
        if(TextUtils.isEmpty(keterangan) && TextUtils.isEmpty(nominal)){
            Toast.makeText(view.getContext(), "Keterangan dan Nominal tidak boleh kosong!",
                    Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(keterangan)){
            Toast.makeText(view.getContext(), "Keterangan tidak boleh kosong!",
                    Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(nominal)){
            Toast.makeText(view.getContext(), "Nominal tidak boleh kosong!",
                    Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(TambahPengeluaranActivity.this, BerandaActivity.class);
            intent.putExtra("DataKeterangan", keterangan);
            intent.putExtra("DataNominal", nominal);
            startActivity(intent);
        }
    }
}