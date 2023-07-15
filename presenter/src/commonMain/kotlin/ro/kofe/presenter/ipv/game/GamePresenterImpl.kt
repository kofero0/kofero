package ro.kofe.presenter.ipv.game

import ro.kofe.model.Character
import ro.kofe.model.Game
import ro.kofe.presenter.Freezer
import ro.kofe.presenter.provider.ImageProvider
import ro.kofe.presenter.provider.Provider
import ro.kofe.presenter.provider.ProviderListener

class GamePresenterImpl(
    private var freezer: Freezer?,
    private var characterProvider: Provider<Character>?,
    private var gameProvider: Provider<Game>?,
    private var imageProvider: ImageProvider?
) : GamePresenter {
    private var view: GameView? = null
    private var gameListener: ProviderListener<Game>? = null
    private var characterListener: ProviderListener<Character>? = null
    private var imageListener: ImageProvider.Listener? = null


    private fun getGameListener(): ProviderListener<Game> {
        return object : ProviderListener<Game> {
            override fun onReceive(ids: List<Int>, elements: List<Game>) {
                freezer?.freeze(elements)
                view?.display(elements[0])
                characterProvider?.get(elements[0].charIds)
            }

            override fun onError(ids: List<Int>, error: Exception) {
                view?.error(error)
            }
        }
    }

    private fun getCharacterListener(): ProviderListener<Character> {
        return object : ProviderListener<Character> {
            override fun onReceive(ids: List<Int>, elements: List<Character>) {
                freezer?.freeze(elements)
                for (char in elements) {
                    freezer?.freeze(char)
                }
                view?.display(elements)
                for (char in elements) {
                    val url = char.copy().iconUrl
                    freezer?.freeze(url)
                    imageProvider?.get(char.copy().iconUrl)
                }
            }

            override fun onError(ids: List<Int>, error: Exception) {
                view?.error(error)
            }
        }
    }

    private fun getImageListener(): ImageProvider.Listener {
        return object : ImageProvider.Listener {
            override fun onReceive(url: String, imgBase64: String) {
                freezer?.freeze(url)
                freezer?.freeze(imgBase64)
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

    private fun attachListeners() {
        characterListener = getCharacterListener()
        imageListener = getImageListener()
        gameListener = getGameListener()
        freezer?.freeze(characterListener!!)
        freezer?.freeze(gameListener!!)
        freezer?.freeze(imageListener!!)
        gameProvider?.addListener(gameListener!!)
        characterProvider?.addListener(characterListener!!)
        imageProvider?.addListener(imageListener!!)
    }

    override fun setView(view: GameView) {
        this.view = view
        attachListeners()
    }

    override fun showGame(id: Int) {
        var list = ArrayList<Int>()
        list.add(id)
        gameProvider?.get(list)
    }

    override fun shutdown() {
        gameListener?.let { gameProvider?.removeListener(it) }
        imageListener?.let { imageProvider?.removeListener(it) }
        characterListener?.let { characterProvider?.removeListener(it) }
        view = null
        gameProvider = null
        imageProvider = null
        characterProvider = null
        freezer = null
    }
}