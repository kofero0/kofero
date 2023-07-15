package ro.kofe.presenter.ipv.character

import ro.kofe.presenter.ipv.Interactor

interface CharacterInteractor : Interactor<CharacterView> {
    fun setCharUid(uid: Int)
}