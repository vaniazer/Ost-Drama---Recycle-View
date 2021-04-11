package com.example.playlistostdrama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.playlistostdrama.adapter.DramaAdapter;

import java.util.ArrayList;

public class DramaActivity extends AppCompatActivity {
    private TextView welcome;
    private RecyclerView rv_drama_list;

    // deklarasi adapter yang telah dibuat
    private DramaAdapter dramaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drama);

        rv_drama_list = findViewById(R.id.rv_drama_list);

        dramaAdapter = new DramaAdapter();

        rv_drama_list.setLayoutManager(new LinearLayoutManager(this));

        rv_drama_list.setAdapter(dramaAdapter);

        // memasukkan data ke dalam list
        ArrayList<Drama> data = DataDummy.dummyDrama();
        dramaAdapter.setDramas(data);
    }

}