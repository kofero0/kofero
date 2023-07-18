package ro.kofe.presenter.ipv.move

import ro.kofe.model.Character
import ro.kofe.model.Game
import ro.kofe.model.Move
import ro.kofe.presenter.provider.ImageProvider
import ro.kofe.presenter.provider.Provider

class MovePresenterImpl(
    private val moveProvider: Provider<Move>,
    private val charProvider: Provider<Character>,
    private val gameProvider: Provider<Game>,
    private val imageProvider: ImageProvider
) : MovePresenter {

    override fun setView(view: MoveView) {
        TODO("Not yet implemented")
    }

    override fun shutdown() {
        TODO("Not yet implemented")
    }

}