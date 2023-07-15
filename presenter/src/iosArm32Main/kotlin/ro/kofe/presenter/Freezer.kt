package ro.kofe.presenter

import kotlin.native.concurrent.freeze

actual class Freezer : IFreezer {
    actual override fun freeze(obj: Any): Any {
        return obj.freeze()
    }
}