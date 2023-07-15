package ro.kofe.presenter.ipv.home

import ro.kofe.model.Event
import ro.kofe.model.Event.Value.BUTTON_PRESSED
import ro.kofe.model.Event.ViewTag.GAME_VIEW
import ro.kofe.model.Event.ViewTag.HOME_VIEW
import ro.kofe.model.Game
import ro.kofe.model.Obj
import ro.kofe.model.logging.LogTag.HOME_INTERACTOR
import ro.kofe.presenter.IRouter
import ro.kofe.presenter.ipv.InteractorImpl
import ro.kofe.presenter.millisNow
import ro.kofe.presenter.provider.LoggingProvider
import ro.kofe.presenter.state.StateLogger
import ro.kofe.presenter.state.StateReducer

class HomeInteractorImpl(
    presenter: HomePresenter,
    stateLogger: StateLogger,
    stateReducer: StateReducer,
    loggingProvider: LoggingProvider,
    router: IRouter
) : HomeInteractor, InteractorImpl<HomeView, HomePresenter>(
    presenter,
    stateLogger,
    stateReducer,
    router,
    loggingProvider,
    HOME_INTERACTOR
) {

    override fun favPressed(obj: Obj) {
        TODO("Not yet implemented")
    }

    override fun gamePressed(game: Game) {
        stateLogger?.logState(
            millisNow(),
            Event(HOME_VIEW, BUTTON_PRESSED, HashMap<String, Any>().apply { this[BUTTON_PRESSED.name] = game.uid })
        )
        router?.routeTo(GAME_VIEW, game.uid)
    }

    override fun viewResumed() {
        super.viewResumed()
        presenter?.showGames()
    }
}