package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Entity.AddPTypeInfo.PriceType;
import com.example.myapplication.R;

import java.util.List;

public class FragBAdapter extends RecyclerView.Adapter<FragBAdapter.RecyclerHolder> {
    private List<PriceType> mPriceType;

    public FragBAdapter(List<PriceType> mPriceType) {
        this.mPriceType = mPriceType;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragb, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        PriceType priceType = mPriceType.get(position);
        holder.textView.setText(priceType.getFullName());
    }


    @Override
    public int getItemCount() {
        return mPriceType.size();
    }

    class RecyclerHolder extends RecyclerView.ViewHolder {
        TextView textView;

        private RecyclerHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.price);
        }

    }
}
