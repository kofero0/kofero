package ro.kofe.presenter.ipv.home

import ro.kofe.model.Game
import ro.kofe.model.Obj
import ro.kofe.presenter.ipv.IView

interface IHomeView : IView {
    fun displayGames(games: List<Game>)
    fun displayFavs(favorites: List<Obj>)
    fun display(url: String, imgBase64: String)
    fun displayNotOnDisk(url: String)
}