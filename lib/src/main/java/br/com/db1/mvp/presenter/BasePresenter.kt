package br.com.db1.mvp.presenter

import br.com.db1.mvp.view.IView
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by vinicius.camargo on 04/05/2018.
 */
open class BasePresenter<V : IView> : IPresenter<V> {


    private var view: V? = null

    @JvmField
    protected var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    override fun isViewAttached(): Boolean {
        return this.view != null
    }

    override fun getView(): V? {
        return view
    }

    override fun attachView(view: V) {
        if (this.view == null) {
            this.view = view
        } else {
            clearDisposable()
        }
    }

    override fun detachView() {
        view = null
        clearDisposable()
    }

    private fun clearDisposable() {
        compositeDisposable?.isDisposed?.not() ?: compositeDisposable?.clear()
    }

}