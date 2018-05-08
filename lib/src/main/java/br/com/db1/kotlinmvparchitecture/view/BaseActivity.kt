package br.com.db1.kotlinmvparchitecture.view

import android.content.DialogInterface
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.view.View
import android.view.WindowManager
import br.com.db1.kotlinmvparchitecture.util.LogUtils
import butterknife.ButterKnife
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by vinicius.camargo on 04/05/2018
 */
abstract class BaseActivity : AppCompatActivity(), IView {

    @get:LayoutRes
    protected abstract val contentViewRes: Int

    private lateinit var viewDecorator: BaseViewDecorator

    protected open val isStatusBarTransparent: Boolean
        get() = false

    private val compositeDisposable = CompositeDisposable()

    protected abstract fun initializeComponents()

    protected open fun terminateComponents() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        setContentView(contentViewRes)
        ButterKnife.bind(this)

        viewDecorator = BaseViewDecorator(this)
        setupStatusBarTransparency(isStatusBarTransparent)

        initializeComponents()
    }

    override fun onStart() {
        super.onStart()
        if (runningActivities == 0) {
            didEnterForeground()
        }
        incrementRunningActivities()
    }

    override fun onStop() {
        super.onStop()
        decrementRunningActivities()
    }

    override fun onDestroy() {
        terminateComponents()
        clearDisposable()
        super.onDestroy()
    }

    private fun clearDisposable() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }

    protected fun didEnterForeground() {}

    @Throws(IllegalViewStateException::class)
    protected fun validateView() {
        if (!appIsInForeground()) {
            throw IllegalViewStateException("Activity is not in a valid state.")
        }
    }

    private fun setupStatusBarTransparency(statusBarTransparent: Boolean) {
        if (statusBarTransparent && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.statusBarColor = Color.TRANSPARENT
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

    override fun showMessage(@StringRes titleRes: Int, @StringRes messageRes: Int) {
        try {
            validateView()
            viewDecorator.showMessage(titleRes, messageRes)

        } catch (e: IllegalViewStateException) {
            LogUtils.error(TAG, e)
        } catch (e: IllegalStateException) {
            LogUtils.error(TAG, e)
        }

    }

    override fun showMessage(@StringRes titleRes: Int, message: String) {
        try {
            validateView()
            viewDecorator.showMessage(titleRes, message)

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

    companion object {

        private val TAG = BaseActivity::class.java.simpleName

        private var runningActivities = 0

        private fun incrementRunningActivities() {
            runningActivities++
        }

        private fun decrementRunningActivities() {
            runningActivities--
        }

        fun appIsInForeground(): Boolean {
            return runningActivities > 0
        }
    }

}