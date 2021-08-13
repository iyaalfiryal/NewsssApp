package com.iyaliyul.newsssapp.data.repository

import com.iyaliyul.newsssapp.data.model.NewsResponse
import com.iyaliyul.newsssapp.data.source.APIService
import com.iyaliyul.newsssapp.utils.Constant
import com.iyaliyul.newsssapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: APIService){

    suspend fun fetchNews(): Flow<Resource<NewsResponse>>{
        return flow {

            val source = "id"
            val apikey = Constant.API_KEY
            val response = apiService.fetchNews(source = source, apikey = apikey)

            try {
                if(response.articles.isNotEmpty()){
                    emit(Resource.Success(response))
                }else{
                    emit(Resource.Empty)
                }
            }catch (e: HttpException){
                emit(Resource.Error(e.toString(), response))
            }

        }
    }

}