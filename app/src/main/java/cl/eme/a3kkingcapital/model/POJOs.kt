package cl.eme.a3kkingcapital.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// POJOs

@Entity(tableName = "trekking")

data class TrekkingSantiago(
    @PrimaryKey val id: Int,
    val name: String,
    val location: String,
    val distance: String,
    val difficulty: String,
    val image: String)