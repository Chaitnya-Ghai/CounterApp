package com.example.mvvminjetpackcompos

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel :ViewModel(){
    private var _count =  mutableStateOf(0)
    val count = _count


    fun increaseCount(){
        _count.value++;
    }
    fun decreasesCount(){
        _count.value--
    }
}