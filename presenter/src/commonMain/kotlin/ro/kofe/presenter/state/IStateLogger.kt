package ro.kofe.presenter.state

import ro.kofe.model.Event

interface IStateLogger {
    fun logState(unixTime: Long, event: Event): Boolean
    fun getStateMap(): Map<Long, Event>
}