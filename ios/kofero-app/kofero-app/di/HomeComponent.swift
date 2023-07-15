//
//  HomeComponent.swift
//  debug
//
//  Created by Mitchell Drew on 10/3/21.
//

import Foundation
import NeedleFoundation
import presenter
import provider

protocol HomeDependency: Dependency {
    var bannerAdUnitId:String {get}
    var gameProvider:Provider<ModelGame> {get}
    var gameViewBuilder:GameViewBuilder {get}
    var imageProvider:IImageProvider {get}
    var freezer:IFreezer {get}
    var favoritesProvider:IFavoritesProvider {get}
    var stateLogger:IStateLogger {get}
    var stateReducer:IStateReducer {get}
    var loggingProvider:ILoggingProvider {get}
    var uiApplication:UIApplication {get}
}

class HomeComponent: Component<HomeDependency>, HomeViewBuilder {
    var presenter: IHomePresenter {
        return HomePresenter(freezer: dependency.freezer, gameProvider: dependency.gameProvider, imageProvider: dependency.imageProvider, favoritesProvider: dependency.favoritesProvider, loggingProvider: dependency.loggingProvider)
    }
    
    var interactor: IHomeInteractor {
        return HomeInteractor(presenter: presenter, stateLogger: dependency.stateLogger, stateReducer: dependency.stateReducer, loggingProvider: dependency.loggingProvider, router: router)
    }
    
    var router: IRouter {
        return HomeRouter(dependency.gameViewBuilder, dependency.uiApplication)
    }
    
    func homeView() -> UIViewController {
        return HomeView(interactor: interactor, adUnitId: dependency.bannerAdUnitId)
    }
}
