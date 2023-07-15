//
//  AdView.swift
//  debug
//
//  Created by Mitchell Drew on 16/5/21.
//

import Foundation
import UIKit
import GoogleMobileAds

class AdViewController: UIViewController {
    internal let adUnitId:String
    internal let bannerView: GADBannerView
    var header: UIView!
    var headerLabel: UILabel!
    
    
    init(adUnitId:String){
        self.adUnitId = adUnitId
        bannerView = GADBannerView(adSize: kGADAdSizeBanner)
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    internal func setupBannerView() {
        bannerView.translatesAutoresizingMaskIntoConstraints = false
        bannerView.adUnitID = adUnitId
        bannerView.rootViewController = self
        bannerView.load(GADRequest())
    }
    
    func addHeader(_ headerText:String){
        header = UIView()
        headerLabel = UILabel()
        headerLabel.textColor = .black
        headerLabel.text = headerText
        headerLabel.font = UIFont.systemFont(ofSize: 25, weight: .bold)
        headerLabel.translatesAutoresizingMaskIntoConstraints = false
        header.translatesAutoresizingMaskIntoConstraints = false
        header.addSubview(headerLabel)
        view.addSubview(header)
        NSLayoutConstraint.activate([
            headerLabel.centerXAnchor.constraint(equalTo: header.centerXAnchor),
            headerLabel.centerYAnchor.constraint(equalTo: header.centerYAnchor),
            headerLabel.topAnchor.constraint(equalTo: header.topAnchor),
            header.topAnchor.constraint(equalTo: view.topAnchor, constant: 30),
            header.centerXAnchor.constraint(equalTo: view.centerXAnchor),
        ])
    }
}
