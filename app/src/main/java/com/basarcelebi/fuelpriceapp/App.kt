package com.basarcelebi.fuelpriceapp

import android.app.Application
import com.basarcelebi.fuelpriceapp.network.Api
import com.basarcelebi.fuelpriceapp.network.HeaderInterceptor
import com.basarcelebi.fuelpriceapp.repositories.FuelRepo
import com.basarcelebi.fuelpriceapp.repositories.FuelRepoImpl
import okhttp3.OkHttpClient
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(module {
                single {
                    val client = OkHttpClient.Builder()
                        .addInterceptor(HeaderInterceptor())
                        .build()
                    Retrofit
                        .Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .baseUrl(" ... ... ... ... ... ...")
                        .build()
                }
                single {
                    val retrofit:Retrofit=get()
                    retrofit.create(Api::class.java)
                }
                single {
                    val api:Api = get()
                    FuelRepoImpl(api)
                } bind FuelRepo::class
            })
        }
    }
}