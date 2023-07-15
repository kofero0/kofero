package ro.kofe.presenter.ipv.character

import ro.kofe.presenter.ipv.IPresenter

interface ICharacterPresenter : IPresenter<ICharacterView> {
    fun get(id: Int)
}