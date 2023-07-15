//
//  GameComponent.swift
//  debug
//
//  Created by Mitchell Drew on 10/3/21.
//

import Foundation
import NeedleFoundation
import presenter
import provider
import SwiftyJSON

protocol GameDependency: Dependency {
    var imageProvider:IImageProvider {get}
    var providerCore:ProviderCore {get}
    var characterProvider:Provider<ModelCharacter> {get}
    var jsonEncoder:IDataEncoder<[JSON]> {get}
    var charViewBuilder:CharacterViewBuilder {get}
    var freezer:IFreezer {get}
    var bannerAdUnitId:String {get}
    var stateLogger:IStateLogger {get}
    var stateReducer:IStateReducer {get}
    var loggingProvider:ILoggingProvider {get}
    var uiApplication:UIApplication {get}
}

class GameComponent: Component<GameDependency>, GameViewBuilder{
    var gameProvider: Provider<ModelGame> {
        return Provider<ModelGame>(core: dependency.providerCore, url: url, mapper: mapper, jsonFilename: jsonFilename, loggingProvider: dependency.loggingProvider)
    }
    
    var mapper: IDataMapper<[ModelGame]> {
        return GameMapper(encoder: dependency.jsonEncoder)
    }
    
    var jsonFilename:String {
        return "game"
    }
    
    var url:URL {
        return URL(string: "https://google.com")!
    }
    
    var presenter: IGamePresenter {
        return GamePresenter(freezer: dependency.freezer, characterProvider: dependency.characterProvider, gameProvider: gameProvider, imageProvider: dependency.imageProvider)
    }
    
    var interactor: IGameInteractor {
        return GameInteractor(presenter: presenter, stateLogger: dependency.stateLogger, stateReducer: dependency.stateReducer, loggingProvider: dependency.loggingProvider, router: router)
    }
    
    var router: IRouter {
        return GameRouter(dependency.charViewBuilder, dependency.uiApplication, dependency.characterProvider)
    }
    
    func gameView(id:Int32) -> UIViewController {
        return GameView(interactor: interactor, gameId: id, adUnitId: dependency.bannerAdUnitId)
    }
    
}
