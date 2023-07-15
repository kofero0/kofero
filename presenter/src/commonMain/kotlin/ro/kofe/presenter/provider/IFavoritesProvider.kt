package ro.kofe.presenter.provider

import ro.kofe.model.Obj

interface IFavoritesProvider : IProvider<Obj> {
    fun save(item: Obj)
    fun delete(item: Obj)
}