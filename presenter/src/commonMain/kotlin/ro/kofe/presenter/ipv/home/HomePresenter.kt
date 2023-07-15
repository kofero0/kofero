package ro.kofe.presenter.ipv.home

import ro.kofe.model.Game
import ro.kofe.model.Obj
import ro.kofe.model.logging.LogTag.HOME_PRESENTER
import ro.kofe.presenter.IFreezer
import ro.kofe.presenter.ipv.Presenter
import ro.kofe.presenter.provider.*


class HomePresenter(
    private val freezer: IFreezer,
    private var gameProvider: IProvider<Game>?,
    private var imageProvider: IImageProvider?,
    private var favoritesProvider: IFavoritesProvider?,
    loggingProvider: ILoggingProvider?
) : IHomePresenter,
    Presenter<IHomeView>(
        null,
        loggingProvider,
        HOME_PRESENTER
    ) {
    private var gameListener: IProviderListener<Game>? = null
    private var imageListener: IImageProvider.Listener? = null
    private var favoritesListener: IProviderListener<Obj>? = null


    private fun attachListeners() {
        gameListener = getGameListener()
        imageListener = getImageListener()
        favoritesListener = getFavoritesListener()
        freezer.freeze(favoritesListener!!)
        freezer.freeze(gameListener!!)
        freezer.freeze(imageListener!!)
        gameProvider?.addListener(gameListener!!)
        imageProvider?.addListener(imageListener!!)
        favoritesProvider?.addListener(favoritesListener!!)
    }

    private fun getFavoritesListener(): IProviderListener<Obj> {
        return object : IProviderListener<Obj> {
            override fun onReceive(ids: List<Int>, elements: List<Obj>) {
                view?.displayFavs(favorites = elements)
            }

            override fun onError(ids: List<Int>, error: Exception) {
                view?.error(error)
            }
        }
    }

    private fun getImageListener(): IImageProvider.Listener {
        return object : IImageProvider.Listener {
            override fun onReceive(url: String, imgBase64: String) {
                view?.display(url, imgBase64)
            }

            override fun onError(url: String, error: Exception) {
                view?.error(error)
            }

            override fun onNotFound(url: String) {
                view?.displayNotOnDisk(url)
            }
        }
    }

    private fun getGameListener(): IProviderListener<Game> {
        return object : IProviderListener<Game> {
            override fun onReceive(ids: List<Int>, elements: List<Game>) {
                for (game in elements) {
                    freezer.freeze(game)
                    imageProvider?.get(game.iconUrl)
                }
                view?.displayGames(games = elements)
            }

            override fun onError(ids: List<Int>, error: Exception) {
                view?.error(error)
            }
        }
    }

    override fun setView(view: IHomeView) {
        this.view = view
        attachListeners()
    }

    override fun showGames() {
        gameProvider?.get(ArrayList())
    }

    override fun shutdown() {
        gameListener?.let { gameProvider?.removeListener(it) }
        imageListener?.let { imageProvider?.removeListener(it) }
        view = null
        gameProvider = null
        imageProvider = null
    }
}