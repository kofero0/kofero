#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class PresenterModelEventViewTag, PresenterModelEvent, PresenterModelObj, PresenterKotlinException, PresenterModelLevel, PresenterKoferoObj, PresenterInteractor<V, P>, PresenterModelMove, PresenterModelCharacter, PresenterModelGame, PresenterPresenter<V>, PresenterKotlinEnumCompanion, PresenterKotlinEnum<E>, PresenterKotlinArray<T>, PresenterModelEventValue, PresenterKotlinThrowable;

@protocol PresenterIFreezer, PresenterIStateReducerListener, PresenterIStateRepositoryListener, PresenterIStateLogger, PresenterIStateRepository, PresenterILoggingProvider, PresenterIProviderListener, PresenterIProvider, PresenterIImageProviderListener, PresenterIView, PresenterIInteractor, PresenterIStateReducer, PresenterIRouter, PresenterIPresenter, PresenterICharacterInteractor, PresenterICharacterPresenter, PresenterICharacterView, PresenterIImageProvider, PresenterIGameInteractor, PresenterIGamePresenter, PresenterIGameView, PresenterIHomeInteractor, PresenterIHomePresenter, PresenterIHomeView, PresenterIFavoritesProvider, PresenterIMovePresenter, PresenterIMoveView, PresenterIRootPresenter, PresenterIRootView, PresenterKotlinComparable, PresenterKotlinIterator;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface PresenterBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end;

@interface PresenterBase (PresenterBaseCopying) <NSCopying>
@end;

__attribute__((swift_name("KotlinMutableSet")))
@interface PresenterMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end;

__attribute__((swift_name("KotlinMutableDictionary")))
@interface PresenterMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end;

@interface NSError (NSErrorPresenterKotlinException)
@property (readonly) id _Nullable kotlinException;
@end;

__attribute__((swift_name("KotlinNumber")))
@interface PresenterNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end;

__attribute__((swift_name("KotlinByte")))
@interface PresenterByte : PresenterNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end;

__attribute__((swift_name("KotlinUByte")))
@interface PresenterUByte : PresenterNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end;

__attribute__((swift_name("KotlinShort")))
@interface PresenterShort : PresenterNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end;

__attribute__((swift_name("KotlinUShort")))
@interface PresenterUShort : PresenterNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end;

__attribute__((swift_name("KotlinInt")))
@interface PresenterInt : PresenterNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end;

__attribute__((swift_name("KotlinUInt")))
@interface PresenterUInt : PresenterNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end;

__attribute__((swift_name("KotlinLong")))
@interface PresenterLong : PresenterNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end;

__attribute__((swift_name("KotlinULong")))
@interface PresenterULong : PresenterNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end;

__attribute__((swift_name("KotlinFloat")))
@interface PresenterFloat : PresenterNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end;

__attribute__((swift_name("KotlinDouble")))
@interface PresenterDouble : PresenterNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end;

__attribute__((swift_name("KotlinBoolean")))
@interface PresenterBoolean : PresenterNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end;

__attribute__((swift_name("IFreezer")))
@protocol PresenterIFreezer
@required
- (id)freezeObj:(id)obj __attribute__((swift_name("freeze(obj:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Freezer")))
@interface PresenterFreezer : PresenterBase <PresenterIFreezer>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (id)freezeObj:(id)obj __attribute__((swift_name("freeze(obj:)")));
@end;

__attribute__((swift_name("IRouter")))
@protocol PresenterIRouter
@required
- (BOOL)routeToView:(PresenterModelEventViewTag *)view uid:(int32_t)uid __attribute__((swift_name("routeTo(view:uid:)")));
@end;

__attribute__((swift_name("IStateLogger")))
@protocol PresenterIStateLogger
@required
- (NSDictionary<PresenterLong *, PresenterModelEvent *> *)getStateMap __attribute__((swift_name("getStateMap()")));
- (BOOL)logStateUnixTime:(int64_t)unixTime event:(PresenterModelEvent *)event __attribute__((swift_name("logState(unixTime:event:)")));
@end;

