package ro.kofe.presenter.ipv.character

import ro.kofe.model.Character
import ro.kofe.model.Move
import ro.kofe.presenter.Freezer
import ro.kofe.presenter.provider.ImageProvider
import ro.kofe.presenter.provider.Provider
import ro.kofe.presenter.provider.ProviderListener

class CharacterPresenterImpl(
    private val freezer: Freezer?,
    private val charProvider: Provider<Character>?,
    private val moveProvider: Provider<Move>?,
    private val imageProvider: ImageProvider?
) : CharacterPresenter {
    private var view: CharacterView? = null
    private var moveListener: ProviderListener<Move>? = null
    private var imageListener: ImageProvider.Listener? = null
    private var charListener: ProviderListener<Character>? = null

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

    private fun getMoveListener(): ProviderListener<Move> {
        return object : ProviderListener<Move> {
            override fun onReceive(ids: List<Int>, elements: List<Move>) {
                freezer?.freeze(elements)
                view?.display(elements)
            }

            override fun onError(ids: List<Int>, error: Exception) {
                view?.error(error)
            }
        }
    }

    private fun getCharListener(): ProviderListener<Character> {
        return object : ProviderListener<Character> {
            override fun onReceive(ids: List<Int>, elements: List<Character>) {
                freezer?.freeze(elements)
                for (char in elements) {
                    freezer?.freeze(char)
                    imageProvider?.get(char.iconUrl)
                    moveProvider?.get(char.moveIds)
                    view?.display(char)
                }
            }

            override fun onError(ids: List<Int>, error: Exception) {
                view?.error(error)
            }
        }
    }

    private fun attachListeners() {
        imageListener = getImageListener()
        moveListener = getMoveListener()
        charListener = getCharListener()
        freezer?.freeze(imageListener!!)
        freezer?.freeze(moveListener!!)
        freezer?.freeze(charListener!!)
        imageProvider?.addListener(imageListener!!)
        moveProvider?.addListener(moveListener!!)
        charProvider?.addListener(charListener!!)
    }

    override fun setView(view: CharacterView) {
        this.view = view
        attachListeners()
    }

    override fun get(id: Int) {
        var list = ArrayList<Int>()
        list.add(id)
        charProvider?.get(list)
    }

    override fun shutdown() {

    }
}