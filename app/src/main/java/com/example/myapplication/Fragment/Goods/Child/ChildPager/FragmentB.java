package com.example.myapplication.Fragment.Goods.Child.ChildPager;

import static com.example.myapplication.Dao.DaoPType.GetPriceType;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.FragBAdapter;
import com.example.myapplication.Adapter.SpinnerAdapter;
import com.example.myapplication.Entity.AddPTypeInfo.PriceType;
import com.example.myapplication.Entity.AddPTypeInfo.Units;
import com.example.myapplication.R;
import com.example.myapplication.ViewModel.AddGoodsModel;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;

public class FragmentB extends SupportFragment {
    private static final String ARG_TYPE = "arg_type";
    private AddGoodsModel model;
    private Spinner mUnits;
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
        mUnits = (Spinner) view.findViewById(R.id.name_unit);
        initView(view);
        return view;
    }
    String str;
    List<String> stringList;
    public void iniUntil() {
        stringList =new ArrayList<>();
        List<Units> valueList = new ArrayList<Units>();//转换成list
        if ( model.UnitsMap.get("UnitID1")!=null){
            stringList.add( "UnitID1") ;          ;
                    valueList.add(model.UnitsMap.get("UnitID1"));
        }
        if ( model.UnitsMap.get("UnitID2")!=null){
            stringList.add( "UnitID2");
            valueList.add(model.UnitsMap.get("UnitID2"));
        }
        if ( model.UnitsMap.get("UnitID3")!=null){
            stringList.add( "UnitID3");
            valueList.add(model.UnitsMap.get("UnitID3"));
        }
        mUnits.setAdapter(new SpinnerAdapter(_mActivity,valueList));
        mAdapter = new FragBAdapter(mPriceType,model,stringList.contains(str)?str:(stringList.size()==0?"":stringList.get(0)));
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
