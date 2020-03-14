package com.pavlozin.aactemplate.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "main")
data class MainModel(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                     val string: String)