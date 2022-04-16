package com.example.yana.fakername.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.yana.fakername.dataClass.Countries

@Database(entities = [Countries::class], version = 1)
abstract class FakerAppDataBase: RoomDatabase() {
    abstract fun getFakerDao(): FakerNameDao
}