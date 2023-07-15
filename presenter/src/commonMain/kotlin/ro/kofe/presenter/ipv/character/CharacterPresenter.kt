package ro.kofe.presenter.ipv.character

import ro.kofe.presenter.ipv.Presenter

interface CharacterPresenter : Presenter<CharacterView> {
    fun get(id: Int)
}