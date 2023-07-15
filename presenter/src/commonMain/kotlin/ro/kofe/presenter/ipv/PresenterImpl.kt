package ro.kofe.presenter.ipv

import ro.kofe.model.logging.Level.DEBUG
import ro.kofe.presenter.provider.LoggingProvider

abstract class PresenterImpl<V : View>(
    internal var view: V?,
    loggingProvider: LoggingProvider?,
    logTag: String
) : KoferoObj(loggingProvider, logTag), Presenter<V> {

    override fun shutdown() {
        super.shutdown()
        view = null
    }

    override fun setView(view: V) {
        log(DEBUG, "setView")
        this.view = view
    }
}