package ro.kofe.presenter.ipv.game

import ro.kofe.model.Character
import ro.kofe.model.Event
import ro.kofe.model.Event.Value.BUTTON_PRESSED
import ro.kofe.model.Event.ViewTag.CHAR_VIEW
import ro.kofe.model.Event.ViewTag.GAME_VIEW
import ro.kofe.model.logging.LogTag.GAME_INTERACTOR
import ro.kofe.presenter.IRouter
import ro.kofe.presenter.ipv.Interactor
import ro.kofe.presenter.millisNow
import ro.kofe.presenter.provider.ILoggingProvider
import ro.kofe.presenter.state.IStateLogger
import ro.kofe.presenter.state.IStateReducer

class GameInteractor(
    presenter: IGamePresenter,
    stateLogger: IStateLogger,
    stateReducer: IStateReducer,
    loggingProvider: ILoggingProvider,
    router: IRouter
) : IGameInteractor,
    Interactor<IGameView, IGamePresenter>(
        presenter,
        stateLogger,
        stateReducer,
        router,
        loggingProvider,
        GAME_INTERACTOR
    ) {
    private var gameUid: Int? = null

    override fun viewResumed() {
        super.viewResumed()
        gameUid?.let { presenter?.showGame(it) }
        if (gameUid == null) {
            throw IllegalArgumentException("null gameUid. how did we get here?")
        }
    }

    override fun charPressed(char: Character) {
        val map = HashMap<String, Any>()
        map[BUTTON_PRESSED.name] = char.uid
        stateLogger?.logState(millisNow(), Event(GAME_VIEW, BUTTON_PRESSED, map))
        router?.routeTo(CHAR_VIEW, char.uid)
    }

    override fun setGameUid(uid: Int) {
        this.gameUid = uid
    }
}