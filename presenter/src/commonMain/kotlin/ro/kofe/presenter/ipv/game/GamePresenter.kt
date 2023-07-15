package ro.kofe.presenter.ipv.game

import ro.kofe.presenter.ipv.Presenter

interface GamePresenter : Presenter<GameView> {
    fun showGame(id: Int)
}