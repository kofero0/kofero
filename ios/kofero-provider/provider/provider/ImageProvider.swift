//
//  ImageProvider.swift
//  provider
//
//  Created by Mitchell Drew on 26/2/21.
//

import Foundation
import presenter

open class ImageProvider: IImageProvider {
    private var listeners = [IImageProviderListener]()
    public let restManager:IRestManager
    public let fileManager:IFileManager
    private let loggingProvider:ILoggingProvider
    
    public init(core:ProviderCore, loggingProvider: ILoggingProvider){
        self.restManager = core.restManager
        self.fileManager = core.fileManager
        self.loggingProvider = loggingProvider
    }
    
    private func informListenersNotFound(url:String){
        for listener in listeners {
            listener.onNotFound(url: url)
        }
    }
    
    private func informListenersNon200(url:String, response:HTTPURLResponse){
        for listener in listeners {
            listener.onError(url: url, error: KotlinException(message: "status code: \(response.statusCode), response: \(response)"))
        }
    }
    
    private func informListenersUnexpectedError(url:String){
        for listener in listeners {
            listener.onError(url: url, error: KotlinException(message: "unexpected error"))
        }
    }
    
    private func informListeners(data:Data, url:String){
        for listener in listeners {
            listener.onReceive(url: url, imgBase64: data.base64EncodedString())
        }
    }
    
    private func makeUrl(string:String) -> URL {
        var ret: URL!
        do {
            ret = try FileManager.default.url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: false).appendingPathComponent("\(string[string.index(string.startIndex, offsetBy: 19)...])")
        }
        catch {
            loggingProvider.log(level: .debug, logTag: "ImageProvider", message: "makeUrl error: \(error)")
        }
        return ret
    }
    
    
    
    private func saveToDisk(data: Data, url: String){
        let path = makeUrl(string: url)
        do {
            try data.write(to: path, options: .atomic)
            let uData = try! Data(contentsOf: path)
            informListeners(data: uData, url: String(url))
        } catch {
            loggingProvider.log(level: .debug, logTag: "ImageProvider", message: error.localizedDescription)
            print(error.localizedDescription)
        }
    }
    
    private func getRestClosure(url:String) -> RestClosure {
        return {[self] data,response,error in
            if let uResponse = response as? HTTPURLResponse {
                if let uData = data {
                    if(uResponse.statusCode == 200) {
                        saveToDisk(data: uData, url: url)
                    }
                    else { informListenersNon200(url: url, response: uResponse)}
                }
                else{informListenersUnexpectedError(url: url)}
            }
            else{informListenersUnexpectedError(url: url)}
        }
    }
    
    public func get(url: String) {
        do{
            informListeners(data: try Data(contentsOf: makeUrl(string: url)), url: url)
        }
        catch {
            informListenersNotFound(url: url)
            loggingProvider.log(level: .debug, logTag: "ImageProvider", message: "get(url) error: \(error)")
            if let uRL = URL(string: url) {
                loggingProvider.log(level: .debug, logTag: "ImageProvider", message: "\(url) not on disk")
                restManager.dataTask(with: URLRequest(url: uRL), completionHandler: getRestClosure(url:url)).resume()
            }
            
        }
    }
    
    public func removeListener(imgListener: IImageProviderListener) {
        listeners.removeAll(where: {listener in return imgListener === listener})
    }
    
    public func addListener(imgListener: IImageProviderListener) {
        listeners.append(imgListener)
    }
}
