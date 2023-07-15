package ro.kofe.presenter.ipv

interface IPresenter<V : IView> {
    fun setView(view: V)
    fun shutdown()
}