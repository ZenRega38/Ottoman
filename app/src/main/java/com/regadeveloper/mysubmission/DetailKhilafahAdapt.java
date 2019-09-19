package com.regadeveloper.mysubmission;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailKhilafahAdapt extends AppCompatActivity {
    public TextView textTitle, Detail;
    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_khilafah);

        textTitle = findViewById(R.id.tvTitle);
        Detail = findViewById(R.id.detail);
        imageView = findViewById(R.id.imgFoto);

        Khilafah objek = getIntent().getParcelableExtra("objek");
        textTitle.setText(objek.getKhilafah());
        Detail.setText(objek.getDes());
        imageView.setImageResource(objek.getPhoto());
    }
}
