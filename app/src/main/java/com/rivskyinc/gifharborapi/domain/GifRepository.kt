package com.rivskyinc.gifharborapi.domain

import com.rivskyinc.gifharborapi.domain.pojo.Gif

interface GifsRepository {
    suspend fun getAllGifsList(): Gif?

}