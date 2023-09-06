package com.rivskyinc.gifharborapi.data.repositoryImpl

import com.rivskyInc.gifharbor.domain.GifsRepository
import com.rivskyInc.gifharbor.domain.entity_api.Gif
import javax.inject.Inject


class GifsRepositoryImpl @Inject constructor(private val apiGIf : ApiGIf) : GifsRepository {

    override suspend fun getAllGifsList(): Gif {
        val response = apiGIf.gifResponse(null)

        if ( response.isSuccessful){
            return response.body()!!

        } else {
            throw RuntimeException(response.code().toString())

        }
    }

    override suspend fun getGifItem(gifId: String): Gif {
        val response = apiGIf.gifResponse(gifId)
        if ( response.isSuccessful){
            return response.body()!!

        } else {
            throw RuntimeException(response.code().toString())

        }
    }

    }

