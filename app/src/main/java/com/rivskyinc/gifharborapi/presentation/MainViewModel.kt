package com.rivskyinc.gifharborapi.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.HttpException
import com.rivskyinc.gifharborapi.domain.GetGifsUseCase
import com.rivskyinc.gifharborapi.domain.pojo.Gif
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject


class MainViewModel @Inject constructor(private val getGifsUseCase: GetGifsUseCase) : ViewModel() {

    private var gifsList = MutableLiveData<Gif>()
    val gifsListLD: LiveData<Gif>
        get() = gifsList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getTrendingGifs()
        }
    }

    private suspend fun getTrendingGifs() {
        try {
            val data = getGifsUseCase.invoke()
            gifsList.postValue(data)
            Log.d("MainViewModel", data.toString())
        } catch (e: HttpException) {
            throw RuntimeException("Oops, something went wrong!")
        } catch (e: IOException) {
            throw RuntimeException("Couldn't reach server, check your internet connection.")
        }
    }
}