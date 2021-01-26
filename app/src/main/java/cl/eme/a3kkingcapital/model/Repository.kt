package cl.eme.a3kkingcapital.model

import timber.log.Timber

class Repository {
    private val trekkingDataBase = TrekkingSantiagoApplication.trekkingSantiagoDataBase!!
    val trekkings = trekkingDataBase.trekkingSantiagoDao().getTrekking()

    suspend fun getTrekkingRoutes() {
        val response = RetrofitClient.instance().getTrekking()
        if (response.isSuccessful) {
            response.body()?.let {
                trekkingDataBase.trekkingSantiagoDao().insert(it)
            } }
        else {
                Timber.d("${response.errorBody()}")
            }
        }

    }

