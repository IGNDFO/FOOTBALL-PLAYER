package com.example.footballplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    MyDataBaseHelper mydb;
    //kalo salah di floating
    private FloatingActionButton fabtambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabtambah = findViewById(R.id.fab_tambah);
        mydb= new MyDataBaseHelper(MainActivity.this);

        fabtambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
startActivity(new Intent(MainActivity.this,tambah.class));
            }
        });

    }
}