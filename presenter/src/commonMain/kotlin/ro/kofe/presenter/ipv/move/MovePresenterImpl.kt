package ro.kofe.presenter.ipv.move

import ro.kofe.model.Character
import ro.kofe.model.Game
import ro.kofe.model.Move
import ro.kofe.presenter.provider.ImageProvider
import ro.kofe.presenter.provider.IProvider

class MovePresenterImpl(
    private val moveProvider: IProvider<Move>,
    private val charProvider: IProvider<Character>,
    private val gameProvider: IProvider<Game>,
    private val imageProvider: ImageProvider
) : MovePresenter {

    override fun setView(view: MoveView) {
        TODO("Not yet implemented")
    }

    override fun shutdown() {
        TODO("Not yet implemented")
    }

}