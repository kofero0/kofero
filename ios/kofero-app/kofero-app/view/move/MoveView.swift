//
//  MoveView.swift
//  debug
//
//  Created by Mitchell Drew on 12/3/21.
//

import Foundation
import presenter
import provider
import UIKit

class MoveView: UIViewController, IMoveView {
    
    private let presenter:IMovePresenter
    private let charViewBuilder:CharacterViewBuilder
    private let moveViewBuilder:MoveViewBuilder
    private let gameViewBuilder:GameViewBuilder
    private let homeViewBuilder:HomeViewBuilder
    private let moveId:Int32
    
    init(presenter:IMovePresenter, moveId:Int32, moveViewBuilder: MoveViewBuilder, gameViewBuilder: GameViewBuilder, charViewBuilder: CharacterViewBuilder, homeViewBuilder: HomeViewBuilder) {
        self.presenter = presenter
        self.charViewBuilder = charViewBuilder
        self.moveViewBuilder = moveViewBuilder
        self.gameViewBuilder = gameViewBuilder
        self.homeViewBuilder = homeViewBuilder
        self.moveId = moveId
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    func error(e: KotlinException) {
        
    }
}
