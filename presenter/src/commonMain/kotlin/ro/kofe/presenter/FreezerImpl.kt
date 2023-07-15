package ro.kofe.presenter

expect class FreezerImpl : Freezer {
    override fun freeze(obj: Any): Any
}