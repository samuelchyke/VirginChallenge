package com.itc.virginmoneydeveloperchallenge.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    private val sdf = SimpleDateFormat("HH:mm:ss")
    private val sdf2 = SimpleDateFormat("dd/MM/yyyy")

    // sdf = Ex: Thu, Jun 9, '22
    fun stringToDate(string: String?): String{
        return sdf2.format(string)
    }

}