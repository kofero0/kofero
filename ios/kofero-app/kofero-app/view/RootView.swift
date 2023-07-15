//
//  ViewController.swift
//  kofero-app
//
//  Created by Mitchell Drew on 5/3/21.
//

import UIKit
import presenter
import provider
import SwiftyJSON

class RootView: UINavigationController, IRootView {
    private let presenter:IRootPresenter
    private let homeBuilder:HomeViewBuilder
    
    
    init(homeBuilder:HomeViewBuilder, presenter: IRootPresenter){
        self.homeBuilder = homeBuilder
        self.presenter = presenter
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .white
        presenter.setView(view_: self)
    }
    
    override func viewDidAppear(_ animated: Bool) {
        let home = homeBuilder.homeView()
        pushViewController(home, animated: true)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        presenter.shutdown()
    }
    
    func error(e error: KotlinException) {
        print("error: \(error)")
    }

}


