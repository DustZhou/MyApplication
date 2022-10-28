package com.example.myapplication.Fragment.Goods.Child.ChildPager;

import static com.example.myapplication.Dao.DaoPType.GetUnits;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Activity.GetStockActivity;
import com.example.myapplication.Adapter.SpinnerAdapter;
import com.example.myapplication.Entity.AddPTypeInfo.Units;
import com.example.myapplication.R;

import com.example.myapplication.Utils.DiySpinner;
import com.example.myapplication.ViewModel.AddGoodsModel;

import me.yokeyword.fragmentation.SupportFragment;

public class FragmentA extends SupportFragment {
    private AddGoodsModel model;
    private DiySpinner diySpinner = new DiySpinner();
    private Button button;
    private TextView Units;
    private TextView Units1;
    private TextView Units2;
    private String GoodsParID;
    private String GoodsName;
    EditText FullName;
    EditText Standard;
    EditText Type;
    EditText Area;
    EditText UserCode;
    TextView NameCategory;

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
        button = (Button) view.findViewById(R.id.but_push);
        Units = (TextView) view.findViewById(R.id.name_unit);
        Units1 = (TextView) view.findViewById(R.id.name_unit1);
        Units2 = (TextView) view.findViewById(R.id.name_unit2);
        FullName = (EditText) view.findViewById(R.id.goods_name);
        Standard = (EditText) view.findViewById(R.id.name_specification1);
        Type = (EditText) view.findViewById(R.id.name_specification2);
        Area = (EditText) view.findViewById(R.id.name_origin);
        UserCode = (EditText) view.findViewById(R.id.name_numbering);
        NameCategory = (TextView) view.findViewById(R.id.name_category);
        initView(view);
        return view;
    }

    private void initView(View view) {
        model = new ViewModelProvider(requireActivity()).get(AddGoodsModel.class);
        model.SpinnerList.addAll(GetUnits());
        diySpinner.DiySpinner("UnitID1", this, Units, getActivity(), model);
        diySpinner.DiySpinner("UnitID2", this, Units1, getActivity(), model);
        diySpinner.DiySpinner("UnitID3", this, Units2, getActivity(), model);

//        Units.setAdapter(new SpinnerAdapter(_mActivity, model.SpinnerList));
//        Units1.setAdapter(new SpinnerAdapter(_mActivity, model.SpinnerList));
//        Units2.setAdapter(new SpinnerAdapter(_mActivity, model.SpinnerList));


//        Units.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//                model.UnitsMap.put("UnitID1", (Units) adapterView.getItemAtPosition(position));
//                findFragment(FragmentB.class).iniUntil();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


//        Units.setContent((ArrayList<Units>) model.SpinnerList);
//        Units.setOnItemSelectedListener(new SimpleSpinner.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id, String content) {
//                model.UnitsMap.put("UnitID1", (Units)adapterView.getItemAtPosition(position));
//                findFragment(FragmentB.class).iniUntil();
//            }
//        });


//        Units1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
////                Toast.makeText(getActivity(), adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
//                model.UnitsMap.put("UnitID2", (Units) adapterView.getItemAtPosition(position));
//                findFragment(FragmentB.class).iniUntil();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//        Units2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//                model.UnitsMap.put("UnitID3", (Units) adapterView.getItemAtPosition(position));
//                findFragment(FragmentB.class).iniUntil();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

        NameCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GetStockActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.root.setFullName(FullName.getText().toString());
                model.root.setStandard(Standard.getText().toString());
                model.root.setType(Type.getText().toString());
                model.root.setArea(Area.getText().toString());
                model.root.setUserCode(UserCode.getText().toString());
                model.root.setParID(GoodsParID);

                Toast.makeText(getActivity(), model.root.toString(), Toast.LENGTH_LONG).show();
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
                    NameCategory.setText(GoodsName);
                }
                break;
        }

    }
//    public void setUserPosition(String userPosition) {
//        int selectIndex=-1;
//        for (int i=0;i<userPositionArray.length;i++){
//            if (userPositionArray[i].equals(userPosition)){
//                selectIndex=i;
//                break;
//            }
//        }
//        if (selectIndex<0) {
//            //如果没有找到对应的值，则显示为空白
//            spinnerUserPosition.getChildAt(0).setVisibility(View.INVISIBLE);
//        } else {
//            //如果找到对应的值，则显示子元素
//            spinnerUserPosition.getChildAt(0).setVisibility(View.VISIBLE);
//            spinnerUserPosition.setSelection(selectIndex);
//        }
//    }


//public void spinnerDefaultValue(String value) {
//    int selectIndex=-1;
//    for (int i=0;i<arr.size();i++){
//        if (arr.get(i).equals(value)){
//            selectIndex=i;
//            break;
//        }
//    }
//    if (selectIndex<0) {
//        //若是没有找到对应的值，则显示为空白
//        spinner.getChildAt(0).setVisibility(View.INVISIBLE);
//    } else {
//        //若是找到对应的值，则显示子元素
//        spinner.getChildAt(0).setVisibility(View.VISIBLE);
//        spinner.setSelection(selectIndex);
//    }
//}
}

