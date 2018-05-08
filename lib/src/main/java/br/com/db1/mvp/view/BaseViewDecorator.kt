package br.com.db1.mvp.view

import android.app.ProgressDialog
import android.content.DialogInterface
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.v4.app.FragmentActivity
import br.com.db1.mvp.R
import br.com.db1.mvp.dialog.DialogFactory
import br.com.db1.mvp.util.StringUtils

/**
 * Created by vinicius.camargo on 04/05/2018
 */

class BaseViewDecorator @JvmOverloads constructor(private val parentActivity: FragmentActivity,
                                                  private val emptyStateComponent: IEmptyStateComponent? = null) : IView {

    private val progressDialog: ProgressDialog = ProgressDialog(parentActivity)

    init {
        this.progressDialog.setCanceledOnTouchOutside(false)
    }

    override fun showMessage(@StringRes titleRes: Int, @StringRes messageRes: Int,
                             onEvent: DialogInterface.OnClickListener?) {
        showMessage(titleRes, parentActivity.getString(messageRes), onEvent)
    }

    override fun showMessage(@StringRes titleRes: Int, @StringRes messageRes: Int) {
        showMessage(titleRes, parentActivity.getString(messageRes), null)
    }

    override fun showMessage(@StringRes titleRes: Int, message: String) {
        DialogFactory.makeOneOptionDialog(parentActivity,
                parentActivity.getString(titleRes),
                message,
                parentActivity.getString(R.string.ok), null)
                .show()
    }

    override fun showMessage(@StringRes titleRes: Int, message: String,
                             onEvent: DialogInterface.OnClickListener?) {

        DialogFactory.makeOneOptionDialog(parentActivity,
                parentActivity.getString(titleRes),
                message,
                parentActivity.getString(R.string.ok),
                onEvent)
                .show()
    }


    override fun showYesNo(@StringRes titleRes: Int, @StringRes messageRes: Int,
                           @StringRes positiveLabel: Int,
                           onPositiveEvent: DialogInterface.OnClickListener?,
                           @StringRes negativeLabel: Int,
                           onNegativeEvent: DialogInterface.OnClickListener?) {
        showYesNo(titleRes,
                parentActivity.getString(messageRes),
                positiveLabel, onPositiveEvent,
                negativeLabel, onNegativeEvent)
    }

    override fun showYesNo(@StringRes titleRes: Int, message: String,
                           @StringRes positiveLabel: Int,
                           onPositiveEvent: DialogInterface.OnClickListener?,
                           @StringRes negativeLabel: Int,
                           onNegativeEvent: DialogInterface.OnClickListener?) {
        DialogFactory.makeYesNoDialog(
                parentActivity,
                parentActivity.getString(titleRes),
                message,
                parentActivity.getString(positiveLabel),
                onPositiveEvent,
                parentActivity.getString(negativeLabel),
                onNegativeEvent)
                .show()
    }

    override fun showMessage(@DrawableRes iconRes: Int, @StringRes titleRes: Int, message: String,
                             onEvent: DialogInterface.OnClickListener?) {
        DialogFactory.makeDialogNoAction(parentActivity,
                parentActivity.getString(titleRes),
                message,
                iconRes)
    }

    override fun showMessageWithoutTitle(messageRes: Int,
                                         @StringRes buttonLabel: Int,
                                         onEvent: DialogInterface.OnClickListener?) {
        DialogFactory.makeDialogNoTitle(
                parentActivity,
                parentActivity.getString(messageRes),
                parentActivity.getString(buttonLabel),
                onEvent)
                .show()
    }

    override fun showMessageWithoutTitle(message: String,
                                         @StringRes buttonLabel: Int,
                                         onEvent: DialogInterface.OnClickListener?) {
        DialogFactory.makeDialogNoTitle(
                parentActivity,
                message,
                parentActivity.getString(buttonLabel),
                onEvent)
                .show()
    }

    override fun showMessage(@DrawableRes iconRes: Int,
                             @StringRes titleRes: Int,
                             @StringRes messageRes: Int,
                             onEvent: DialogInterface.OnClickListener?) {
        DialogFactory.makeDialogNoAction(parentActivity,
                parentActivity.getString(titleRes),
                parentActivity.getString(messageRes),
                iconRes)
    }

    override fun showProgress(message: String) {
        progressDialog.setMessage(
                if (StringUtils.isNotEmpty(message))
                    message
                else
                    parentActivity.getString(R.string.progress_message_default))
        progressDialog.setCancelable(false)
        progressDialog.show()
    }

    override fun showProgress(@StringRes messageRes: Int) {
        progressDialog.setMessage(parentActivity.getString(messageRes))
        progressDialog.setCancelable(false)
        progressDialog.show()
    }

    override fun hideProgress() {
        progressDialog.dismiss()
    }

    override fun showEmptyState() {
        emptyStateComponent?.show()
    }

    override fun hideEmptyState() {
        emptyStateComponent?.hide()
    }

}