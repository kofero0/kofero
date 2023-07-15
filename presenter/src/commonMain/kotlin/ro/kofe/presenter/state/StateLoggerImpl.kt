package ro.kofe.presenter.state

import ro.kofe.model.Event
import ro.kofe.presenter.provider.LoggingProvider

class StateLoggerImpl(
    private val stateRepository: StateRepository,
    private val loggingProvider: LoggingProvider
) : StateLogger {

    override fun logState(unixTime: Long, event: Event): Boolean {
        TODO("Not yet implemented")
    }

    override fun getStateMap(): Map<Long, Event> {
        TODO("Not yet implemented")
    }
}