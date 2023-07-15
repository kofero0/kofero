package ro.kofe.model

open class Obj(open val uid:Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Obj) return false

        if (uid != other.uid) return false

        return true
    }

    override fun hashCode(): Int {
        return uid
    }

    override fun toString(): String {
        return "Obj(uid=$uid)"
    }
}
