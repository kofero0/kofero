package ro.kofe.presenter.ipv

import ro.kofe.model.logging.Level
import ro.kofe.presenter.provider.ILoggingProvider

abstract class KoferoObj(
    private var loggingProvider: ILoggingProvider?,
    private val logTag: String
) {

    internal fun log(level: Level, message: String) {
        loggingProvider?.log(level, logTag, message)
    }

    open fun shutdown() {
        log(Level.DEBUG, "shutdown")
        loggingProvider = null
    }
}