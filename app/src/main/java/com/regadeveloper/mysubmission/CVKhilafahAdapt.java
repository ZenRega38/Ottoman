package com.regadeveloper.mysubmission;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CVKhilafahAdapt extends RecyclerView.Adapter<CVKhilafahAdapt.CardViewHolder> {

    private ArrayList<Khilafah> listKhilafah;

    public CVKhilafahAdapt(ArrayList<Khilafah> list) {
        this.listKhilafah =list;
    }

    @NonNull
    public CardViewHolder onCreateViewHolder  (@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view, parent, false);
        return new CardViewHolder(view);
    }

    public void onBindViewHolder(@NonNull final CardViewHolder holder, final int position) {

        Khilafah khilafah = listKhilafah.get(position);

        Glide.with(holder.itemView.getContext())
                .load(listKhilafah.get(position).getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);

        holder.tvKhilafah.setText(khilafah.getKhilafah());
        holder.tvDes.setText(khilafah.getDes());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveIntent = new Intent(view.getContext(),DetailKhilafahAdapt.class);
                moveIntent.putExtra("objek", listKhilafah.get(position));
                view.getContext().startActivity(moveIntent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return listKhilafah.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder  {
        ImageView imgPhoto;
        TextView tvKhilafah, tvDes;

        CardViewHolder(View itemView){
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_itemk);
            tvKhilafah = itemView.findViewById(R.id.itm_namek);
            tvDes = itemView.findViewById(R.id.itm_desk);

        }
    }
}
