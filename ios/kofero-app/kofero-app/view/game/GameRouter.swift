//
//  Router.swift
//  debug
//
//  Created by Mitchell Drew on 21/3/22.
//

import Foundation
import provider
import presenter
import UIKit

class GameRouter: IRouter {
    
    let viewBuilder: CharacterViewBuilder
    let application: UIApplication
    let gameProvider: Provider<ModelCharacter>
    
    public init(_ viewBuilder:CharacterViewBuilder, _ application:UIApplication, _ gameProvider: Provider<ModelCharacter>){
        self.application = application
        self.gameProvider = gameProvider
        self.viewBuilder = viewBuilder
    }
    
    func routeTo(view: ModelEvent.ViewTag, uid: Int32) -> Bool {
        if(view != .charView){ return false }
        guard let root = application.windows.first(where: \.isKeyWindow)?.rootViewController else { fatalError("how did this happen?") }
        root.show(viewBuilder.characterView(id: uid), sender: self)
        return view == .gameView
    }
}
