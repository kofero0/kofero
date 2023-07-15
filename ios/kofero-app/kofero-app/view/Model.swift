//
//  Item.swift
//  debug
//
//  Created by Mitchell Drew on 19/4/21.
//

import Foundation
import presenter
import UIKit

struct Item<O:ModelObj> : Hashable {
    let image:UIImage?
    let item:O
    
    init(item:O, image:UIImage?){
        self.item = item
        self.image = image
    }
}
