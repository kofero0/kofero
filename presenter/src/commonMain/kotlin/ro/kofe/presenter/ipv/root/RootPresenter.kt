package ro.kofe.presenter.ipv.root

import ro.kofe.model.Game
import ro.kofe.presenter.IFreezer
import ro.kofe.presenter.provider.IProvider
import ro.kofe.presenter.provider.IProviderListener

class RootPresenter(private val freezer: IFreezer, private val gameProvider: IProvider<Game>) : IRootPresenter {
    private var view: IRootView? = null
    private var listener: IProviderListener<Game>? = null

    private fun getGameListener(): IProviderListener<Game> {
        return object : IProviderListener<Game> {
            override fun onReceive(ids: List<Int>, elements: List<Game>) {
            }

            override fun onError(ids: List<Int>, error: Exception) {
            }

        }
    }

    override fun setView(rootView: IRootView) {
        this.view = rootView
        listener = getGameListener()
        freezer.freeze(listener!!)
        gameProvider.addListener(listener!!)
    }

    override fun shutdown() {
        view = null
        gameProvider.removeListener(listener!!)
    }
}