package com.tpinfo.androiddevdatanov2020.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.tpinfo.androiddevdatanov2020.data.Monster
import com.tpinfo.androiddevdatanov2020.data.Repo.MonsterRepo

class MainFragmentViewModel(app: Application) : AndroidViewModel(app) {

    private val mRepo = MonsterRepo(app)

    var mData = MutableLiveData<List<Monster>>()

    init {

        mData = mRepo.monsterData

    }
}