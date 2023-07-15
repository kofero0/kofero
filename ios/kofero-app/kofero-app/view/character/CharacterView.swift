//
//  CharacterView.swift
//  debug
//
//  Created by Mitchell Drew on 11/3/21.
//

import GoogleMobileAds
import Foundation
import presenter
import UIKit




struct MoveItem: Hashable {
    let uuid = UUID()
    let title: String
    var children: [MoveString]
    
    
    static func ==(lhs: MoveItem, rhs: MoveItem) -> Bool {
        return lhs.uuid == rhs.uuid
    }

    func hash(into hasher: inout Hasher) {
        hasher.combine(uuid)
    }
}

struct MoveString: Hashable {
    let uuid = UUID()
    let string: String
    
    static func ==(lhs: MoveString, rhs: MoveString) -> Bool {
        return lhs.uuid == rhs.uuid
    }

    func hash(into hasher: inout Hasher) {
        hasher.combine(uuid)
    }
}

enum ListItem: Hashable {
    case header(MoveItem)
    case symbol(MoveString)
}

class CharacterView: AdViewController, ICharacterView, UICollectionViewDelegate {
    
    private let presenter:ICharacterPresenter
    private let moveViewBuilder:MoveViewBuilder
    private let charId:Int32
    
    private var icon:UIImageView?
    private var nameLabel:UILabel?
    
    private var displayedChar: ModelCharacter?
    
    private var collectionView:UICollectionView!
    var dataSource: UICollectionViewDiffableDataSource<Section, ListItem>!
    
    enum Section {
        case main
    }
    
    init(presenter:ICharacterPresenter, charId:Int32, moveViewBuilder:MoveViewBuilder, adUnitId:String){
        self.charId = charId
        self.presenter = presenter
        self.moveViewBuilder = moveViewBuilder
        super.init(adUnitId: adUnitId)
        view.backgroundColor = .white
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter.setView(view_: self)
        
        addHeader("Character")
        addCollectionView()
        addBannerViewToView()
        
        presenter.get(id: charId)
    }
    
    
    private func addBannerViewToView() {
        setupBannerView()
        view.addSubview(bannerView)
        NSLayoutConstraint.activate([
            bannerView.bottomAnchor.constraint(equalTo: view.bottomAnchor),
            bannerView.centerXAnchor.constraint(equalTo: view.centerXAnchor),
        ])
    }
    
