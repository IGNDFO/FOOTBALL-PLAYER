package com.ahmfarisi.footballplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyDatabaseHelper myDB;
    private AdapterFootballPlayer adplayer;
    private ArrayList<String> arrnama,arrnomor,arrklub;
    private RecyclerView rvplayer;
    private FloatingActionButton fabTambah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new MyDatabaseHelper(MainActivity.this);

        fabTambah = findViewById(R.id.fab_tambah);
        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TambahActivity.class));
            }
        });
    }
    private void SQliteToArrayList(){
        Cursor varcursor = myDB.bacaDataPlayer();
        if(varcursor.getCount()==0){
            Toast.makeText(this, "TIDAK ADA DATA", Toast.LENGTH_SHORT).show();
        }
        else {
            while (varcursor.moveToNext()){
                arrnama.add(varcursor.getString(1));
                arrnomor.add(varcursor.getString(2));
                arrklub.add(varcursor.getString(3));
            }
        }
    }
    private void tampilplayer(){
        arrnama=new ArrayList<>();
        arrnomor=new ArrayList<>();
        arrklub=new ArrayList<>();
        SQliteToArrayList();

    adplayer= new AdapterFootballPlayer(MainActivity.this,arrnama,arrklub,arrnomor);
    rvplayer.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    rvplayer.setAdapter(adplayer);
    }
}