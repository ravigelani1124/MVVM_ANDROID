package com.learning.mvvm_android

import com.learning.mvvm_android.util.Util
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private lateinit var util: Util

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Before
    fun setup(){
        util= Util()
    }
    @Test
    fun testSum(){
        assertEquals(8,util.sum(3,5))
    }

}