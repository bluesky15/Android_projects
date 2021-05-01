package com.lkb.baseandroidproject

import android.util.Log
import java.time.Instant

class Util {
    companion object {
        /**
         * phone number and first name and last name are used to create unique id
         * user id.
         */
        fun generateUserId(phoneNumber: Long, name: String): String {
            val preText = name.trim().split(" ")
            return if (preText.size < 2 && preText[0].length > 2)
                "${preText[0].toCharArray()[0]}${preText[0].toCharArray()[1]}$phoneNumber".toLowerCase()
            else if (preText.size == 2 && preText[0].length > 2 && preText[1].length > 2)
                "${preText[0].toCharArray()[0]}${preText[1].toCharArray()[0]}$phoneNumber".toLowerCase()
            else
                "xx$phoneNumber"
        }
        fun dLog(msg:String){
            if(BuildConfig.DEBUG)
            Log.d("Prinstar",msg)
        }
        fun getCurrentTimeEpoch(): Long {
            return Instant.now().epochSecond
        }
    }
}