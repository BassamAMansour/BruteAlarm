package com.bassamworks.brutealarm.database.alarms

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bassamworks.brutealarm.constatnts.Constants
import com.bassamworks.brutealarm.database.converters.AlarmConverter
import com.bassamworks.brutealarm.models.Alarm
import com.bassamworks.brutealarm.models.ScheduledAlarm

@Database(entities = [Alarm::class, ScheduledAlarm::class], version = 1)
@TypeConverters(AlarmConverter::class)
abstract class AlarmsDB : RoomDatabase() {

    abstract fun alarmsDao(): AlarmsDAO

    abstract fun scheduledAlarmsDAO(): ScheduledAlarmsDAO

    companion object {
        @Volatile
        private var INSTANCE: AlarmsDB? = null

        fun getInstance(context: Context): AlarmsDB =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context): AlarmsDB =
                Room.databaseBuilder(context.applicationContext,
                        AlarmsDB::class.java,
                        Constants.Database.DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
    }
}