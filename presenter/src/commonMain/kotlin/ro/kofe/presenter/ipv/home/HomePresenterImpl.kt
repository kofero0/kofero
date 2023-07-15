package ro.kofe.presenter.ipv.home

import ro.kofe.model.Game
import ro.kofe.model.Obj
import ro.kofe.model.logging.LogTag.HOME_PRESENTER
import ro.kofe.presenter.Freezer
import ro.kofe.presenter.ipv.PresenterImpl
import ro.kofe.presenter.provider.*


class HomePresenterImpl(
    private val freezer: Freezer,
    private var gameProvider: Provider<Game>?,
    private var imageProvider: ImageProvider?,
    private var favoritesProvider: FavoritesProvider?,
    loggingProvider: LoggingProvider?
) : HomePresenter,
    PresenterImpl<HomeView>(
        null,
        loggingProvider,
        HOME_PRESENTER
    ) {
    private var gameListener: ProviderListener<Game>? = null
    private var imageListener: ImageProvider.Listener? = null
    private var favoritesListener: ProviderListener<Obj>? = null


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

    private fun getFavoritesListener(): ProviderListener<Obj> {
        return object : ProviderListener<Obj> {
            override fun onReceive(ids: List<Int>, elements: List<Obj>) {
                view?.displayFavs(favorites = elements)
            }

            override fun onError(ids: List<Int>, error: Exception) {
                view?.error(error)
            }
        }
    }

    private fun getImageListener(): ImageProvider.Listener {
        return object : ImageProvider.Listener {
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

    private fun getGameListener(): ProviderListener<Game> {
        return object : ProviderListener<Game> {
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

    override fun setView(view: HomeView) {
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