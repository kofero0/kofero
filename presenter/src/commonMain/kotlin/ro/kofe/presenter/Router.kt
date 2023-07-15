package ro.kofe.presenter

import ro.kofe.model.Event

interface Router {
    fun routeTo(view: Event.ViewTag, uid: Int): Boolean
}