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

class HomeRouter: IRouter {
    let gameViewBuilder: GameViewBuilder
    let uiApplication: UIApplication
    
    public init(_ gameViewBuilder:GameViewBuilder, _ uiApplication:UIApplication){
        self.uiApplication = uiApplication
        self.gameViewBuilder = gameViewBuilder
    }
    
    func routeTo(view: ModelEvent.ViewTag, uid: Int32) -> Bool {
        if(view != .gameView){ return false }
        guard let root = uiApplication.windows.first(where: \.isKeyWindow)?.rootViewController else { fatalError("how did this happen?") }
        root.show(gameViewBuilder.gameView(id: uid), sender: self)
        return view == .gameView
    }
}
