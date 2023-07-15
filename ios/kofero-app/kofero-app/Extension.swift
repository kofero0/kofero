//
//  Extension.swift
//  debug
//
//  Created by Mitchell Drew on 23/3/22.
//

import Foundation
import presenter

extension Int32 {
    func toKotlinInt() -> KotlinInt {
        return KotlinInt(int: self)
    }
}
