package ro.kofe.presenter.provider

import ro.kofe.model.logging.Level

interface LoggingProvider {
    fun log(level: Level, logTag: String, message: String)
}