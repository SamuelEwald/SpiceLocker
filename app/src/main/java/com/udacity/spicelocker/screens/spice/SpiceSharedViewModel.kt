package com.udacity.spicelocker.screens.spice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.spicelocker.models.Spice
import timber.log.Timber

class SpiceSharedViewModel : ViewModel() {
    private  val _spiceList = MutableLiveData<MutableList<Spice>>()
    val spiceList : LiveData<MutableList<Spice>>
        get() = _spiceList

    private val _spiceDetail = MutableLiveData<Spice>()
    val spiceDetail : LiveData<Spice>
        get() = _spiceDetail


    init {

        _spiceList.value = mutableListOf()
        spiceList.value!!.add(Spice(
            "Oregano",
            "oz",
            16.0,
            3.5,
            "McCormick",
            "Ground Organic Oregano"
        ))
        spiceList.value!!.add(Spice(
            "Pink Salt",
            "oz",
            24.0,
            3.5,
            "Kirkland",
            "Pink Salt Grinder"

        ))



    }

    public fun saveSpice(spice: Spice){
        Timber.w("SpiceSharedModel Save Spice - %s",spice.name)
        spiceList.value!!.add(spice)

    }


}