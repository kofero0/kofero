package ro.kofe.presenter.ipv.home

import ro.kofe.presenter.ipv.Presenter

interface HomePresenter : Presenter<HomeView> {
    fun showGames()
}