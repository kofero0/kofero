package ro.kofe.model.error

sealed class ProviderError()

class FileReadError(val filePath:String): ProviderError()
class IdsNotFound(val ids:List<Int>): ProviderError()