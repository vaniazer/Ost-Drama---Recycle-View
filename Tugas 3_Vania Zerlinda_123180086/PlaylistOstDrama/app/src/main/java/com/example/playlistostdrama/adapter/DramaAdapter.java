package com.example.playlistostdrama.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.playlistostdrama.DetailActivity;
import com.example.playlistostdrama.Drama;
import com.example.playlistostdrama.R;

import java.util.ArrayList;


public class DramaAdapter  extends RecyclerView.Adapter<DramaAdapter.ViewHolder> {
    private ArrayList<Drama> dramas = new ArrayList<>();


    // mengisi data list yang akan di tampilkan
    public void setDramas(ArrayList<Drama> dramas) {
        if (dramas != null) {
            this.dramas.clear();
            this.dramas.addAll(dramas);
        }
        // update tampilan jika terdapat perubahan data
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // mengkoneksikan layout item kedalam kelas adapter ini
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drama_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // mengirimkan data tiap satuan item ke kelas ViewHolder untuk ditampilkan
        holder.bind(dramas.get(position));

    }


    // mengambil panjang list yang ada
    @Override
    public int getItemCount() {
        return dramas.size();
    }

    // membuat kelas sebagai kontrol item di dalam view (movie_item.xml) agar dapat dimanipulasi
    public class ViewHolder extends RecyclerView.ViewHolder {

        // deklarasi variabel view sesuai dengan layout xml
        private TextView tvLagu, tvTahun;
        private ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // koneksikan variabel dengan view berdasarkan id
            tvLagu = itemView.findViewById(R.id.tv_nama);
            tvTahun = itemView.findViewById(R.id.tv_tahun);
            ivImage = itemView.findViewById(R.id.iv_foto);



        }

        public void bind(Drama drama) {
            // menampilkan text ke dalam view item
            tvLagu.setText(drama.getLagu());
            tvTahun.setText(drama.getTahun());
            // mengambil dan menampilkan image berdasarkan link ke dalam view item
            Glide.with(itemView.getContext())
                    .load(drama.getGambar())
                    .into(ivImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                    intent.putExtra("judul", drama.getLagu());
                    intent.putExtra("nama", drama.getNama());
                    intent.putExtra("penyanyi", drama.getPenyanyi());
                    intent.putExtra("tahun", drama.getTahun());
                    intent.putExtra("aktor", drama.getAktor());
                    intent.putExtra("liriknya", drama.getLirik());
                    itemView.getContext().startActivity(intent);

                }
            });

        }
    }

}
