package com.example.emanuel;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recycler extends RecyclerView.Adapter<recycler.ViewHolder> {
    Context con;
    voz voz=null;
    private List<auxiliar2> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    recycler(Context context, List<auxiliar2> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.con = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.records, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Integer image = mData.get(position).getImage();
        final String text = mData.get(position).getClicks();
        final String text2 = mData.get(position).getTime();

        holder.clicksV.setText(text);
        holder.imagenV.setImageResource(image);
        holder.tiempoV.setText(text2);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tiempoV;
        TextView clicksV;
        ImageView imagenV;


        ViewHolder(View itemView) {
            super(itemView);
            tiempoV = itemView.findViewById(R.id.textView7);
            clicksV = itemView.findViewById(R.id.textView8);

            imagenV=itemView.findViewById(R.id.imageView3);


            itemView.setOnClickListener(this);


        }







        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }

    }

    // convenience method for getting data at click position
    auxiliar2 getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    protected void onDestroy()
    {
        onDestroy();
        this.voz.shutDown();
    }
    // parent activity will implement this method to respond to click events


    public static abstract interface ItemClickListener
    {
        public abstract void onItemClick(View paramView, int paramInt);
    }


}