    private func addCollectionView(){
        let layoutConfig = UICollectionLayoutListConfiguration(appearance: .insetGrouped)
        let listLayout = UICollectionViewCompositionalLayout.list(using: layoutConfig)
        collectionView = UICollectionView(frame: view.bounds, collectionViewLayout: listLayout)
        view.addSubview(collectionView)
        collectionView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            collectionView.topAnchor.constraint(equalTo: header!.bottomAnchor, constant: 0.0),
            collectionView.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 0.0),
            collectionView.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: 0.0),
            collectionView.bottomAnchor.constraint(equalTo: view!.bottomAnchor, constant: -50)
        ])
        let headerCellRegistration = UICollectionView.CellRegistration<UICollectionViewListCell, MoveItem> {
            (cell, indexPath, headerItem) in
            
            var content = cell.defaultContentConfiguration()
            content.text = headerItem.title
            cell.contentConfiguration = content
            
            let headerDisclosureOption = UICellAccessory.OutlineDisclosureOptions(style: .header)
            cell.accessories = [.outlineDisclosure(options:headerDisclosureOption)]
        }
        let symbolCellRegistration = UICollectionView.CellRegistration<UICollectionViewListCell, String> {
            (cell, indexPath, symbolItem) in
            
            var content = cell.defaultContentConfiguration()
            content.text = symbolItem
            cell.contentConfiguration = content
        }
        dataSource = UICollectionViewDiffableDataSource<Section, ListItem>(collectionView: collectionView) {
            (collectionView, indexPath, listItem) -> UICollectionViewCell? in
            
            switch listItem {
            case .header(let headerItem):
            
                let cell = collectionView.dequeueConfiguredReusableCell(using: headerCellRegistration,
                                                                        for: indexPath,
                                                                        item: headerItem)
                return cell
            
            case .symbol(let symbolItem):
                
                let cell = collectionView.dequeueConfiguredReusableCell(using: symbolCellRegistration,
                                                                        for: indexPath,
                                                                        item: symbolItem.string)
                return cell
            }
        }
        var dataSourceSnapshot = NSDiffableDataSourceSnapshot<Section, ListItem>()
        dataSourceSnapshot.appendSections([.main])
        dataSource.apply(dataSourceSnapshot)
    }
    
    internal override func addHeader(_ headerText:String){
        header = UIView()
        icon = UIImageView()
        icon!.backgroundColor = .systemTeal
        icon!.translatesAutoresizingMaskIntoConstraints = false
        header!.addSubview(icon!)
        NSLayoutConstraint.activate([
            icon!.heightAnchor.constraint(equalToConstant: 100),
            icon!.widthAnchor.constraint(equalToConstant: 100),
            icon!.leadingAnchor.constraint(equalTo: header!.leadingAnchor)
        ])
        
        nameLabel = UILabel()
        nameLabel!.textColor = .black
        nameLabel!.text = "Character Name"
        nameLabel!.translatesAutoresizingMaskIntoConstraints = false
        header!.addSubview(nameLabel!)
        
        NSLayoutConstraint.activate([
            nameLabel!.leadingAnchor.constraint(equalTo: icon!.trailingAnchor)
        ])
        
        view.addSubview(header!)
        header!.backgroundColor = .white
        header!.translatesAutoresizingMaskIntoConstraints = false
        
        NSLayoutConstraint.activate([
            header!.topAnchor.constraint(equalTo: view.layoutMarginsGuide.topAnchor, constant: 0.0),
            header!.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            header!.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            header!.heightAnchor.constraint(equalToConstant: 100.0)
        ])
    }
    
    func display(moves: [ModelMove]) {
        var sectionSnapshot = NSDiffableDataSourceSectionSnapshot<ListItem>()
        for move in moves {
            let HITTYPE = "Hit Type"
            let STARTUP = "Startup"
            let ACTIVE = "Active"
            let RECOVERY = "Recovery"
            let HITADV = "Hit Adv"
            let BLOCKADV = "Block Adv"
            let HITSTUN = "Hitstun"
            let BLOCKSTUN = "Blockstun"
            let NOTES = "Notes"
            var mAttr = move.attributes
            let moveItem = MoveItem(title: move.name, children: [])
            let headerListItem = ListItem.header(moveItem)
            sectionSnapshot.append([headerListItem])
            var symbolListItemArray = [ListItem]()
            var notes:String?
            notes = mAttr.removeValue(forKey: NOTES)
            if(mAttr.keys.contains(HITTYPE)){
                symbolListItemArray.append(ListItem.symbol(MoveString(string: "\(HITTYPE): \( mAttr.removeValue(forKey: HITTYPE)!)")))
            }
            if(mAttr.keys.contains(STARTUP)){
                symbolListItemArray.append(ListItem.symbol(MoveString(string: "\(STARTUP): \( mAttr.removeValue(forKey: STARTUP)!)")))
            }
            if(mAttr.keys.contains(ACTIVE)){
                symbolListItemArray.append(ListItem.symbol(MoveString(string: "\(ACTIVE): \( mAttr.removeValue(forKey: ACTIVE)!)")))
            }
            if(mAttr.keys.contains(RECOVERY)){
                symbolListItemArray.append(ListItem.symbol(MoveString(string: "\(RECOVERY): \( mAttr.removeValue(forKey: RECOVERY)!)")))
            }
            if(mAttr.keys.contains(HITSTUN) && mAttr.keys.contains(BLOCKSTUN)){
                symbolListItemArray.append(ListItem.symbol(MoveString(string: "\(HITSTUN): \( mAttr.removeValue(forKey: HITSTUN)!)")))
                symbolListItemArray.append(ListItem.symbol(MoveString(string: "\(BLOCKSTUN): \( mAttr.removeValue(forKey: BLOCKSTUN)!)")))
            }
            if(mAttr.keys.contains(HITADV) && mAttr.keys.contains(BLOCKADV)){
                    symbolListItemArray.append(ListItem.symbol(MoveString(string: "\(HITADV): \( mAttr.removeValue(forKey: HITADV)!)")))
                    symbolListItemArray.append(ListItem.symbol(MoveString(string: "\(BLOCKADV): \(mAttr.removeValue(forKey: BLOCKADV)!)")))
            }
            for attribute in mAttr {
                symbolListItemArray.append(ListItem.symbol(MoveString(string: "\(attribute.key): \(attribute.value)")))
            }
            if let uNotes = notes{
                symbolListItemArray.append(ListItem.symbol(MoveString(string: "\(NOTES): \(uNotes)")))
            }
            sectionSnapshot.append(symbolListItemArray, to: headerListItem)
        }
        dataSource?.apply(sectionSnapshot, to: .main, animatingDifferences: false)
    }
    
    func display(character: ModelCharacter) {
        displayedChar = character
        DispatchQueue.main.async {
            self.nameLabel?.text = character.name
        }
    }
    
    func error(e error: KotlinException) {
        
    }
    
    func display(url: String, imgBase64: String) {
        DispatchQueue.main.async {
            let image = UIImage(data: Data(base64Encoded: imgBase64)!)
            self.icon?.image = image
        }
    }
    
    func displayNotOnDisk(url: String) {
        //TODO: create a CGImage, look at GameView/HomeView
    }
}
