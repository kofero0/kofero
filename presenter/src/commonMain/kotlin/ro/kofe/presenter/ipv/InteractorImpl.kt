package ro.kofe.presenter.ipv

import ro.kofe.model.Event
import ro.kofe.model.logging.Level.DEBUG
import ro.kofe.presenter.Router
import ro.kofe.presenter.millisNow
import ro.kofe.presenter.provider.LoggingProvider
import ro.kofe.presenter.state.StateLogger
import ro.kofe.presenter.state.StateReducer

abstract class InteractorImpl<V : View, P : Presenter<V>>(
    internal var presenter: P?,
    internal var stateLogger: StateLogger?,
    internal var stateReducer: StateReducer?,
    open var router: Router?,
    loggingProvider: LoggingProvider?,
    logTag: String
) : KoferoObj(loggingProvider, logTag), Interactor<V> {

    override fun viewPaused() {
        log(DEBUG, "viewPaused")
    }

    override fun viewResumed() {
        log(DEBUG, "viewResumed")
    }

    override fun setView(view: V) {
        log(DEBUG, "setView: $view")
        presenter?.setView(view)
    }

    internal fun logState(event: Event) {
        val time = millisNow()
        stateLogger?.logState(time, event)
        log(DEBUG, "loggedState: $time, $event")
    }

    override fun shutdown() {
        super.shutdown()
        presenter = null
        stateLogger = null
        stateReducer = null
    }
}