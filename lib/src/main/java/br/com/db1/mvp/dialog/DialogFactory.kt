package br.com.db1.mvp.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.support.annotation.DrawableRes

/**
 * Created by vinicius.camargo on 04/05/2018.
 */
open class DialogFactory {
    companion object {
        private fun createBuilderDialog(context: Context,
                                        message: String): AlertDialog.Builder {
            return AlertDialog.Builder(context).setMessage(message)
        }

        fun makeOneOptionDialog(context: Context,
                                title: String,
                                message: String,
                                buttonOkText: String,
                                positiveListener: DialogInterface.OnClickListener?): Dialog {
            return createBuilderDialog(context, message)
                    .setTitle(title)
                    .setPositiveButton(buttonOkText, positiveListener)
                    .create()
        }

        fun makeDialogNoAction(context: Context,
                               title: String,
                               message: String,
                               @DrawableRes icon: Int): Dialog {
            return createBuilderDialog(context, message).setTitle(title).setIcon(icon).create()
        }

        fun makeDialogNoTitle(context: Context,
                              message: String,
                              buttonLabel: String,
                              onEvent: DialogInterface.OnClickListener?): Dialog {
            return createBuilderDialog(context, message)
                    .setPositiveButton(buttonLabel, onEvent)
                    .create()
        }

        fun makeYesNoDialog(context: Context,
                            title: String,
                            message: String,
                            buttonYesText: String,
                            positiveListener: DialogInterface.OnClickListener?,
                            buttonNoText: String,
                            negativeListener: DialogInterface.OnClickListener?): Dialog {
            return createBuilderDialog(context, message)
                    .setTitle(title)
                    .setPositiveButton(buttonYesText, positiveListener)
                    .setNegativeButton(buttonNoText, negativeListener)
                    .create()
        }

    }
}