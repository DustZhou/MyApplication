package com.example.myapplication.Fragment.Goods.Child.ChildPager;

import static com.example.myapplication.Dao.DaoPType.GetUnits;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Activity.GetStockActivity;
import com.example.myapplication.Adapter.SpinnerAdapter;
import com.example.myapplication.R;

import com.example.myapplication.Utils.DiySpinner;
import com.example.myapplication.ViewModel.AddGoodsModel;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * @ProjectName: FragmentA
 * @Package: com.example.myapplication.Fragment.Goods.Child.ChildPager
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */
public class FragmentA extends SupportFragment {
    private AddGoodsModel model;
    private DiySpinner diySpinner = new DiySpinner();
    private Button butPush;
    private TextView tvUnits;
    private TextView tvUnits1;
    private TextView tvUnits2;
    private String GoodsParID;
    private String GoodsName;
    EditText etFullName;
    EditText etStandard;
    EditText etType;
    EditText etArea;
    EditText etUserCode;
    TextView etNameCategory;
    Button btnClear;
    Button btnClear1;

    public static FragmentA newInstance() {
        Bundle args = new Bundle();
        FragmentA fragment = new FragmentA();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        butPush = (Button) view.findViewById(R.id.but_push);
        tvUnits = (TextView) view.findViewById(R.id.name_unit);
        tvUnits1 = (TextView) view.findViewById(R.id.name_unit1);
        tvUnits2 = (TextView) view.findViewById(R.id.name_unit2);
        etFullName = (EditText) view.findViewById(R.id.goods_name);
        etStandard = (EditText) view.findViewById(R.id.name_specification1);
        etType = (EditText) view.findViewById(R.id.name_specification2);
        etArea = (EditText) view.findViewById(R.id.name_origin);
        etUserCode = (EditText) view.findViewById(R.id.name_numbering);
        etNameCategory = (TextView) view.findViewById(R.id.name_category);
        btnClear = (Button) view.findViewById(R.id.btn_clear);
        btnClear1 = (Button) view.findViewById(R.id.btn_clear1);
        initView(view);
        return view;
    }

    /**
     * A界面初始化的方法
     *
     * @param view
     */
    private void initView(View view) {
        model = new ViewModelProvider(requireActivity()).get(AddGoodsModel.class);
        model.SpinnerList.clear();
        model.SpinnerList.addAll(GetUnits());
        diySpinner.DiySpinner("UnitID1", this, tvUnits, getActivity(), model);
        diySpinner.DiySpinner("UnitID2", this, tvUnits1, getActivity(), model);
        diySpinner.DiySpinner("UnitID3", this, tvUnits2, getActivity(), model);

        etNameCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GetStockActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        butPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.root.setFullName(etFullName.getText().toString());
                model.root.setStandard(etStandard.getText().toString());
                model.root.setType(etType.getText().toString());
                model.root.setArea(etArea.getText().toString());
                model.root.setUserCode(etUserCode.getText().toString());
                model.root.setParID(GoodsParID);
                Toast.makeText(getActivity(), model.root.toString(), Toast.LENGTH_LONG).show();
            }
        });
        //第一个清除单位和价格
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvUnits1.setText(null);
                model.UnitsMap.remove("UnitID2");
                model.mUnitListPriceMap.remove("UnitID2");
            }
        });
        //第二个清除单位和价格
        btnClear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    GoodsName = data.getStringExtra("GoodsName");
                    GoodsParID = data.getStringExtra("GoodsParID");
                    etNameCategory.setText(GoodsName);
                }
                break;
        }

    }
}

