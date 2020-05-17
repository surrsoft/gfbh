package ru.surrsoft.gfbh.internet.TRetrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * //needdesc
 * <p>
 * //new//
 */
object TRetrofit {
    /**
     * Return Retrofit configurate variant.
     * For get result as String
     */
    fun build(baseURL: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }
    
    /**
     * Return Retrofit configurate variant.
     * For convert result to "Object" through JSON
     */
    fun buildB(baseURL: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }
  
  
}