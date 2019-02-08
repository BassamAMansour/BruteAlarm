package com.bassamworks.brutealarm.constatnts

object Constants {
    object Alarm {
        const val DEFAULT_ACTIVATION = false
        const val INVALID_ID = 0L
        const val DEFAULT_LABEL: String = ""
        const val DEFAULT_REPETITIONS: Int = 1
        const val DEFAULT_OFFSET: Int = 1
        const val DEFAULT_HOUR = 0
        const val DEFAULT_MINUTE = 0
        const val DEFAULT_RINGTONE_URI: String = ""
        const val DEFAULT_VIBRATION: Boolean = false
        const val DEFAULT_SNOOZE_DURATION: Long = 0
        const val DEFAULT_PERIODIC: Boolean = false

        const val NUMBER_OF_DAYS = 7
    }

    object Database {
        const val DB_NAME: String = "db_alarms"
        const val TABLE_NAME_ALARM = "alarm"
        const val TABLE_NAME_SCHEDULED_ALARM = "scheduled_alarm"

        const val COLUMN_ID = "id"

        const val DAYS_SPLITTER: String = ","

        object ScheduledAlarms {
            const val COLUMN_PARENT_ID = "parentId"
            const val COLUMN_ALARM_TIME = "alarmTime"
        }
    }
}