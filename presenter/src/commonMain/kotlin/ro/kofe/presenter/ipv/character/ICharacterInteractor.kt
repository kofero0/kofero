package ro.kofe.presenter.ipv.character

import ro.kofe.presenter.ipv.IInteractor

interface ICharacterInteractor : IInteractor<ICharacterView> {
    fun setCharUid(uid: Int)
}