package br.com.db1.mvp.view

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import br.com.db1.mvp.R
import br.com.db1.mvp.R2
import br.com.db1.mvp.util.LogUtils
import butterknife.BindView
import butterknife.ButterKnife

/**
 * Created by vinicius.camargo on 04/05/2018
 */
class EmptyStateComponent(context: Context) : RelativeLayout(context), IEmptyStateComponent {
    companion object {
        private val TAG = EmptyStateComponent::class.java.simpleName
    }

    private var parent: ViewGroup? = null
    private var target: ViewGroup? = null

    @BindView(R2.id.cpt_empty_state_iv_image)
    var ivImage: ImageView? = null

    @BindView(R2.id.cpt_empty_state_tv_message)
    var tvMessage: TextView? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.component_empty_state, this)
        ButterKnife.bind(this)
    }


    fun setParent(parent: ViewGroup): EmptyStateComponent {
        this.parent = parent
        return this
    }

    fun setTarget(target: ViewGroup): EmptyStateComponent {
        this.target = target
        return this
    }

    fun setImage(@DrawableRes imageRes: Int): EmptyStateComponent {
        if (isValid()) {
            ivImage?.setBackgroundResource(imageRes)
        }
        return this
    }

    fun setMessage(@StringRes messageRes: Int): EmptyStateComponent {
        tvMessage?.setText(messageRes)
        return this
    }

    override fun show() {
        if (isValid()) {
            val index = parent?.indexOfChild(target) ?: 0
            if (index > 0) {
                parent?.removeViewAt(index)
                parent?.addView(this, index)
            }
        }
    }

    override fun hide() {
        if (isValid()) {
            val index = parent?.indexOfChild(this) ?: 0
            if (index >= 0) {
                parent?.removeViewAt(index)
                parent?.addView(target, index)
            }
        }
    }

    private fun isValid(): Boolean {
        if (parent == null || target == null) {
            LogUtils.error(TAG, "parent and target cannot be null.")
            return false
        }
        return true
    }
}
