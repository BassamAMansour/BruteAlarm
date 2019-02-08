package com.bassamworks.brutealarm.database.converters

import androidx.room.TypeConverter
import com.bassamworks.brutealarm.constatnts.Constants
import com.bassamworks.brutealarm.models.DayOfWeek

class AlarmConverter {

    private fun toDayOfWeek(dayOfWeek: String): DayOfWeek {
        return DayOfWeek.getDayFromIndex(dayOfWeek.toInt())
    }

    private fun toDay(dayOfWeek: DayOfWeek): String {
        return dayOfWeek.position.toString()
    }

    @TypeConverter
    fun toDaysOfWeek(daysOfWeek: String): List<DayOfWeek> {

        if (daysOfWeek.isEmpty()) return listOf()

        return daysOfWeek.split(Constants.Database.DAYS_SPLITTER)
                .map { toDayOfWeek(it) }
    }

    @TypeConverter
    fun toDays(daysOfWeek: List<DayOfWeek>): String {

        if (daysOfWeek.isEmpty()) return ""

        return daysOfWeek.sortedBy { it.position }
                .asSequence()
                .map { toDay(it) }
                .joinToString(Constants.Database.DAYS_SPLITTER)
    }
}