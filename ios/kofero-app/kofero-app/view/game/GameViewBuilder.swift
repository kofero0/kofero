//
//  GameViewBuilder.swift
//  debug
//
//  Created by Mitchell Drew on 24/3/22.
//

import Foundation
import UIKit

protocol GameViewBuilder{
    func gameView(id:Int32) -> UIViewController
}
