package com.example.recyclerview_tutorial;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerView_adapter extends RecyclerView.Adapter<RecyclerView_adapter.ViewHolder>{

    private ArrayList<RecyclerView_list> list_RecyclerView;
    private Context context;

    public RecyclerView_adapter(ArrayList<RecyclerView_list> list_RecyclerView, Context context) {
        this.list_RecyclerView = list_RecyclerView;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView_adapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(list_RecyclerView.get(position).getImage());
        holder.textView.setText(list_RecyclerView.get(position).getText());

        holder.cardView.setOnClickListener(e->{
            Intent intent =new Intent(context,Pages.class);
            intent.putExtra("id", position);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list_RecyclerView.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);


        }
    }
}
