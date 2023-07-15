package ro.kofe.provider.map

import com.google.gson.Gson
import ro.kofe.model.Game
import ro.kofe.provider.encode.IEncoder


interface IMapper<I,O> {
    fun mapIO(data:I): O
    fun mapOI(data:O): I
}