__attribute__((swift_name("IStateReducer")))
@protocol PresenterIStateReducer
@required
- (void)addListenerListener:(id<PresenterIStateReducerListener>)listener __attribute__((swift_name("addListener(listener:)")));
- (void)authorizeEvent:(PresenterModelEvent *)event stateMap:(NSDictionary<PresenterLong *, PresenterModelEvent *> *)stateMap __attribute__((swift_name("authorize(event:stateMap:)")));
- (void)reduceStateMap:(NSDictionary<PresenterLong *, PresenterModelEvent *> *)stateMap __attribute__((swift_name("reduce(stateMap:)")));
- (void)removeListenerListener:(id<PresenterIStateReducerListener>)listener __attribute__((swift_name("removeListener(listener:)")));
@end;

__attribute__((swift_name("IStateReducerListener")))
@protocol PresenterIStateReducerListener
@required
- (void)onAuthorizeEvent:(PresenterModelEvent *)event stateMap:(NSDictionary<PresenterLong *, PresenterModelEvent *> *)stateMap result:(BOOL)result __attribute__((swift_name("onAuthorize(event:stateMap:result:)")));
- (void)onReduceStateMap:(NSDictionary<PresenterLong *, PresenterModelEvent *> *)stateMap result:(PresenterModelEvent *)result __attribute__((swift_name("onReduce(stateMap:result:)")));
@end;

__attribute__((swift_name("IStateRepository")))
@protocol PresenterIStateRepository
@required
- (BOOL)addListenerListener_:(id<PresenterIStateRepositoryListener>)listener __attribute__((swift_name("addListener(listener_:)")));
- (void)get __attribute__((swift_name("get()")));
- (BOOL)removeListenerListener_:(id<PresenterIStateRepositoryListener>)listener __attribute__((swift_name("removeListener(listener_:)")));
- (void)saveMap:(NSDictionary<PresenterLong *, PresenterModelEvent *> *)map __attribute__((swift_name("save(map:)")));
@end;

