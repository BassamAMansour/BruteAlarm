package com.bassamworks.brutealarm.utils

import android.annotation.SuppressLint
import android.content.Context
import com.bassamworks.brutealarm.R
import com.bassamworks.brutealarm.models.DayOfWeek
import java.text.SimpleDateFormat
import java.util.*

object TimeUtils {
    @SuppressLint("SimpleDateFormat")
    fun convertLongToHoursAndMinutes(hour: Int, minute: Int): String {
        return SimpleDateFormat("HH:mm")
                .format(Calendar.getInstance().apply {
                    set(Calendar.HOUR, hour)
                    set(Calendar.MINUTE, minute)
                }.timeInMillis)
                .toString()
    }

    fun getPeriodsText(context: Context, periods: List<DayOfWeek>): String {

        val daysStringArray = context.resources.getStringArray(R.array.days_of_week)

        return periods.asSequence().map { daysStringArray[it.position] }.joinToString(separator = ", ") { it }
    }

}

object AlarmUtils {

    fun isDaySelected(periods: List<DayOfWeek>?, dayIndex: Int): Boolean = periods?.contains(DayOfWeek.getDayFromIndex(dayIndex))
            ?: false
}
