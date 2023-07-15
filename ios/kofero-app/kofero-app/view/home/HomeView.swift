//
//  HomeView.swift
//  debug
//
//  Created by Mitchell Drew on 10/3/21.
//

import Foundation
import presenter
import UIKit
import GoogleMobileAds


class HomeView: AdViewController, IHomeView, UICollectionViewDelegate {
    private let interactor:IHomeInteractor
    
    private var collectionView:UICollectionView!
    private var dataSource: UICollectionViewDiffableDataSource<Section, Item<ModelObj>>!
    private var snapshot: NSDiffableDataSourceSnapshot<Section, Item<ModelObj>>!
    private var games = [ModelGame]()
    private var displayedItems = [Item]()
    private var cachedMapUrlsToImages = [String:String]()
    
    enum Section{
        case main
    }
    
    init(interactor:IHomeInteractor, adUnitId:String) {
        self.interactor = interactor
        super.init(adUnitId: adUnitId)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .white
        interactor.setView(view: self)
        addBannerView()
        addHeader("Home")
        buildGameCollectionView()
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        interactor.viewResumed()
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(animated)
        interactor.viewPaused()
    }
    
    private func addBannerView(){
        setupBannerView()
        view.addSubview(bannerView)
        NSLayoutConstraint.activate([
            bannerView.bottomAnchor.constraint(equalTo: view.bottomAnchor),
            bannerView.centerXAnchor.constraint(equalTo: view.centerXAnchor)
        ])
    }
    
    func buildGameCollectionView(){
        let gridLayout = GridCollectionViewLayout(numberOfColumns: 2)
        collectionView = UICollectionView(frame: view.frame, collectionViewLayout: gridLayout)
        view.addSubview(collectionView)
        collectionView.translatesAutoresizingMaskIntoConstraints = false
        collectionView.delegate = self
        collectionView.backgroundColor = .white
        NSLayoutConstraint.activate([
            collectionView.topAnchor.constraint(equalTo: header.bottomAnchor),
            collectionView.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            collectionView.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            collectionView.bottomAnchor.constraint(equalTo: bannerView.topAnchor)
        ])
        let cellRegistration = UICollectionView.CellRegistration<HomeViewItemGridCell, Item<ModelObj>> { (cell, indexPath, item) in
            cell.item = item
        }
        dataSource = UICollectionViewDiffableDataSource<Section, Item<ModelObj>>(collectionView: collectionView) {
            (collectionView: UICollectionView, indexPath: IndexPath, identifier: Item<ModelObj>) -> UICollectionViewCell? in
            let cell = collectionView.dequeueConfiguredReusableCell(using: cellRegistration, for: indexPath, item: identifier)
            return cell
        }
    }
    
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath){
        interactor.gamePressed(game: games[indexPath.item])
    }
    
    private func displayGame(_ game: ModelGame, _ imgBase64: String) {
        let item = Item(item: game as ModelObj, image: UIImage(data: Data(base64Encoded: imgBase64)!)!)
        snapshot.deleteItems(snapshot.itemIdentifiers.filter{snapGame in return snapGame.item.uid == game.uid})
        snapshot.appendItems([Item<ModelObj>](arrayLiteral: item), toSection: .main)
        displayedItems.append(item)
    }
    
    private func displayGameNoImage(_ game: ModelGame){
        let item = Item(item: game as ModelObj, image: nil)
        snapshot.appendItems([Item<ModelObj>](arrayLiteral: item), toSection: .main)
        displayedItems.append(item)
    }
    
    func display(url: String, imgBase64: String) {
        if(games.count == 0){
            cachedMapUrlsToImages[url] = imgBase64
            return
        }
        for game in games{
            if game.iconUrl == url {
                if(imgBase64 == NULL_STRING){
                    displayGameNoImage(game)
                } else {
                    displayGame(game, imgBase64)
                }
            }
        }
        guard let dSource = dataSource else { return }
        dSource.apply(snapshot, animatingDifferences: true)
    }
    
    func displayGames(games: [ModelGame]) {
        self.games = games
        displayedItems.removeAll()
        snapshot = NSDiffableDataSourceSnapshot<Section, Item<ModelObj>>()
        snapshot.appendSections([.main])
        for url in cachedMapUrlsToImages.keys {
            display(url: url, imgBase64: cachedMapUrlsToImages[url]!)
        }
        cachedMapUrlsToImages = [String:String]()
    }
    
    func displayNotOnDisk(url: String) {
        print("*******************")
        display(url: url, imgBase64: NULL_STRING)
    }
    
    
    func displayFavs(favorites: [ModelObj]) {
        print("%%%")
    }
    
    func error(e error: KotlinException) {
        print(error)
    }
    
    
    private let NULL_STRING = "nullstring"
}
