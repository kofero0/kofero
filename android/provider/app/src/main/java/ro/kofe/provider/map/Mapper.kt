package ro.kofe.provider.map


interface Mapper<Left,Right> {
    fun mapRight(data:Left): Right
    fun mapLeft(data:Right): Left
}
