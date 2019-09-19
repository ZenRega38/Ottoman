package com.regadeveloper.mysubmission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String title = "Khilafah Utsmaniyah";
    private ArrayList<Khilafah> list = new ArrayList<>();
    private RecyclerView cvKhi;

    //1 MainActivity
    //2 Adapter
    //3 Detail
    //4 POJO
    //5 Data
    //6 About

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBar(title);

        cvKhi = findViewById(R.id.rcv);
        cvKhi.setHasFixedSize(true);

        list.addAll(KhilafahData.getListData());
        showRecyclerCard();

    }

    private void setActionBar(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }


    public ArrayList<Khilafah> getList() {
        return list;
    }

    public void setList(ArrayList<Khilafah> list) {
        this.list = list;
    }


    private void showRecyclerCard() {
        cvKhi.setLayoutManager(new LinearLayoutManager(this));
        CVKhilafahAdapt cvKhilafahAdapt = new CVKhilafahAdapt(list);
        cvKhi.setAdapter(cvKhilafahAdapt);
    }

    //Intent to About
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_about:
                Intent moveIntent = new Intent(MainActivity.this, About.class);
                startActivity(moveIntent);
                break;
            default:
                break;
        }
    }

    //Menu (button about)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
}
