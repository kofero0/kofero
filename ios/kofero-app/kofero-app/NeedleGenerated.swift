

import Foundation
import NeedleFoundation
import SwiftyJSON
import presenter
import provider

// swiftlint:disable unused_declaration
private let needleDependenciesHash : String? = nil

// MARK: - Registration

public func registerProviderFactories() {
    __DependencyProviderRegistry.instance.registerDependencyProviderFactory(for: "^->RootComponent->GameComponent") { component in
        return GameDependency6174651c56123eef7457Provider(component: component)
    }
    __DependencyProviderRegistry.instance.registerDependencyProviderFactory(for: "^->RootComponent") { component in
        return EmptyDependencyProvider(component: component)
    }
    __DependencyProviderRegistry.instance.registerDependencyProviderFactory(for: "^->RootComponent->MoveComponent") { component in
        return MoveDependency60ec017cefc7ff9083ceProvider(component: component)
    }
    __DependencyProviderRegistry.instance.registerDependencyProviderFactory(for: "^->RootComponent->CharacterComponent") { component in
        return CharacterDependency42b99561bd73739b9ec3Provider(component: component)
    }
    __DependencyProviderRegistry.instance.registerDependencyProviderFactory(for: "^->RootComponent->HomeComponent") { component in
        return HomeDependencycad225e9266b3c9a56ddProvider(component: component)
    }
    
}

// MARK: - Providers

private class GameDependency6174651c56123eef7457BaseProvider: GameDependency {
    var imageProvider: IImageProvider {
        return rootComponent.imageProvider
    }
    var providerCore: ProviderCore {
        return rootComponent.providerCore
    }
    var characterProvider: Provider<ModelCharacter> {
        return rootComponent.characterProvider
    }
    var jsonEncoder: IDataEncoder<[JSON]> {
        return rootComponent.jsonEncoder
    }
    var charViewBuilder: CharacterViewBuilder {
        return rootComponent.charViewBuilder
    }
    var freezer: IFreezer {
        return rootComponent.freezer
    }
    var bannerAdUnitId: String {
        return rootComponent.bannerAdUnitId
    }
    var stateLogger: IStateLogger {
        return rootComponent.stateLogger
    }
    var stateReducer: IStateReducer {
        return rootComponent.stateReducer
    }
    var loggingProvider: ILoggingProvider {
        return rootComponent.loggingProvider
    }
    var uiApplication: UIApplication {
        return rootComponent.uiApplication
    }
    private let rootComponent: RootComponent
    init(rootComponent: RootComponent) {
        self.rootComponent = rootComponent
    }
}
/// ^->RootComponent->GameComponent
private class GameDependency6174651c56123eef7457Provider: GameDependency6174651c56123eef7457BaseProvider {
    init(component: NeedleFoundation.Scope) {
        super.init(rootComponent: component.parent as! RootComponent)
    }
}
private class MoveDependency60ec017cefc7ff9083ceBaseProvider: MoveDependency {
    var providerCore: ProviderCore {
        return rootComponent.providerCore
    }
    var gameProvider: Provider<ModelGame> {
        return rootComponent.gameProvider
    }
    var characterProvider: Provider<ModelCharacter> {
        return rootComponent.characterProvider
    }
    var imageProvider: IImageProvider {
        return rootComponent.imageProvider
    }
    var jsonEncoder: IDataEncoder<[JSON]> {
        return rootComponent.jsonEncoder
    }
    var gameViewBuilder: GameViewBuilder {
        return rootComponent.gameViewBuilder
    }
    var charViewBuilder: CharacterViewBuilder {
        return rootComponent.charViewBuilder
    }
    var homeViewBuilder: HomeViewBuilder {
        return rootComponent.homeViewBuilder
    }
    var loggingProvider: ILoggingProvider {
        return rootComponent.loggingProvider
    }
    private let rootComponent: RootComponent
    init(rootComponent: RootComponent) {
        self.rootComponent = rootComponent
    }
}
/// ^->RootComponent->MoveComponent
private class MoveDependency60ec017cefc7ff9083ceProvider: MoveDependency60ec017cefc7ff9083ceBaseProvider {
    init(component: NeedleFoundation.Scope) {
        super.init(rootComponent: component.parent as! RootComponent)
    }
}
private class CharacterDependency42b99561bd73739b9ec3BaseProvider: CharacterDependency {
    var moveProvider: Provider<ModelMove> {
        return rootComponent.moveProvider
    }
    var imageProvider: IImageProvider {
        return rootComponent.imageProvider
    }
    var providerCore: ProviderCore {
        return rootComponent.providerCore
    }
    var jsonEncoder: IDataEncoder<[JSON]> {
        return rootComponent.jsonEncoder
    }
    var moveViewBuilder: MoveViewBuilder {
        return rootComponent.moveViewBuilder
    }
    var freezer: IFreezer {
        return rootComponent.freezer
    }
    var bannerAdUnitId: String {
        return rootComponent.bannerAdUnitId
    }
    var loggingProvider: ILoggingProvider {
        return rootComponent.loggingProvider
    }
    private let rootComponent: RootComponent
    init(rootComponent: RootComponent) {
        self.rootComponent = rootComponent
    }
}
/// ^->RootComponent->CharacterComponent
private class CharacterDependency42b99561bd73739b9ec3Provider: CharacterDependency42b99561bd73739b9ec3BaseProvider {
    init(component: NeedleFoundation.Scope) {
        super.init(rootComponent: component.parent as! RootComponent)
    }
}
private class HomeDependencycad225e9266b3c9a56ddBaseProvider: HomeDependency {
    var bannerAdUnitId: String {
        return rootComponent.bannerAdUnitId
    }
    var gameProvider: Provider<ModelGame> {
        return rootComponent.gameProvider
    }
    var gameViewBuilder: GameViewBuilder {
        return rootComponent.gameViewBuilder
    }
    var imageProvider: IImageProvider {
        return rootComponent.imageProvider
    }
    var freezer: IFreezer {
        return rootComponent.freezer
    }
    var favoritesProvider: IFavoritesProvider {
        return rootComponent.favoritesProvider
    }
    var stateLogger: IStateLogger {
        return rootComponent.stateLogger
    }
    var stateReducer: IStateReducer {
        return rootComponent.stateReducer
    }
    var loggingProvider: ILoggingProvider {
        return rootComponent.loggingProvider
    }
    var uiApplication: UIApplication {
        return rootComponent.uiApplication
    }
    private let rootComponent: RootComponent
    init(rootComponent: RootComponent) {
        self.rootComponent = rootComponent
    }
}
/// ^->RootComponent->HomeComponent
private class HomeDependencycad225e9266b3c9a56ddProvider: HomeDependencycad225e9266b3c9a56ddBaseProvider {
    init(component: NeedleFoundation.Scope) {
        super.init(rootComponent: component.parent as! RootComponent)
    }
}
