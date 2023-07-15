package ro.kofe.presenter.provider

import ro.kofe.model.Obj

interface Provider<T : Obj> {
    fun get(ids: List<Int>)
    fun addListener(listener: ProviderListener<T>)
    fun removeListener(listener: ProviderListener<T>)
}