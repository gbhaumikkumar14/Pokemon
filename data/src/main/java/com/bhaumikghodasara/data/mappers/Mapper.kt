package com.bhaumikghodasara.data.mappers

interface Mapper<in I, out O> {
    fun mapToDomainLayer(input: I): O
}