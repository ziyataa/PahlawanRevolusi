package com.ziyata.pahlawanrevolusi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    String[] namaPahlawan, isiPahlawan;
    int[] imgPahlawan;

    public Adapter(Context context, String[] namaPahlawan, String[] isiPahlawan, int[] imgPahlawan) {
        this.context = context;
        this.namaPahlawan = namaPahlawan;
        this.isiPahlawan = isiPahlawan;
        this.imgPahlawan = imgPahlawan;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_pahlawan,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtListTitle.setText(namaPahlawan[i]);
        Glide.with(context).load(imgPahlawan[i]).into(viewHolder.imgList);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailPahlawanActivity.class);
                pindah.putExtra("np", namaPahlawan[i]);
                pindah.putExtra("ip", isiPahlawan[i]);
                pindah.putExtra("imgp", imgPahlawan[i]);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imgPahlawan.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtListTitle;
        ImageView imgList;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtListTitle = itemView.findViewById(R.id.txtListTitle);
            imgList = itemView.findViewById(R.id.imgList);
        }
    }
}
