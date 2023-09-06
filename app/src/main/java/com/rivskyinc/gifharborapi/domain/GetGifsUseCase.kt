package com.rivskyInc.gifharbor.domain

import com.rivskyInc.gifharbor.domain.entity_api.Gif
import javax.inject.Inject

class GetGifsUseCase  @Inject constructor(private val gifRepository : GifsRepository) {

    suspend fun invoke(): Gif {
        return gifRepository.getAllGifsList()
    }

}