package ro.kofe.presenter.ipv.character

import ro.kofe.model.logging.LogTag.CHARACTER_INTERACTOR
import ro.kofe.presenter.Router
import ro.kofe.presenter.ipv.InteractorImpl
import ro.kofe.presenter.provider.LoggingProvider
import ro.kofe.presenter.state.StateLogger
import ro.kofe.presenter.state.StateReducer

class CharacterInteractorImpl(
    presenter: CharacterPresenter,
    stateLogger: StateLogger,
    stateReducer: StateReducer,
    loggingProvider: LoggingProvider,
    router: Router
) : InteractorImpl<CharacterView, CharacterPresenter>(
    presenter,
    stateLogger,
    stateReducer,
    router,
    loggingProvider,
    CHARACTER_INTERACTOR
), CharacterInteractor {
    override fun setCharUid(uid: Int) {
        TODO("Not yet implemented")
    }

    override fun setView(view: CharacterView) {
        TODO("Not yet implemented")
    }

    override fun shutdown() {
        TODO("Not yet implemented")
    }

    override fun viewPaused() {
        TODO("Not yet implemented")
    }

    override fun viewResumed() {
        TODO("Not yet implemented")
    }
}