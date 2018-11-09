package com.bassamworks.brutealarm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bassamworks.brutealarm.constatnts.Constants
import com.bassamworks.brutealarm.database.converters.AlarmConverter
import com.bassamworks.brutealarm.models.Alarm

@Database(entities = [Alarm::class], version = 1)
@TypeConverters(AlarmConverter::class)
abstract class AlarmsDatabase : RoomDatabase() {

    abstract fun alarmsDao(): AlarmsDAO

    companion object {
        @Volatile
        private var INSTANCE: AlarmsDatabase? = null

        fun getInstance(context: Context): AlarmsDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }


        private fun buildDatabase(context: Context): AlarmsDatabase =
                Room.databaseBuilder(context.applicationContext,
                        AlarmsDatabase::class.java,
                        Constants.Database.DB_NAME)
                        .build()
    }
}