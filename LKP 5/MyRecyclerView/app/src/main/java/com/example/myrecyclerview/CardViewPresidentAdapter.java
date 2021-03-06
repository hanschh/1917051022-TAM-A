package com.example.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardViewPresidentAdapter extends RecyclerView.Adapter<CardViewPresidentAdapter.CardViewViewHolder> {

    private ArrayList<President>lisPresident;
    private Context context;

    public CardViewPresidentAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<President> getLisPresident() {
        return lisPresident;
    }

    public void setLisPresident(ArrayList<President> lisPresident) {
        this.lisPresident = lisPresident;
    }

    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_president, parent, false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position) {

        President p = getLisPresident().get(position);

        Glide.with(context)
                .load(p.getPhoto()).override(350,550).into(holder.imgphoto);
        holder.tvName.setText(p.getName());
        holder.tvRemarks.setText(p.getRemarks());

        holder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite "+getLisPresident().get(position).getName(),Toast.LENGTH_SHORT).show();

            }
        }));

        holder.btnshare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getLisPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));


        }


    @Override
    public int getItemCount() {
        return getLisPresident().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
         ImageView imgphoto;
         TextView tvName, tvRemarks;
         Button btnFavorite, btnshare;

        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgphoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView)itemView.findViewById(R.id.tv_item_remarks);
            btnshare = (Button)itemView.findViewById(R.id.btn_set_share);
            btnFavorite = (Button)itemView.findViewById(R.id.btn_set_favorite);
        }
    }
}
