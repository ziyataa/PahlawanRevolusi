package com.ziyata.pahlawanrevolusi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {
    @BindView(R.id.myRecycleView)
    RecyclerView myRecyclerView;

    String[] namaPahlawan, isiPahlawan;
    int[] imgPahlawan;

    Adapter adapterPahlawan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        namaPahlawan = getResources().getStringArray(R.array.nama_pahlawan);
        isiPahlawan = getResources().getStringArray(R.array.isi_pahlawan);
        imgPahlawan = new int[]{R.drawable.ahmad_yani,R.drawable.suprapto,R.drawable.haryono,R.drawable.siswondo,R.drawable.panjaitan,R.drawable.sutoyo,R.drawable.tendean,R.drawable.karel,R.drawable.katamso,R.drawable.sugiono};

        adapterPahlawan = new Adapter(RecycleActivity.this,namaPahlawan,isiPahlawan,imgPahlawan);

        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(RecycleActivity.this));
        myRecyclerView.setAdapter(adapterPahlawan);
    }
}
