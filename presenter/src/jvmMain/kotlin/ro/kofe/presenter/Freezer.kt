package ro.kofe.presenter

actual class Freezer : IFreezer {
    actual override fun freeze(obj: Any): Any {
        return obj
    }
}