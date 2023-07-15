package ro.kofe.presenter.ipv.root

import ro.kofe.model.Game
import ro.kofe.presenter.Freezer
import ro.kofe.presenter.provider.Provider
import ro.kofe.presenter.provider.ProviderListener

class RootPresenterImpl(private val freezer: Freezer, private val gameProvider: Provider<Game>) :
    RootPresenter {
    private var view: RootView? = null
    private var listener: ProviderListener<Game>? = null

    private fun getGameListener(): ProviderListener<Game> {
        return object : ProviderListener<Game> {
            override fun onReceive(ids: List<Int>, elements: List<Game>) {
            }

            override fun onError(ids: List<Int>, error: Exception) {
            }

        }
    }

    override fun setView(rootView: RootView) {
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