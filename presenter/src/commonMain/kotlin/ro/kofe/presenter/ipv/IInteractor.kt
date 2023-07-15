package ro.kofe.presenter.ipv

interface IInteractor<V : IView> {
    fun setView(view: V)
    fun shutdown()
    fun viewPaused()
    fun viewResumed()
}