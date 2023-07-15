package ro.kofe.presenter.ipv.home

import ro.kofe.presenter.ipv.IPresenter

interface IHomePresenter : IPresenter<IHomeView> {
    fun showGames()
}