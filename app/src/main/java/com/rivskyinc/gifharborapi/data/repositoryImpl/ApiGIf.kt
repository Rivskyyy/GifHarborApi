package com.rivskyinc.gifharborapi.data.repositoryImpl

import com.rivskyInc.gifharbor.domain.entity_api.Gif
import com.rivskyinc.gifharborapi.Utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiGIf {

        @GET("gifs/trending?api_key=$API_KEY") //  <-  put your API_KEY
        suspend fun gifResponse(
                @Query("id")
                 gif_id: String?
        ) : Response<Gif>

}