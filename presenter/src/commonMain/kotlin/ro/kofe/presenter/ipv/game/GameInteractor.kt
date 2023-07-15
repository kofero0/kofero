package ro.kofe.presenter.ipv.game

import ro.kofe.model.Character
import ro.kofe.presenter.ipv.Interactor

interface GameInteractor : Interactor<GameView> {
    fun charPressed(char: Character)
    fun setGameUid(uid: Int)
}