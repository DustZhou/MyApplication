package com.example.myapplication.Fragment.Goods.Child.ChildPager;

import static com.example.myapplication.Dao.DaoPType.GetPriceType;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.FragBAdapter;
import com.example.myapplication.Entity.AddPTypeInfo.PriceType;
import com.example.myapplication.Entity.AddPTypeInfo.Units;
import com.example.myapplication.R;
import com.example.myapplication.Utils.DiySpinner;
import com.example.myapplication.ViewModel.AddGoodsModel;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;

public class FragmentB extends SupportFragment {
    private static final String ARG_TYPE = "arg_type";
    private DiySpinner diySpinner = new DiySpinner();
    private AddGoodsModel model;
    private TextView mUnits;
    RecyclerView mRecyclerView;
    List<PriceType> mPriceType = new ArrayList<>();
    FragBAdapter mAdapter;

    public static FragmentB newInstance() {
        Bundle args = new Bundle();
        FragmentB fragment = new FragmentB();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        mUnits = (TextView) view.findViewById(R.id.name_unit);
        initView(view);
        return view;
    }

    String str;

    @SuppressLint("NotifyDataSetChanged")
    public void iniUntil() {
        model.stringList = new ArrayList<>();
        List<Units> valueList = new ArrayList<Units>();//转换成list
        if (model.UnitsMap.get("UnitID1") != null) {
            model.stringList.add("UnitID1");
            valueList.add(model.UnitsMap.get("UnitID1"));
        }
        if (model.UnitsMap.get("UnitID2") != null) {
            model.stringList.add("UnitID2");
            valueList.add(model.UnitsMap.get("UnitID2"));
        }
        if (model.UnitsMap.get("UnitID3") != null) {
            model.stringList.add("UnitID3");
            valueList.add(model.UnitsMap.get("UnitID3"));
        }
        if (model.stringList.size()>0){
            mUnits.setText(valueList.get(0).getFullName());
        }
        diySpinner.DiySpinner1(valueList, mUnits, getActivity());
//        mUnits.setAdapter(new SpinnerAdapter(_mActivity, valueList));
//        mUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                str = stringList.get(i);
//                mAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
        mAdapter = new FragBAdapter(mPriceType, model, model.stringList.contains(model.str) ? model.str : (model.stringList.size() == 0 ? "" : model.stringList.get(0)));
        LinearLayoutManager layoutManager = new LinearLayoutManager(_mActivity);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void initView(View view) {
        model = new ViewModelProvider(requireActivity()).get(AddGoodsModel.class);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mPriceType = GetPriceType();
    }
}
