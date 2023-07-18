package ro.kofe.provider.map

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ro.kofe.model.Move
import java.nio.charset.Charset


class MoveMapper(private val gson: Gson): Mapper<List<Move>, ByteArray> {
    private val typeToken = object : TypeToken<ArrayList<Move>>() {}.type

    override fun mapRight(data: List<Move>): ByteArray {
        return gson.toJson(data).toByteArray(Charset.defaultCharset())
    }

    override fun mapLeft(data: ByteArray): List<Move> {
        return gson.fromJson<ArrayList<Move>>(String(data, Charset.defaultCharset()),typeToken)
    }
}