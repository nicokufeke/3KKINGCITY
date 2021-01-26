package cl.eme.a3kkingcapital.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TrekkingSantiagoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(trekking: List<TrekkingSantiago>)

    @Query("SELECT * FROM trekking")
    fun getTrekking(): LiveData<List<TrekkingSantiago>>
}

    @Database(entities = [TrekkingSantiago::class], version = 1)
        abstract class TrekkingSantiagoDataBase : RoomDatabase() {
            abstract fun trekkingSantiagoDao(): TrekkingSantiagoDao
    }

        class TrekkingSantiagoApplication : Application() {
            companion object {
                var trekkingSantiagoDataBase: TrekkingSantiagoDataBase? = null

            }
            override fun onCreate() {
                super.onCreate()
                trekkingSantiagoDataBase = Room.databaseBuilder(this, TrekkingSantiagoDataBase::class.java,"Trekking_DataBase").build()
            }


        }





