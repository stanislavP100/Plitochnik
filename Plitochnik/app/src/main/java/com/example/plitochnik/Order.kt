package com.example.plitochnik

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Order(

 @ColumnInfo
 val personPhone :String?,

 @ColumnInfo
 val personName :String?

) {


 @PrimaryKey(autoGenerate = true)
 @ColumnInfo(name = "id")
private val id: Int? = null


}