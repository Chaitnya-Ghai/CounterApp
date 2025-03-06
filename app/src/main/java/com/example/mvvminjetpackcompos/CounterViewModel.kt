package com.example.mvvminjetpackcompos

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel :ViewModel(){
    private var _count =  mutableIntStateOf(0)
    val count :MutableState<Int> = _count

    fun increaseCount(){
        _count.intValue++
    }
    fun decreasesCount(){
        _count.intValue--
    }
}