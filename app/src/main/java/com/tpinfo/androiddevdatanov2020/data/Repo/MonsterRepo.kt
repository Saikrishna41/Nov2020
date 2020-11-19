package com.tpinfo.androiddevdatanov2020.data.Repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.tpinfo.androiddevdatanov2020.R
import com.tpinfo.androiddevdatanov2020.data.Monster
import com.tpinfo.androiddevdatanov2020.utils.FileHelper
import java.util.logging.FileHandler

class MonsterRepo (val app : Application) {

    val monsterData = MutableLiveData<List<Monster>>()

    val listType = Types.newParameterizedType(
        List::class.java,
        Monster::class.java
    )

    init {

        getTextFromRawFile()
    }

    fun getTextFromRawFile() {

        val monsters = FileHelper.getTextFromRaw(app, R.raw.monster_data)

        val moshi =  Moshi.Builder().build()

        val adapter : JsonAdapter<List<Monster>> = moshi.adapter(listType)

        val mData = adapter.fromJson(monsters)

        monsterData.postValue(mData ?: emptyList())

    }

}