package ro.kofe.model

data class Game(override val uid: Int, val name:String, val charIds:List<Int>, val iconUrl:String): Obj(uid) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Game) return false
        if (!super.equals(other)) return false

        if (name != other.name) return false
        if (charIds != other.charIds) return false
        if (iconUrl != other.iconUrl) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + charIds.hashCode()
        result = 31 * result + iconUrl.hashCode()
        return result
    }

    override fun toString(): String {
        return "Game(uid='$uid', name='$name', characterIds=$charIds, iconUrl='$iconUrl')"
    }
}