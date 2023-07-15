package ro.kofe.presenter.state

import ro.kofe.model.Event

interface StateReducer {
    fun reduce(stateMap: Map<Long, Event>)
    fun authorize(event: Event, stateMap: Map<Long, Event>)
    fun addListener(listener: Listener)
    fun removeListener(listener: Listener)

    interface Listener {
        fun onReduce(stateMap: Map<Long, Event>, result: Event)
        fun onAuthorize(event: Event, stateMap: Map<Long, Event>, result: Boolean)
    }
}