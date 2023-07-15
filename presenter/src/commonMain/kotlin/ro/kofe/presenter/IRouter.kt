package ro.kofe.presenter

import ro.kofe.model.Event

interface IRouter {
    fun routeTo(view: Event.ViewTag, uid: Int): Boolean
}