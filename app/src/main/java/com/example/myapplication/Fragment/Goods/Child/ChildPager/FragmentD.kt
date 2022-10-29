package com.example.myapplication.Fragment.Goods.Child.ChildPager

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.ViewModel.AddGoodsModel
import me.yokeyword.fragmentation.SupportFragment

class FragmentD : SupportFragment() {
    private lateinit var viewModel: AddGoodsModel

    companion object {
        @JvmStatic
        fun newInstance(): FragmentD {
            var args = Bundle()
            val fragment = FragmentD()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(AddGoodsModel::class.java)
        return inflater.inflate(R.layout.fragment_d, container, false)
    }
}