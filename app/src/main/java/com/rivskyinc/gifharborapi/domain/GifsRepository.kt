package com.rivskyInc.gifharbor.domain

import com.rivskyInc.gifharbor.domain.entity_api.Gif
import retrofit2.Response


interface GifsRepository {


    suspend fun getAllGifsList() : Gif

    suspend fun getGifItem(gifId : String ) : Gif

}