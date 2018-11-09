package com.bassamworks.brutealarm.database.converters

import androidx.room.TypeConverter
import com.bassamworks.brutealarm.constatnts.Constants
import java.time.DayOfWeek

class AlarmConverter {

    private fun toDayOfWeek(dayOfWeek: String): DayOfWeek {
        return DayOfWeek.valueOf(dayOfWeek)
    }


    private fun toDay(dayOfWeek: DayOfWeek): String {
        return dayOfWeek.name
    }

    @TypeConverter
    fun toDaysOfWeek(daysOfWeek: String): List<DayOfWeek> {
        return daysOfWeek.split(Constants.Database.DAYS_SPLITTER).map { toDayOfWeek(it) }
    }

    @TypeConverter
    fun toDays(daysOfWeek: List<DayOfWeek>): String {
        return daysOfWeek.asSequence().map { toDay(it) }.joinToString(Constants.Database.DAYS_SPLITTER)
    }
}