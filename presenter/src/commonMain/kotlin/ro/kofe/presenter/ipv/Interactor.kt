package ro.kofe.presenter.ipv

interface Interactor<V : View> {
    fun setView(view: V)
    fun shutdown()
    fun viewPaused()
    fun viewResumed()
}