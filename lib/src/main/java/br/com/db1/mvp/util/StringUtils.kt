package br.com.db1.mvp.util

/**
 * Created by vinicius.camargo on 04/05/2018.
 */
object StringUtils {
    @JvmStatic
    fun isNotEmpty(value: String?): Boolean {
        return value?.trim()?.isNotEmpty() ?: "null" != value
    }

}