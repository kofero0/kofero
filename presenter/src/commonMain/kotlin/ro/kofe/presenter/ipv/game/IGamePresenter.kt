package ro.kofe.presenter.ipv.game

import ro.kofe.presenter.ipv.IPresenter

interface IGamePresenter : IPresenter<IGameView> {
    fun showGame(id: Int)
}