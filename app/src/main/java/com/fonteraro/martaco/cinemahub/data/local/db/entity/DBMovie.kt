package com.fonteraro.martaco.cinemahub.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
class DBMovie(
    @JvmField @PrimaryKey var id: Long,
    @JvmField var title: String,
    @JvmField var genre: String,
    @JvmField var poster: String,
    @JvmField var year: String,
)
