package ro.kofe.presenter.state

import ro.kofe.model.Event
import ro.kofe.presenter.provider.ILoggingProvider

class StateLogger(
    private val stateRepository: IStateRepository,
    private val loggingProvider: ILoggingProvider
) : IStateLogger {

    override fun logState(unixTime: Long, event: Event): Boolean {
        TODO("Not yet implemented")
    }

    override fun getStateMap(): Map<Long, Event> {
        TODO("Not yet implemented")
    }
}