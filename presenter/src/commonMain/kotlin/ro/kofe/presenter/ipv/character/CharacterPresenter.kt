package ro.kofe.presenter.ipv.character

import ro.kofe.model.Character
import ro.kofe.model.Move
import ro.kofe.presenter.IFreezer
import ro.kofe.presenter.provider.IImageProvider
import ro.kofe.presenter.provider.IProvider
import ro.kofe.presenter.provider.IProviderListener

class CharacterPresenter(
    private val freezer: IFreezer?,
    private val charProvider: IProvider<Character>?,
    private val moveProvider: IProvider<Move>?,
    private val imageProvider: IImageProvider?
) : ICharacterPresenter {
    private var view: ICharacterView? = null
    private var moveListener: IProviderListener<Move>? = null
    private var imageListener: IImageProvider.Listener? = null
    private var charListener: IProviderListener<Character>? = null

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

    private fun getMoveListener(): IProviderListener<Move> {
        return object : IProviderListener<Move> {
            override fun onReceive(ids: List<Int>, elements: List<Move>) {
                freezer?.freeze(elements)
                view?.display(elements)
            }

            override fun onError(ids: List<Int>, error: Exception) {
                view?.error(error)
            }
        }
    }

    private fun getCharListener(): IProviderListener<Character> {
        return object : IProviderListener<Character> {
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

    override fun setView(view: ICharacterView) {
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