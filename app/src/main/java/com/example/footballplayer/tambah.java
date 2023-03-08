package com.example.footballplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tambah extends AppCompatActivity {

    private EditText etnama,etnomor,etclub;
    private Button btnsave;

MyDataBaseHelper db= new MyDataBaseHelper(tambah.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etnama=findViewById(R.id.et_nama);
        etnomor=findViewById(R.id.et_nomor);
        etclub=findViewById(R.id.et_club);
        btnsave=findViewById(R.id.btn_save);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama,nomor,club;

                nama = etnama.getText().toString();
                nomor = etnomor.getText().toString();
                club = etclub.getText().toString();

                if (nama.trim().equals("")){
                    etnama.setError("NAMA TIDAK BOLEH KOSONG");
                }
                else   if (nomor.trim().equals("")){
                    etnama.setError("NOMOR PUNGGUNG TIDAK BOLEH KOSONG");
                }
                else   if (club.trim().equals("")){
                    etnama.setError("NAMA CLUB TIDAK BOLEH KOSONG");
                }
                else {
                    long eks = db.tambahplayer(nama,nomor,club);

                    if (eks==-1){
                        Toast.makeText(tambah.this,"DATA GAGAL DITAMBAH",Toast.LENGTH_LONG).show();
                        finish();
                    }
                }

            }
        });
    }
}