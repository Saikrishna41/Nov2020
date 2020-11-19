package com.tpinfo.androiddevdatanov2020.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.tpinfo.androiddevdatanov2020.R
import com.tpinfo.androiddevdatanov2020.utils.TAG
import com.tpinfo.androiddevdatanov2020.viewmodel.MainFragmentViewModel


class MainActivityFragment : Fragment() {

    private lateinit var viewModelProvider : MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModelProvider = ViewModelProvider(requireActivity()).get(MainFragmentViewModel::class.java)

        viewModelProvider.mData.observe(viewLifecycleOwner, Observer {

            for(monster in it) {

                Log.d(TAG, "Monster Name ${monster.monsterName}")
            }
        })
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_activity, container, false)
    }

}