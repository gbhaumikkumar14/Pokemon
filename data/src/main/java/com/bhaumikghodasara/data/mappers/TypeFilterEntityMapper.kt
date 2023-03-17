package com.bhaumikghodasara.data.mappers

import com.bhaumikghodasara.data.models.TypeFilterApiResponse
import com.bhaumikghodasara.domain.entities.TypeFilterData

class TypeFilterEntityMapper: Mapper<TypeFilterApiResponse, TypeFilterData> {
    override fun mapToDomainLayer(input: TypeFilterApiResponse): TypeFilterData {
        return TypeFilterData(
            typeFilters = input.results.map { filterResults -> filterResults.name}
        )
    }
}