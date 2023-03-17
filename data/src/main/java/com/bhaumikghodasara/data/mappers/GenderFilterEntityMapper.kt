package com.bhaumikghodasara.data.mappers

import com.bhaumikghodasara.data.models.GenderFilterApiResponse
import com.bhaumikghodasara.domain.entities.GenderFilterData

class GenderFilterEntityMapper: Mapper<GenderFilterApiResponse, GenderFilterData> {
    override fun mapToDomainLayer(input: GenderFilterApiResponse): GenderFilterData {
        return GenderFilterData(
            genderResult = input.results.map { genderResults -> genderResults.name }
        )
    }
}