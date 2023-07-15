package ro.kofe.presenter

expect class Freezer : IFreezer {
    override fun freeze(obj: Any): Any
}