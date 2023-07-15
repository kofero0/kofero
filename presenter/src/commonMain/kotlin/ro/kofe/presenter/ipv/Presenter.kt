package ro.kofe.presenter.ipv

interface Presenter<V : View> {
    fun setView(view: V)
    fun shutdown()
}