package ro.kofe.presenter.provider

import ro.kofe.model.Obj

interface FavoritesProvider : Provider<Obj> {
    fun save(item: Obj)
    fun delete(item: Obj)
}