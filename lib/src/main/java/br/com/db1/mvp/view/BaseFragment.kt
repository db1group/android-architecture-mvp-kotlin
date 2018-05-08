package br.com.db1.mvp.view

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatDelegate
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import br.com.db1.mvp.util.LogUtils
import butterknife.ButterKnife

/**
 * Created by vinicius.camargo on 04/05/2018
 */
abstract class BaseFragment : Fragment(), IView {

    @get:LayoutRes
    protected abstract val contentViewRes: Int

    private lateinit var viewDecorator: BaseViewDecorator

    protected abstract fun initializeComponents()

    protected open fun terminateComponents() {}

    protected fun setViewDecorator(viewDecorator: BaseViewDecorator) {
        this.viewDecorator = viewDecorator
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(contentViewRes, container, false)
        ButterKnife.bind(this, view)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity == null)
            RuntimeException()
        else
            viewDecorator = BaseViewDecorator(activity!!)
        initializeComponents()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        terminateComponents()
    }

    @Throws(IllegalViewStateException::class)
    protected fun validateView() {
        if (!isAdded) {
            throw IllegalViewStateException("Fragment is not in a valid state.")
        }
    }

    override fun showMessage(@StringRes titleRes: Int, @StringRes messageRes: Int,
                             onEvent: DialogInterface.OnClickListener?) {
        try {
            validateView()
            viewDecorator.showMessage(titleRes, messageRes, onEvent)

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }

    override fun showMessage(@StringRes titleRes: Int, message: String,
                             onEvent: DialogInterface.OnClickListener?) {
        try {
            validateView()
            viewDecorator.showMessage(titleRes, message, onEvent)

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }

    override fun showMessage(titleRes: Int, messageRes: Int) {
        try {
            validateView()
            viewDecorator.showMessage(titleRes, messageRes)

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }

    override fun showMessage(titleRes: Int, message: String) {
        try {
            validateView()
            viewDecorator.showMessage(titleRes, message)

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }

    override fun showYesNo(@StringRes titleRes: Int, @StringRes messageRes: Int,
                           @StringRes positiveLabel: Int,
                           onPositiveEvent: DialogInterface.OnClickListener?,
                           @StringRes negativeLabel: Int,
                           onNegativeEvent: DialogInterface.OnClickListener?) {
        try {
            validateView()
            viewDecorator.showYesNo(titleRes, messageRes,
                    positiveLabel, onPositiveEvent,
                    negativeLabel, onNegativeEvent)

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }


    override fun showYesNo(@StringRes titleRes: Int, message: String,
                           @StringRes positiveLabel: Int,
                           onPositiveEvent: DialogInterface.OnClickListener?,
                           @StringRes negativeLabel: Int,
                           onNegativeEvent: DialogInterface.OnClickListener?) {
        try {
            validateView()
            viewDecorator.showYesNo(titleRes, message,
                    positiveLabel, onPositiveEvent,
                    negativeLabel, onNegativeEvent)

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }

    override fun showMessage(@DrawableRes iconRes: Int, @StringRes titleRes: Int,
                             @StringRes messageRes: Int,
                             onEvent: DialogInterface.OnClickListener?) {
        try {
            validateView()
            viewDecorator.showMessage(iconRes, titleRes, messageRes, onEvent)

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }

    override fun showMessage(@DrawableRes iconRes: Int, @StringRes titleRes: Int,
                             message: String,
                             onEvent: DialogInterface.OnClickListener?) {
        try {
            validateView()
            viewDecorator.showMessage(iconRes, titleRes, message, onEvent)

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }

    override fun showMessageWithoutTitle(@StringRes messageRes: Int, @StringRes buttonLabel: Int, onEvent: DialogInterface.OnClickListener?) {
        try {
            validateView()
            viewDecorator.showMessageWithoutTitle(messageRes, buttonLabel, onEvent)

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }

    override fun showMessageWithoutTitle(message: String, @StringRes buttonLabel: Int, onEvent: DialogInterface.OnClickListener?) {
        try {
            validateView()
            viewDecorator.showMessageWithoutTitle(message, buttonLabel, onEvent)

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }

    override fun showProgress(message: String) {
        try {
            validateView()
            viewDecorator.showProgress(message)

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }

    override fun showProgress(@StringRes messageRes: Int) {
        try {
            validateView()
            viewDecorator.showProgress(messageRes)

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }

    override fun hideProgress() {
        try {
            validateView()
            viewDecorator.hideProgress()

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }

    override fun showEmptyState() {
        try {
            validateView()
            viewDecorator.showEmptyState()

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }

    override fun hideEmptyState() {
        try {
            validateView()
            viewDecorator.hideEmptyState()

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }

    fun closeKeyBoard(view: View) {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, DEFAULT_EMPTY_INT)
    }

    companion object {
        private val TAG = BaseFragment::class.java.simpleName
        private const val DEFAULT_EMPTY_INT = 0
    }
}