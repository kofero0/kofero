package ro.kofe.presenter.ipv.game

import ro.kofe.model.Character
import ro.kofe.presenter.ipv.IInteractor

interface IGameInteractor : IInteractor<IGameView> {
    fun charPressed(char: Character)
    fun setGameUid(uid: Int)
}