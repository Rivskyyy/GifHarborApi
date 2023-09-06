package com.rivskyinc.gifharborapi.data.repositoryImpl

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.core.content.ContextCompat.getSystemService
import com.rivskyinc.gifharborapi.domain.GifsRepository
import com.rivskyinc.gifharborapi.domain.pojo.Gif
import retrofit2.Response
import javax.inject.Inject


class GifsRepositoryImpl @Inject constructor(private val apiGIf : ApiGIf) : GifsRepository {



    override suspend fun getAllGifsList(): Gif? {
        try {
            val response: Response<Gif?> = apiGIf.gifResponse()

            if (response.isSuccessful) {
                return response.body() ?: throw RuntimeException("Response body is null")
            } else {
//                throw RuntimeException("HTTP Error: ${response.code()}")
                return null
            }
        } catch (e: Exception) {
//            throw RuntimeException("Request Error: ${e.message}")
            return null
        }
    }


}




