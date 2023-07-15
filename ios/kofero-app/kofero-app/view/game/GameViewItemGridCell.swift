//
//  HomeItemGridCell.swift
//  debug
//
//  Created by Mitchell Drew on 27/4/21.
//

import Foundation
import UIKit
import presenter

class GameViewItemGridCell: UICollectionViewCell {
    var item: Item<ModelCharacter>?

    override func updateConfiguration(using state: UICellConfigurationState) {
                
            // Create new configuration object and update it base on state
            var newConfiguration = GameItemGridContentConfiguration().updated(for: state)
            
            // Update any configuration parameters related to data item
        
        newConfiguration.image = item?.image
        newConfiguration.name = item?.item.name
        contentConfiguration = newConfiguration
    }
}
