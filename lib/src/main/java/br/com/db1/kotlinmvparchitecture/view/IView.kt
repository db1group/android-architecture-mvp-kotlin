package br.com.db1.kotlinmvparchitecture.view

import android.content.DialogInterface
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes

/**
 * Created by vinicius.camargo on 04/05/2018.
 */
interface IView {


    fun showMessage(@StringRes titleRes: Int, @StringRes messageRes: Int,
                    onEvent: DialogInterface.OnClickListener?)

    fun showMessage(@StringRes titleRes: Int, message: String,
                    onEvent: DialogInterface.OnClickListener?)

    fun showMessage(@StringRes titleRes: Int, @StringRes messageRes: Int)

    fun showMessage(@StringRes titleRes: Int, message: String)

    fun showMessage(@DrawableRes iconRes: Int, @StringRes titleRes: Int, @StringRes messageRes: Int,
                    onEvent: DialogInterface.OnClickListener?)

    fun showMessage(@DrawableRes iconRes: Int, @StringRes titleRes: Int, message: String,
                    onEvent: DialogInterface.OnClickListener?)

    fun showMessageWithoutTitle(@StringRes messageRes: Int,
                                @StringRes buttonLabel: Int,
                                onEvent: DialogInterface.OnClickListener?)

    fun showMessageWithoutTitle(message: String,
                                @StringRes buttonLabel: Int,
                                onEvent: DialogInterface.OnClickListener?)

    fun showYesNo(@StringRes titleRes: Int, @StringRes messageRes: Int,
                  @StringRes positiveLabel: Int,
                  onPositiveEvent: DialogInterface.OnClickListener?,
                  @StringRes negativeLabel: Int,
                  onNegativeEvent: DialogInterface.OnClickListener?)

    fun showYesNo(@StringRes titleRes: Int, message: String,
                  @StringRes positiveLabel: Int,
                  onPositiveEvent: DialogInterface.OnClickListener?,
                  @StringRes negativeLabel: Int,
                  onNegativeEvent: DialogInterface.OnClickListener?)


    fun showProgress(message: String)

    fun showProgress(@StringRes messageRes: Int)

    fun hideProgress()

    fun showEmptyState()

    fun hideEmptyState()

}