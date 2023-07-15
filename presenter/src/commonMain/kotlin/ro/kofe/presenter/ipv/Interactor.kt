package ro.kofe.presenter.ipv

import ro.kofe.model.Event
import ro.kofe.model.logging.Level.DEBUG
import ro.kofe.presenter.IRouter
import ro.kofe.presenter.millisNow
import ro.kofe.presenter.provider.ILoggingProvider
import ro.kofe.presenter.state.IStateLogger
import ro.kofe.presenter.state.IStateReducer

abstract class Interactor<V : IView, P : IPresenter<V>>(
    internal var presenter: P?,
    internal var stateLogger: IStateLogger?,
    internal var stateReducer: IStateReducer?,
    open var router: IRouter?,
    loggingProvider: ILoggingProvider?,
    logTag: String
) : KoferoObj(loggingProvider, logTag), IInteractor<V> {

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