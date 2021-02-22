package com.worklin.motionlayout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FoodViewmodel {

    private val _listFoods = MutableLiveData<List<Food>>()
    val listFoods: LiveData<List<Food>> get() = _listFoods

    fun setFood(foods: List<Food>) {
        _listFoods.value = foods
    }

}