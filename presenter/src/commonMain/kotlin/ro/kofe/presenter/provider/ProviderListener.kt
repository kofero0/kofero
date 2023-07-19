package ro.kofe.presenter.provider

import arrow.core.Either
import ro.kofe.model.Obj

interface ProviderListener<T : Obj> {
    fun onReturn(ids: List<Int>, elements: )
}