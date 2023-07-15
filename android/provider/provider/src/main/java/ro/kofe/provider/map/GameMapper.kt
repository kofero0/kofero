package ro.kofe.provider.map

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ro.kofe.model.Game
import ro.kofe.provider.encode.IEncoder
import java.nio.charset.Charset


class GameMapper(private val gson: Gson): IMapper<List<Game>, ByteArray> {
    private val typeToken = object : TypeToken<ArrayList<Game>>() {}.type

    override fun mapIO(data: List<Game>): ByteArray {
        return gson.toJson(data).toByteArray(Charset.defaultCharset())
    }

    override fun mapOI(data: ByteArray): List<Game> {
        return gson.fromJson(String(data, Charset.defaultCharset()),typeToken)
    }
}