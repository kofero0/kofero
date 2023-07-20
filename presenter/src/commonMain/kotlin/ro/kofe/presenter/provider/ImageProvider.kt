package ro.kofe.presenter.provider

import ro.kofe.model.error.ProviderError

interface ImageProvider {
    fun get(url: String) : Either<ProviderError,>
    fun addListener(imgListener: Listener)
    fun removeListener(imgListener: Listener)

    interface Listener {
        fun onReceive(url: String, imgBase64: String)
        fun onError(url: String, error: Exception)
        fun onNotFound(url: String)
    }
}