package com.rivskyinc.gifharborapi.domain

import com.rivskyinc.gifharborapi.domain.pojo.Gif
import javax.inject.Inject

class GetGifsUseCase @Inject constructor(private val gifRepository: GifsRepository) {

    suspend fun invoke(): Gif? {
        return gifRepository.getAllGifsList()
    }

}