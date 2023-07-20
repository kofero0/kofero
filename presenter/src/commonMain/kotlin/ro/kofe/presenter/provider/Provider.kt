package ro.kofe.presenter.provider

import arrow.core.Either
import ro.kofe.model.Obj
import ro.kofe.model.error.ProviderError

interface Provider<T : Obj> {
    fun get(ids: List<Int>): Either<ProviderError, List<T>>
}