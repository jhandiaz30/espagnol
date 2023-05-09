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

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    Context con;
    voz voice =null;
    private List<auxiliar> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    MyRecyclerViewAdapter(Context context, List<auxiliar> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.con = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.elements, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        int image = mData.get(position).getImagen();
        final char texto = mData.get(position).getTexto();
        final String examples = mData.get(position).getExamples();
        holder.ejemplosV.setText(examples);
        holder.imagenV.setImageResource(image);



        voice =new voz();
        voice.init(this.con);

        holder.botonV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text= texto+"."+examples;
                voice.initQueue(text);

            }

        });
        //holder.imagenV.setT;
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageButton botonV;
        TextView ejemplosV;
        ImageView imagenV;
        LinearLayout linea;
        LinearLayout lineaZ;

        ImageButton buttonV;

        ViewHolder(View itemView) {
            super(itemView);
            ejemplosV = itemView.findViewById(R.id.textView);
            botonV = itemView.findViewById(R.id.imageButton2);
            imagenV=itemView.findViewById(R.id.imageView);
            linea=itemView.findViewById(R.id.linea);
            buttonV= itemView.findViewById(R.id.imageButton2);
            lineaZ=itemView.findViewById(R.id.lin);

            itemView.setOnClickListener(this);
        }







        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }

    }

    // convenience method for getting data at click position
    auxiliar getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    protected void onDestroy()
    {
        onDestroy();
        this.voice.shutDown();
    }
    // parent activity will implement this method to respond to click events


    public static abstract interface ItemClickListener
    {
        public abstract void onItemClick(View paramView, int paramInt);
    }


}
