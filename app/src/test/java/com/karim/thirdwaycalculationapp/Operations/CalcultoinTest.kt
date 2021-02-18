package com.karim.thirdwaycalculationapp.Operations

import org.junit.Assert.*
import org.junit.Test

class CalcultoinTest{

    @Test
    fun `check if the summation function is working well`(){
        val result=Calcultoin.sum(4.0,2.0)
        val actualResult:Double=6.0
        assertEquals(result,actualResult.toString())
    }


    @Test
    fun `check if the multiplication function is working well`(){
        val result=Calcultoin.multiplication(4.0,2.0)
        val actualResult:Double=8.0
        assertEquals(result,actualResult.toString())
    }

    @Test
    fun `check if the division function is working well`(){
        val result=Calcultoin.division(4.0,2.0)
        val actualResult:Double=2.0
        assertEquals(result,actualResult.toString())
    }

    @Test
    fun `check if the subtraction function is working well`(){
        val result=Calcultoin.subtraction(4.0,2.0)
        val actualResult:Double=2.0
        assertEquals(result,actualResult.toString())
    }
}