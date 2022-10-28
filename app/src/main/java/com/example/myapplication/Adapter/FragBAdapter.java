package com.example.myapplication.Adapter;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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

import java.util.HashMap;
import java.util.List;

public class FragBAdapter extends RecyclerView.Adapter<FragBAdapter.RecyclerHolder> {
    private List<PriceType> mPriceType;
    AddGoodsModel model;
    String str;

    public FragBAdapter(List<PriceType> mPriceType, AddGoodsModel model, String str) {
        this.mPriceType = mPriceType;
        this.str = str;
        this.model = model;

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

        holder.inputprice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 输入的内容变化的监听
                Log.e("输入过程中执行该方法", "文字变化");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 输入前的监听
                Log.e("输入前确认执行该方法", "开始输入");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                HashMap<String, String> c = new HashMap<String, String>();
                if (model.mUnitListPriceMap.get(str) != null) {

                    c.putAll(model.mUnitListPriceMap.get(str));
                }
                c.put(mPriceType.get(position).getPriceType(), holder.inputprice.getText().toString());
                model.mUnitListPriceMap.put(str, c);
                // 输入后的监听
                Log.e("输入结束执行该方法", "输入结束");
            }
        });
        if (model.mUnitListPriceMap != null) {
            if (model.mUnitListPriceMap.get(str).get(mPriceType.get(position).getPriceType()) != null) {
                holder.inputprice.setText(model.mUnitListPriceMap.get(str).get(mPriceType.get(position).getPriceType()));
            }else {

            }
        }

    }


    @Override
    public int getItemCount() {
        return mPriceType.size();
    }

    class RecyclerHolder extends RecyclerView.ViewHolder {
        TextView textView;
        EditText inputprice;

        private RecyclerHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.price);
            inputprice = (EditText) itemView.findViewById(R.id.et_inputprice);

        }

    }
}
