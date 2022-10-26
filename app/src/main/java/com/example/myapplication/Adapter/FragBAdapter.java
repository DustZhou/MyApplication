package com.example.myapplication.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Entity.AddPTypeInfo.PriceType;
import com.example.myapplication.R;
import com.example.myapplication.ViewModel.AddGoodsModel;

import java.util.List;

public class FragBAdapter extends RecyclerView.Adapter<FragBAdapter.RecyclerHolder> {
    private List<PriceType> mPriceType;
    AddGoodsModel model;
    public FragBAdapter(List<PriceType> mPriceType, AddGoodsModel model) {
        this.mPriceType = mPriceType;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragb, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, @SuppressLint("RecyclerView") int position) {
        PriceType priceType = mPriceType.get(position);
        holder.textView.setText(priceType.getFullName());
        holder.putprice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                model.priceDataMap.put(mPriceType.get(position).getPriceType(),holder.putprice.getText().toString());
            }
        });
        holder.putprice.setText(model.priceDataMap.get(mPriceType.get(position).getPriceType())+"");

    }


    @Override
    public int getItemCount() {
        return mPriceType.size();
    }

    class RecyclerHolder extends RecyclerView.ViewHolder {
        TextView textView;
        EditText putprice;
        private RecyclerHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.price);
            putprice = (EditText) itemView.findViewById(R.id.putprice);

        }

    }
}
