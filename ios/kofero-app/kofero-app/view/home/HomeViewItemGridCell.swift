//
//  HomeItemGridCell.swift
//  debug
//
//  Created by Mitchell Drew on 27/4/21.
//

import Foundation
import UIKit
import presenter

class HomeViewItemGridCell: UICollectionViewCell {
    var item: Item<ModelObj>?
    
    override func updateConfiguration(using state: UICellConfigurationState) {
        var newConfiguration = HomeItemGridContentConfiguration().updated(for: state)
        newConfiguration.image = item?.image
        if let game = item?.item {
            if let uGame = game as? ModelGame {
                newConfiguration.name = uGame.name
            }
        }
        contentConfiguration = newConfiguration
    }
}
