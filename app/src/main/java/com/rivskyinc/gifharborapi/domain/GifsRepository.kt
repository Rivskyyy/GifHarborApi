package com.rivskyInc.gifharbor.domain


import com.rivskyInc.gifharbor.domain.entity_api.Gif

interface GifsRepository {


    suspend fun getAllGifsList() : Gif

//    suspend fun getGifItem(gifId : String ) : Gif

}