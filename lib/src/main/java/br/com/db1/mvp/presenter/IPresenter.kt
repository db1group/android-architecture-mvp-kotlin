package br.com.db1.mvp.presenter

import br.com.db1.mvp.view.IView

/**
 * Created by vinicius.camargo on 04/05/2018.
 */
interface IPresenter<V : IView> {

    fun isViewAttached(): Boolean

    fun getView(): V?

    fun attachView(view: V)

    fun detachView()

}