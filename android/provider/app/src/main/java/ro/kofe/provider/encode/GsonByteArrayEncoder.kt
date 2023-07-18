package ro.kofe.provider.encode

import com.google.gson.Gson

class GsonByteArrayEncoder(private val gson: Gson): IEncoder<Any,ByteArray> {
    override fun encode(value: Any): ByteArray {
        return gson.toJson(value).toByteArray()
    }
}