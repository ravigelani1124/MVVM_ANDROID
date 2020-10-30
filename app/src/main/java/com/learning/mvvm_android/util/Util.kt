package com.learning.mvvm_android.util

internal class Util {

    fun getCurrentTimeStamp() :String{
        return  System.currentTimeMillis().toString()
    }

    fun sum (a:Int, b:Int) : Int{
        return a+b
    }
}