package ro.kofe.provider.map

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ro.kofe.model.Character
import java.nio.charset.Charset


class CharacterMapper(private val gson: Gson): Mapper<List<Character>, ByteArray> {
    private val typeToken = object : TypeToken<ArrayList<Character>>() {}.type

    override fun mapRight(data: List<Character>): ByteArray {
        return gson.toJson(data).toByteArray(Charset.defaultCharset())
    }

    override fun mapLeft(data: ByteArray): List<Character> {
        return gson.fromJson(String(data, Charset.defaultCharset()),typeToken)
    }
}