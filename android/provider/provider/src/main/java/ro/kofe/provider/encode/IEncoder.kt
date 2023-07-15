package ro.kofe.provider.encode

interface IEncoder<Input,Output> {
    fun encode(value:Input): Output
}

