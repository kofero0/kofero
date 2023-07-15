package ro.kofe.presenter.ipv.game

import ro.kofe.model.Character
import ro.kofe.model.Event
import ro.kofe.model.Event.Value.BUTTON_PRESSED
import ro.kofe.model.Event.ViewTag.CHAR_VIEW
import ro.kofe.model.Event.ViewTag.GAME_VIEW
import ro.kofe.model.logging.LogTag.GAME_INTERACTOR
import ro.kofe.presenter.Router
import ro.kofe.presenter.ipv.InteractorImpl
import ro.kofe.presenter.millisNow
import ro.kofe.presenter.provider.LoggingProvider
import ro.kofe.presenter.state.StateLogger
import ro.kofe.presenter.state.StateReducer

class GameInteractorImpl(
    presenter: GamePresenterImpl,
    stateLogger: StateLogger,
    stateReducer: StateReducer,
    loggingProvider: LoggingProvider,
    router: Router
) : GameInteractor,
    InteractorImpl<GameView, GamePresenter>(
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