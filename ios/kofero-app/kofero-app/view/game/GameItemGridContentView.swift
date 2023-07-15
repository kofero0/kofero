//
//  ContentView.swift
//  debug
//
//  Created by Mitchell Drew on 27/4/21.
//

import Foundation
import UIKit

class GameItemGridContentView: UIView, UIContentView {
    let nameLabel = UILabel()
    let imageView = UIImageView()
    
    
    private var currentConfiguration: GameItemGridContentConfiguration!
    var configuration: UIContentConfiguration {
        get {
            currentConfiguration
        }
        set {
            // Make sure the given configuration is of type SFSymbolContentConfiguration
            guard let newConfiguration = newValue as? GameItemGridContentConfiguration else {
                return
            }
            // Apply the new configuration to SFSymbolVerticalContentView
            // also update currentConfiguration to newConfiguration
            apply(configuration: newConfiguration)
            }
        }
    // We will work on the implementation in a short while.
    
    init(configuration: GameItemGridContentConfiguration) {
        super.init(frame: .zero)
        setup()
        apply(configuration: configuration)
    }

    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setup(){
        let stackView = UIStackView()
                stackView.axis = .vertical
                stackView.alignment = .fill
                stackView.distribution = .fill
                addSubview(stackView)
                stackView.translatesAutoresizingMaskIntoConstraints = false
                NSLayoutConstraint.activate([
                    stackView.leadingAnchor.constraint(equalTo: layoutMarginsGuide.leadingAnchor),
                    stackView.trailingAnchor.constraint(equalTo: layoutMarginsGuide.trailingAnchor),
                    stackView.topAnchor.constraint(equalTo: layoutMarginsGuide.topAnchor),
                    stackView.bottomAnchor.constraint(equalTo: layoutMarginsGuide.bottomAnchor),
                ])
                
                // Add image view to stack view
                imageView.contentMode = .scaleAspectFit
                stackView.addArrangedSubview(imageView)
                
                // Add label to stack view
                nameLabel.textAlignment = .center
                stackView.addArrangedSubview(nameLabel)
    }
    
    private func apply(configuration: GameItemGridContentConfiguration) {
        guard currentConfiguration != configuration else {
            return
        }
            
        currentConfiguration = configuration
            
        nameLabel.text = configuration.name
        imageView.image = configuration.image
    }
}