__attribute__((swift_name("IStateRepositoryListener")))
@protocol PresenterIStateRepositoryListener
@required
- (void)onReceiveStateMap:(NSDictionary<PresenterLong *, PresenterModelEvent *> *)stateMap __attribute__((swift_name("onReceive(stateMap:)")));
- (void)onSavedMap:(NSDictionary<PresenterLong *, PresenterModelEvent *> *)map result:(BOOL)result __attribute__((swift_name("onSaved(map:result:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("StateLogger")))
@interface PresenterStateLogger : PresenterBase <PresenterIStateLogger>
- (instancetype)initWithStateRepository:(id<PresenterIStateRepository>)stateRepository loggingProvider:(id<PresenterILoggingProvider>)loggingProvider __attribute__((swift_name("init(stateRepository:loggingProvider:)"))) __attribute__((objc_designated_initializer));
- (NSDictionary<PresenterLong *, PresenterModelEvent *> *)getStateMap __attribute__((swift_name("getStateMap()")));
- (BOOL)logStateUnixTime:(int64_t)unixTime event:(PresenterModelEvent *)event __attribute__((swift_name("logState(unixTime:event:)")));
@end;

__attribute__((swift_name("IProvider")))
@protocol PresenterIProvider
@required
- (void)addListenerListener__:(id<PresenterIProviderListener>)listener __attribute__((swift_name("addListener(listener__:)")));
- (void)getIds:(NSArray<PresenterInt *> *)ids __attribute__((swift_name("get(ids:)")));
- (void)removeListenerListener__:(id<PresenterIProviderListener>)listener __attribute__((swift_name("removeListener(listener__:)")));
@end;

__attribute__((swift_name("IFavoritesProvider")))
@protocol PresenterIFavoritesProvider <PresenterIProvider>
@required
- (void)deleteItem:(PresenterModelObj *)item __attribute__((swift_name("delete(item:)")));
- (void)saveItem:(PresenterModelObj *)item __attribute__((swift_name("save(item:)")));
@end;

__attribute__((swift_name("IImageProvider")))
@protocol PresenterIImageProvider
@required
- (void)addListenerImgListener:(id<PresenterIImageProviderListener>)imgListener __attribute__((swift_name("addListener(imgListener:)")));
- (void)getUrl:(NSString *)url __attribute__((swift_name("get(url:)")));
- (void)removeListenerImgListener:(id<PresenterIImageProviderListener>)imgListener __attribute__((swift_name("removeListener(imgListener:)")));
@end;

__attribute__((swift_name("IImageProviderListener")))
@protocol PresenterIImageProviderListener
@required
- (void)onErrorUrl:(NSString *)url error:(PresenterKotlinException *)error __attribute__((swift_name("onError(url:error:)")));
- (void)onNotFoundUrl:(NSString *)url __attribute__((swift_name("onNotFound(url:)")));
- (void)onReceiveUrl:(NSString *)url imgBase64:(NSString *)imgBase64 __attribute__((swift_name("onReceive(url:imgBase64:)")));
@end;

__attribute__((swift_name("ILoggingProvider")))
@protocol PresenterILoggingProvider
@required
- (void)logLevel:(PresenterModelLevel *)level logTag:(NSString *)logTag message:(NSString *)message __attribute__((swift_name("log(level:logTag:message:)")));
@end;

__attribute__((swift_name("IProviderListener")))
@protocol PresenterIProviderListener
@required
- (void)onErrorIds:(NSArray<PresenterInt *> *)ids error:(PresenterKotlinException *)error __attribute__((swift_name("onError(ids:error:)")));
- (void)onReceiveIds:(NSArray<PresenterInt *> *)ids elements:(NSArray<PresenterModelObj *> *)elements __attribute__((swift_name("onReceive(ids:elements:)")));
@end;

__attribute__((swift_name("IInteractor")))
@protocol PresenterIInteractor
@required
- (void)setViewView:(id<PresenterIView>)view __attribute__((swift_name("setView(view:)")));
- (void)shutdown __attribute__((swift_name("shutdown()")));
- (void)viewPaused __attribute__((swift_name("viewPaused()")));
- (void)viewResumed __attribute__((swift_name("viewResumed()")));
@end;

__attribute__((swift_name("IPresenter")))
@protocol PresenterIPresenter
@required
- (void)setViewView_:(id<PresenterIView>)view __attribute__((swift_name("setView(view_:)")));
- (void)shutdown __attribute__((swift_name("shutdown()")));
@end;

__attribute__((swift_name("IView")))
@protocol PresenterIView
@required
- (void)errorE:(PresenterKotlinException *)e __attribute__((swift_name("error(e:)")));
@end;

__attribute__((swift_name("KoferoObj")))
@interface PresenterKoferoObj : PresenterBase
- (instancetype)initWithLoggingProvider:(id<PresenterILoggingProvider> _Nullable)loggingProvider logTag:(NSString *)logTag __attribute__((swift_name("init(loggingProvider:logTag:)"))) __attribute__((objc_designated_initializer));
- (void)shutdown __attribute__((swift_name("shutdown()")));
@end;

__attribute__((swift_name("Interactor")))
@interface PresenterInteractor<V, P> : PresenterKoferoObj <PresenterIInteractor>
- (instancetype)initWithPresenter:(P _Nullable)presenter stateLogger:(id<PresenterIStateLogger> _Nullable)stateLogger stateReducer:(id<PresenterIStateReducer> _Nullable)stateReducer router:(id<PresenterIRouter> _Nullable)router loggingProvider:(id<PresenterILoggingProvider> _Nullable)loggingProvider logTag:(NSString *)logTag __attribute__((swift_name("init(presenter:stateLogger:stateReducer:router:loggingProvider:logTag:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithLoggingProvider:(id<PresenterILoggingProvider> _Nullable)loggingProvider logTag:(NSString *)logTag __attribute__((swift_name("init(loggingProvider:logTag:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)setViewView:(V)view __attribute__((swift_name("setView(view:)")));
- (void)shutdown __attribute__((swift_name("shutdown()")));
- (void)viewPaused __attribute__((swift_name("viewPaused()")));
- (void)viewResumed __attribute__((swift_name("viewResumed()")));
@property id<PresenterIRouter> _Nullable router __attribute__((swift_name("router")));
@end;

__attribute__((swift_name("Presenter")))
@interface PresenterPresenter<V> : PresenterKoferoObj <PresenterIPresenter>
- (instancetype)initWithView:(V _Nullable)view loggingProvider:(id<PresenterILoggingProvider> _Nullable)loggingProvider logTag:(NSString *)logTag __attribute__((swift_name("init(view:loggingProvider:logTag:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithLoggingProvider:(id<PresenterILoggingProvider> _Nullable)loggingProvider logTag:(NSString *)logTag __attribute__((swift_name("init(loggingProvider:logTag:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)setViewView_:(V)view __attribute__((swift_name("setView(view_:)")));
- (void)shutdown __attribute__((swift_name("shutdown()")));
@end;

__attribute__((swift_name("ICharacterInteractor")))
@protocol PresenterICharacterInteractor <PresenterIInteractor>
@required
- (void)setCharUidUid:(int32_t)uid __attribute__((swift_name("setCharUid(uid:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CharacterInteractor")))
@interface PresenterCharacterInteractor : PresenterInteractor<id<PresenterICharacterView>, id<PresenterICharacterPresenter>> <PresenterICharacterInteractor>
- (instancetype)initWithPresenter:(id<PresenterICharacterPresenter>)presenter stateLogger:(id<PresenterIStateLogger>)stateLogger stateReducer:(id<PresenterIStateReducer>)stateReducer loggingProvider:(id<PresenterILoggingProvider>)loggingProvider router:(id<PresenterIRouter>)router __attribute__((swift_name("init(presenter:stateLogger:stateReducer:loggingProvider:router:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPresenter:(id<PresenterIPresenter> _Nullable)presenter stateLogger:(id<PresenterIStateLogger> _Nullable)stateLogger stateReducer:(id<PresenterIStateReducer> _Nullable)stateReducer router:(id<PresenterIRouter> _Nullable)router loggingProvider:(id<PresenterILoggingProvider> _Nullable)loggingProvider logTag:(NSString *)logTag __attribute__((swift_name("init(presenter:stateLogger:stateReducer:router:loggingProvider:logTag:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)setCharUidUid:(int32_t)uid __attribute__((swift_name("setCharUid(uid:)")));
- (void)setViewView:(id<PresenterICharacterView>)view __attribute__((swift_name("setView(view:)")));
- (void)shutdown __attribute__((swift_name("shutdown()")));
- (void)viewPaused __attribute__((swift_name("viewPaused()")));
- (void)viewResumed __attribute__((swift_name("viewResumed()")));
@end;

__attribute__((swift_name("ICharacterPresenter")))
@protocol PresenterICharacterPresenter <PresenterIPresenter>
@required
- (void)getId:(int32_t)id __attribute__((swift_name("get(id:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CharacterPresenter")))
@interface PresenterCharacterPresenter : PresenterBase <PresenterICharacterPresenter>
- (instancetype)initWithFreezer:(id<PresenterIFreezer> _Nullable)freezer charProvider:(id<PresenterIProvider> _Nullable)charProvider moveProvider:(id<PresenterIProvider> _Nullable)moveProvider imageProvider:(id<PresenterIImageProvider> _Nullable)imageProvider __attribute__((swift_name("init(freezer:charProvider:moveProvider:imageProvider:)"))) __attribute__((objc_designated_initializer));
- (void)getId:(int32_t)id __attribute__((swift_name("get(id:)")));
- (void)setViewView_:(id<PresenterICharacterView>)view __attribute__((swift_name("setView(view_:)")));
- (void)shutdown __attribute__((swift_name("shutdown()")));
@end;

__attribute__((swift_name("ICharacterView")))
@protocol PresenterICharacterView <PresenterIView>
@required
- (void)displayUrl:(NSString *)url imgBase64:(NSString *)imgBase64 __attribute__((swift_name("display(url:imgBase64:)")));
- (void)displayMoves:(NSArray<PresenterModelMove *> *)moves __attribute__((swift_name("display(moves:)")));
- (void)displayCharacter:(PresenterModelCharacter *)character __attribute__((swift_name("display(character:)")));
- (void)displayNotOnDiskUrl:(NSString *)url __attribute__((swift_name("displayNotOnDisk(url:)")));
@end;

__attribute__((swift_name("IGameInteractor")))
@protocol PresenterIGameInteractor <PresenterIInteractor>
@required
- (void)charPressedChar:(PresenterModelCharacter *)char_ __attribute__((swift_name("charPressed(char:)")));
- (void)setGameUidUid:(int32_t)uid __attribute__((swift_name("setGameUid(uid:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GameInteractor")))
@interface PresenterGameInteractor : PresenterInteractor<id<PresenterIGameView>, id<PresenterIGamePresenter>> <PresenterIGameInteractor>
- (instancetype)initWithPresenter:(id<PresenterIGamePresenter>)presenter stateLogger:(id<PresenterIStateLogger>)stateLogger stateReducer:(id<PresenterIStateReducer>)stateReducer loggingProvider:(id<PresenterILoggingProvider>)loggingProvider router:(id<PresenterIRouter>)router __attribute__((swift_name("init(presenter:stateLogger:stateReducer:loggingProvider:router:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPresenter:(id<PresenterIPresenter> _Nullable)presenter stateLogger:(id<PresenterIStateLogger> _Nullable)stateLogger stateReducer:(id<PresenterIStateReducer> _Nullable)stateReducer router:(id<PresenterIRouter> _Nullable)router loggingProvider:(id<PresenterILoggingProvider> _Nullable)loggingProvider logTag:(NSString *)logTag __attribute__((swift_name("init(presenter:stateLogger:stateReducer:router:loggingProvider:logTag:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)charPressedChar:(PresenterModelCharacter *)char_ __attribute__((swift_name("charPressed(char:)")));
- (void)setGameUidUid:(int32_t)uid __attribute__((swift_name("setGameUid(uid:)")));
- (void)viewResumed __attribute__((swift_name("viewResumed()")));
@end;

__attribute__((swift_name("IGamePresenter")))
@protocol PresenterIGamePresenter <PresenterIPresenter>
@required
- (void)showGameId:(int32_t)id __attribute__((swift_name("showGame(id:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GamePresenter")))
@interface PresenterGamePresenter : PresenterBase <PresenterIGamePresenter>
- (instancetype)initWithFreezer:(id<PresenterIFreezer> _Nullable)freezer characterProvider:(id<PresenterIProvider> _Nullable)characterProvider gameProvider:(id<PresenterIProvider> _Nullable)gameProvider imageProvider:(id<PresenterIImageProvider> _Nullable)imageProvider __attribute__((swift_name("init(freezer:characterProvider:gameProvider:imageProvider:)"))) __attribute__((objc_designated_initializer));
- (void)setViewView_:(id<PresenterIGameView>)view __attribute__((swift_name("setView(view_:)")));
- (void)showGameId:(int32_t)id __attribute__((swift_name("showGame(id:)")));
- (void)shutdown __attribute__((swift_name("shutdown()")));
@end;

__attribute__((swift_name("IGameView")))
@protocol PresenterIGameView <PresenterIView>
@required
- (void)displayUrl:(NSString *)url imgBase64:(NSString *)imgBase64 __attribute__((swift_name("display(url:imgBase64:)")));
- (void)displayCharacters:(NSArray<PresenterModelCharacter *> *)characters __attribute__((swift_name("display(characters:)")));
- (void)displayGame:(PresenterModelGame *)game __attribute__((swift_name("display(game:)")));
- (void)displayNotOnDiskUrl:(NSString *)url __attribute__((swift_name("displayNotOnDisk(url:)")));
@end;

__attribute__((swift_name("IHomeInteractor")))
@protocol PresenterIHomeInteractor <PresenterIInteractor>
@required
- (void)favPressedObj:(PresenterModelObj *)obj __attribute__((swift_name("favPressed(obj:)")));
- (void)gamePressedGame:(PresenterModelGame *)game __attribute__((swift_name("gamePressed(game:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HomeInteractor")))
@interface PresenterHomeInteractor : PresenterInteractor<id<PresenterIHomeView>, id<PresenterIHomePresenter>> <PresenterIHomeInteractor>
- (instancetype)initWithPresenter:(id<PresenterIHomePresenter>)presenter stateLogger:(id<PresenterIStateLogger>)stateLogger stateReducer:(id<PresenterIStateReducer>)stateReducer loggingProvider:(id<PresenterILoggingProvider>)loggingProvider router:(id<PresenterIRouter>)router __attribute__((swift_name("init(presenter:stateLogger:stateReducer:loggingProvider:router:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPresenter:(id<PresenterIPresenter> _Nullable)presenter stateLogger:(id<PresenterIStateLogger> _Nullable)stateLogger stateReducer:(id<PresenterIStateReducer> _Nullable)stateReducer router:(id<PresenterIRouter> _Nullable)router loggingProvider:(id<PresenterILoggingProvider> _Nullable)loggingProvider logTag:(NSString *)logTag __attribute__((swift_name("init(presenter:stateLogger:stateReducer:router:loggingProvider:logTag:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)favPressedObj:(PresenterModelObj *)obj __attribute__((swift_name("favPressed(obj:)")));
- (void)gamePressedGame:(PresenterModelGame *)game __attribute__((swift_name("gamePressed(game:)")));
- (void)viewResumed __attribute__((swift_name("viewResumed()")));
@end;

__attribute__((swift_name("IHomePresenter")))
@protocol PresenterIHomePresenter <PresenterIPresenter>
@required
- (void)showGames __attribute__((swift_name("showGames()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HomePresenter")))
@interface PresenterHomePresenter : PresenterPresenter<id<PresenterIHomeView>> <PresenterIHomePresenter>
- (instancetype)initWithFreezer:(id<PresenterIFreezer>)freezer gameProvider:(id<PresenterIProvider> _Nullable)gameProvider imageProvider:(id<PresenterIImageProvider> _Nullable)imageProvider favoritesProvider:(id<PresenterIFavoritesProvider> _Nullable)favoritesProvider loggingProvider:(id<PresenterILoggingProvider> _Nullable)loggingProvider __attribute__((swift_name("init(freezer:gameProvider:imageProvider:favoritesProvider:loggingProvider:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithView:(id<PresenterIView> _Nullable)view loggingProvider:(id<PresenterILoggingProvider> _Nullable)loggingProvider logTag:(NSString *)logTag __attribute__((swift_name("init(view:loggingProvider:logTag:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)setViewView_:(id<PresenterIHomeView>)view __attribute__((swift_name("setView(view_:)")));
- (void)showGames __attribute__((swift_name("showGames()")));
- (void)shutdown __attribute__((swift_name("shutdown()")));
@end;

__attribute__((swift_name("IHomeView")))
@protocol PresenterIHomeView <PresenterIView>
@required
- (void)displayUrl:(NSString *)url imgBase64:(NSString *)imgBase64 __attribute__((swift_name("display(url:imgBase64:)")));
- (void)displayFavsFavorites:(NSArray<PresenterModelObj *> *)favorites __attribute__((swift_name("displayFavs(favorites:)")));
- (void)displayGamesGames:(NSArray<PresenterModelGame *> *)games __attribute__((swift_name("displayGames(games:)")));
- (void)displayNotOnDiskUrl:(NSString *)url __attribute__((swift_name("displayNotOnDisk(url:)")));
@end;

__attribute__((swift_name("IMovePresenter")))
@protocol PresenterIMovePresenter <PresenterIPresenter>
@required
@end;

__attribute__((swift_name("IMoveView")))
@protocol PresenterIMoveView <PresenterIView>
@required
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MovePresenter")))
@interface PresenterMovePresenter : PresenterBase <PresenterIMovePresenter>
- (instancetype)initWithMoveProvider:(id<PresenterIProvider>)moveProvider charProvider:(id<PresenterIProvider>)charProvider gameProvider:(id<PresenterIProvider>)gameProvider imageProvider:(id<PresenterIImageProvider>)imageProvider __attribute__((swift_name("init(moveProvider:charProvider:gameProvider:imageProvider:)"))) __attribute__((objc_designated_initializer));
- (void)setViewView_:(id<PresenterIMoveView>)view __attribute__((swift_name("setView(view_:)")));
- (void)shutdown __attribute__((swift_name("shutdown()")));
@end;

__attribute__((swift_name("IRootPresenter")))
@protocol PresenterIRootPresenter <PresenterIPresenter>
@required
@end;

__attribute__((swift_name("IRootView")))
@protocol PresenterIRootView <PresenterIView>
@required
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RootPresenter")))
@interface PresenterRootPresenter : PresenterBase <PresenterIRootPresenter>
- (instancetype)initWithFreezer:(id<PresenterIFreezer>)freezer gameProvider:(id<PresenterIProvider>)gameProvider __attribute__((swift_name("init(freezer:gameProvider:)"))) __attribute__((objc_designated_initializer));
- (void)setViewView_:(id<PresenterIRootView>)rootView __attribute__((swift_name("setView(view_:)")));
- (void)shutdown __attribute__((swift_name("shutdown()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UtilsKt")))
@interface PresenterUtilsKt : PresenterBase
+ (int64_t)millisNow __attribute__((swift_name("millisNow()")));
@end;

__attribute__((swift_name("KotlinComparable")))
@protocol PresenterKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end;

__attribute__((swift_name("KotlinEnum")))
@interface PresenterKotlinEnum<E> : PresenterBase <PresenterKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) PresenterKotlinEnumCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ModelEvent.ViewTag")))
@interface PresenterModelEventViewTag : PresenterKotlinEnum<PresenterModelEventViewTag *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) PresenterModelEventViewTag *homeView __attribute__((swift_name("homeView")));
@property (class, readonly) PresenterModelEventViewTag *gameView __attribute__((swift_name("gameView")));
@property (class, readonly) PresenterModelEventViewTag *charView __attribute__((swift_name("charView")));
+ (PresenterKotlinArray<PresenterModelEventViewTag *> *)values __attribute__((swift_name("values()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ModelEvent")))
@interface PresenterModelEvent : PresenterBase
- (instancetype)initWithView:(PresenterModelEventViewTag *)view value:(PresenterModelEventValue *)value extras:(NSDictionary<NSString *, id> *)extras __attribute__((swift_name("init(view:value:extras:)"))) __attribute__((objc_designated_initializer));
- (PresenterModelEventViewTag *)component1 __attribute__((swift_name("component1()")));
- (PresenterModelEventValue *)component2 __attribute__((swift_name("component2()")));
- (NSDictionary<NSString *, id> *)component3 __attribute__((swift_name("component3()")));
- (PresenterModelEvent *)doCopyView:(PresenterModelEventViewTag *)view value:(PresenterModelEventValue *)value extras:(NSDictionary<NSString *, id> *)extras __attribute__((swift_name("doCopy(view:value:extras:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSDictionary<NSString *, id> *extras __attribute__((swift_name("extras")));
@property (readonly) PresenterModelEventValue *value __attribute__((swift_name("value")));
@property (readonly) PresenterModelEventViewTag *view __attribute__((swift_name("view")));
@end;

__attribute__((swift_name("ModelObj")))
@interface PresenterModelObj : PresenterBase
- (instancetype)initWithUid:(int32_t)uid __attribute__((swift_name("init(uid:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t uid __attribute__((swift_name("uid")));
@end;

__attribute__((swift_name("KotlinThrowable")))
@interface PresenterKotlinThrowable : PresenterBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(PresenterKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(PresenterKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (PresenterKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) PresenterKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end;

__attribute__((swift_name("KotlinException")))
@interface PresenterKotlinException : PresenterKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(PresenterKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(PresenterKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ModelLevel")))
@interface PresenterModelLevel : PresenterKotlinEnum<PresenterModelLevel *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) PresenterModelLevel *debug __attribute__((swift_name("debug")));
@property (class, readonly) PresenterModelLevel *alert __attribute__((swift_name("alert")));
+ (PresenterKotlinArray<PresenterModelLevel *> *)values __attribute__((swift_name("values()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ModelMove")))
@interface PresenterModelMove : PresenterModelObj
- (instancetype)initWithUid:(int32_t)uid name:(NSString *)name attributes:(NSDictionary<NSString *, NSString *> *)attributes __attribute__((swift_name("init(uid:name:attributes:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithUid:(int32_t)uid __attribute__((swift_name("init(uid:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSDictionary<NSString *, NSString *> *)component3 __attribute__((swift_name("component3()")));
- (PresenterModelMove *)doCopyUid:(int32_t)uid name:(NSString *)name attributes:(NSDictionary<NSString *, NSString *> *)attributes __attribute__((swift_name("doCopy(uid:name:attributes:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSDictionary<NSString *, NSString *> *attributes __attribute__((swift_name("attributes")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t uid __attribute__((swift_name("uid")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ModelCharacter")))
@interface PresenterModelCharacter : PresenterModelObj
- (instancetype)initWithUid:(int32_t)uid name:(NSString *)name attributes:(NSDictionary<NSString *, NSString *> *)attributes moveIds:(NSArray<PresenterInt *> *)moveIds iconUrl:(NSString *)iconUrl __attribute__((swift_name("init(uid:name:attributes:moveIds:iconUrl:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithUid:(int32_t)uid __attribute__((swift_name("init(uid:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSDictionary<NSString *, NSString *> *)component3 __attribute__((swift_name("component3()")));
- (NSArray<PresenterInt *> *)component4 __attribute__((swift_name("component4()")));
- (NSString *)component5 __attribute__((swift_name("component5()")));
- (PresenterModelCharacter *)doCopyUid:(int32_t)uid name:(NSString *)name attributes:(NSDictionary<NSString *, NSString *> *)attributes moveIds:(NSArray<PresenterInt *> *)moveIds iconUrl:(NSString *)iconUrl __attribute__((swift_name("doCopy(uid:name:attributes:moveIds:iconUrl:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSDictionary<NSString *, NSString *> *attributes __attribute__((swift_name("attributes")));
@property (readonly) NSString *iconUrl __attribute__((swift_name("iconUrl")));
@property (readonly) NSArray<PresenterInt *> *moveIds __attribute__((swift_name("moveIds")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t uid __attribute__((swift_name("uid")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ModelGame")))
@interface PresenterModelGame : PresenterModelObj
- (instancetype)initWithUid:(int32_t)uid name:(NSString *)name charIds:(NSArray<PresenterInt *> *)charIds iconUrl:(NSString *)iconUrl __attribute__((swift_name("init(uid:name:charIds:iconUrl:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithUid:(int32_t)uid __attribute__((swift_name("init(uid:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSArray<PresenterInt *> *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (PresenterModelGame *)doCopyUid:(int32_t)uid name:(NSString *)name charIds:(NSArray<PresenterInt *> *)charIds iconUrl:(NSString *)iconUrl __attribute__((swift_name("doCopy(uid:name:charIds:iconUrl:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<PresenterInt *> *charIds __attribute__((swift_name("charIds")));
@property (readonly) NSString *iconUrl __attribute__((swift_name("iconUrl")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t uid __attribute__((swift_name("uid")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinEnumCompanion")))
@interface PresenterKotlinEnumCompanion : PresenterBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) PresenterKotlinEnumCompanion *shared __attribute__((swift_name("shared")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface PresenterKotlinArray<T> : PresenterBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(PresenterInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<PresenterKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ModelEvent.Value")))
@interface PresenterModelEventValue : PresenterKotlinEnum<PresenterModelEventValue *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) PresenterModelEventValue *viewEntered __attribute__((swift_name("viewEntered")));
@property (class, readonly) PresenterModelEventValue *viewExited __attribute__((swift_name("viewExited")));
@property (class, readonly) PresenterModelEventValue *buttonPressed __attribute__((swift_name("buttonPressed")));
@property (class, readonly) PresenterModelEventValue *routingRequest __attribute__((swift_name("routingRequest")));
@property (class, readonly) PresenterModelEventValue *routingDenied __attribute__((swift_name("routingDenied")));
+ (PresenterKotlinArray<PresenterModelEventValue *> *)values __attribute__((swift_name("values()")));
@end;

__attribute__((swift_name("KotlinIterator")))
@protocol PresenterKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end;

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
