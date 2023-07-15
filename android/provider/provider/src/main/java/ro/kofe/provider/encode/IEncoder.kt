package ro.kofe.provider.encode

import com.google.gson.Gson
import ro.kofe.model.Game

interface IEncoder<I,O> {
    fun encode(value:I): O
}

