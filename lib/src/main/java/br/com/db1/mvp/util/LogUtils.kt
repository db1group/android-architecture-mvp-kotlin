package br.com.db1.mvp.util

import android.util.Log
import com.crashlytics.android.Crashlytics

/**
 * Created by vinicius.camargo on 04/05/2018.
 */
object LogUtils {
    @JvmStatic
    fun error(tag: String, message: String) {
        Crashlytics.log(Log.ERROR, tag, message)
    }

    @JvmStatic
    fun error(tag: String, throwable: Throwable) {
        Crashlytics.log(Log.ERROR, tag, Log.getStackTraceString(throwable))
    }

}