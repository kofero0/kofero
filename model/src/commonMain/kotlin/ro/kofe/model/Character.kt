package ro.kofe.model

data class Character(override val uid:Int, val name:String, val attributes:Map<String,String>, val moveIds:List<Int>, val iconUrl:String): Obj(uid) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Character) return false
        if (!super.equals(other)) return false

        if (name != other.name) return false
        if (attributes != other.attributes) return false
        if (moveIds != other.moveIds) return false
        if (iconUrl != other.iconUrl) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + attributes.hashCode()
        result = 31 * result + moveIds.hashCode()
        result = 31 * result + iconUrl.hashCode()
        return result
    }

    override fun toString(): String {
        return "Character(uid='$uid', name='$name', attributes=$attributes, moveIds=$moveIds, iconUrl='$iconUrl')"
    }

}
