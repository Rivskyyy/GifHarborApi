package com.rivskyinc.gifharborapi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rivskyInc.gifharbor.domain.GetGifsUseCase
import javax.inject.Inject


 class MainViewModelFactory  @Inject constructor(private val getGifsUseCase : GetGifsUseCase)
    : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if ( modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(getGifsUseCase) as T
        }
        throw RuntimeException("Unknown View Model class $modelClass")

    }


}