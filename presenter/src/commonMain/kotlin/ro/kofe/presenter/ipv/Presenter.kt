package ro.kofe.presenter.ipv

import ro.kofe.model.logging.Level.DEBUG
import ro.kofe.presenter.provider.ILoggingProvider

abstract class Presenter<V : IView>(
    internal var view: V?,
    loggingProvider: ILoggingProvider?,
    logTag: String
) : KoferoObj(loggingProvider, logTag), IPresenter<V> {

    override fun shutdown() {
        super.shutdown()
        view = null
    }

    override fun setView(view: V) {
        log(DEBUG, "setView")
        this.view = view
    }
}