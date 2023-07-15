//
//  HomeItemContentConfiguration.swift
//  debug
//
//  Created by Mitchell Drew on 27/4/21.
//

import Foundation
import UIKit

struct HomeItemGridContentConfiguration: UIContentConfiguration, Hashable {
    var name:String?
    var image:UIImage?
    
    func makeContentView() -> UIView & UIContentView {
        return HomeItemGridContentView(configuration: self)
    }
    
    func updated(for state: UIConfigurationState) -> HomeItemGridContentConfiguration {
        guard state is UICellConfigurationState else {
            return self
        }
        
        let updatedConfiguration = self
        return updatedConfiguration
    }
}
