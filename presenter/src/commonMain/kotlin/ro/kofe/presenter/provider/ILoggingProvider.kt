package ro.kofe.presenter.provider

import ro.kofe.model.logging.Level

interface ILoggingProvider {
    fun log(level: Level, logTag: String, message: String)
}