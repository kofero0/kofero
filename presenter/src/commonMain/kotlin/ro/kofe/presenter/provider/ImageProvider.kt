package ro.kofe.presenter.provider

interface ImageProvider {
    fun get(url: String)
    fun addListener(imgListener: Listener)
    fun removeListener(imgListener: Listener)

    interface Listener {
        fun onReceive(url: String, imgBase64: String)
        fun onError(url: String, error: Exception)
        fun onNotFound(url: String)
    }
}