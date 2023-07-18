package ro.kofe.provider.map

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ro.kofe.model.Game
import java.nio.charset.Charset


class GameMapper(private val gson: Gson): Mapper<List<Game>, ByteArray> {
    private val typeToken = object : TypeToken<ArrayList<Game>>() {}.type

    override fun mapRight(data: List<Game>): ByteArray {
        return gson.toJson(data).toByteArray(Charset.defaultCharset())
    }

    override fun mapLeft(data: ByteArray): List<Game> {
        return gson.fromJson(String(data, Charset.defaultCharset()),typeToken)
    }
}