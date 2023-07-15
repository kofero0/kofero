package ro.kofe.presenter

actual class FreezerImpl : Freezer {
    actual override fun freeze(obj: Any): Any {
        return obj
    }
}