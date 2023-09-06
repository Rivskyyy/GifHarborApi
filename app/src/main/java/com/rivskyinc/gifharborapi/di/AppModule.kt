package com.rivskyinc.gifharborapi.di

import com.rivskyInc.gifharbor.domain.GetGifsUseCase
import com.rivskyInc.gifharbor.domain.GifsRepository
import com.rivskyinc.gifharborapi.Utils.Const
import com.rivskyinc.gifharborapi.data.repositoryImpl.ApiGIf
import com.rivskyinc.gifharborapi.data.repositoryImpl.GifsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideMyApi() : ApiGIf {
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiGIf::class.java)
    }


    @Provides
    fun bindsRepository(api : ApiGIf) : GifsRepository{
        return GifsRepositoryImpl(api)
    }

    @Provides
    fun providesUseCase(repository: GifsRepository) : GetGifsUseCase {
            return GetGifsUseCase(repository)
    }





}