package cl.eme.a3kkingcapital.model

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TrekkingAPI {
    @GET("PlacesHill")
    suspend fun getTrekking() : Response<List<TrekkingSantiago>>
}

// Cliente Retrofit
const val BASE_URL = "https://my-json-server.typicode.com/nicokufeke/3KKINGCAPITAL/"
class RetrofitClient {
    companion object {

        fun instance() : TrekkingAPI{
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).build()

            return retrofit.create(TrekkingAPI::class.java)

        }
    }

}


