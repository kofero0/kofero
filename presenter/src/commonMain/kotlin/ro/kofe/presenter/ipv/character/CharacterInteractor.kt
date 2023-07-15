package ro.kofe.presenter.ipv.character

import ro.kofe.model.logging.LogTag.CHARACTER_INTERACTOR
import ro.kofe.presenter.IRouter
import ro.kofe.presenter.ipv.Interactor
import ro.kofe.presenter.provider.ILoggingProvider
import ro.kofe.presenter.state.IStateLogger
import ro.kofe.presenter.state.IStateReducer

class CharacterInteractor(
    presenter: ICharacterPresenter,
    stateLogger: IStateLogger,
    stateReducer: IStateReducer,
    loggingProvider: ILoggingProvider,
    router: IRouter
) : Interactor<ICharacterView, ICharacterPresenter>(
    presenter,
    stateLogger,
    stateReducer,
    router,
    loggingProvider,
    CHARACTER_INTERACTOR
), ICharacterInteractor {
    override fun setCharUid(uid: Int) {
        TODO("Not yet implemented")
    }

    override fun setView(view: ICharacterView) {
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