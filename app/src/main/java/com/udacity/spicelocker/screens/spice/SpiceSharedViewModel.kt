package com.udacity.spicelocker.screens.spice

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.udacity.spicelocker.models.Spice
import timber.log.Timber

class SpiceSharedViewModel : ViewModel() {
    private  var _spiceList = MutableLiveData<ArrayList<Spice>>()
    val spiceList : LiveData<ArrayList<Spice>>
        get() = _spiceList



    init {

        _spiceList.value = ArrayList()
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

    fun saveSpiceClick(view : View, spice: Spice){
        Timber.w("SpiceSharedModel Save Spice - %s",spice.name)
        _spiceList.value?.add(spice)
        view.findNavController().navigateUp()
    }




}