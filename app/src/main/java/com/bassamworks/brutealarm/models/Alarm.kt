package com.bassamworks.brutealarm.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bassamworks.brutealarm.constatnts.Constants
import com.bassamworks.brutealarm.constatnts.Constants.Alarm.DEFAULT_ACTIVATION
import com.bassamworks.brutealarm.constatnts.Constants.Alarm.DEFAULT_HOUR
import com.bassamworks.brutealarm.constatnts.Constants.Alarm.DEFAULT_LABEL
import com.bassamworks.brutealarm.constatnts.Constants.Alarm.DEFAULT_MINUTE
import com.bassamworks.brutealarm.constatnts.Constants.Alarm.DEFAULT_OFFSET
import com.bassamworks.brutealarm.constatnts.Constants.Alarm.DEFAULT_PERIODIC
import com.bassamworks.brutealarm.constatnts.Constants.Alarm.DEFAULT_REPETITIONS
import com.bassamworks.brutealarm.constatnts.Constants.Alarm.INVALID_ID

@Entity(tableName = Constants.Database.TABLE_NAME_ALARM)
data class Alarm(@PrimaryKey(autoGenerate = true)
                 var id: Long = INVALID_ID,
                 var label: String = DEFAULT_LABEL,
                 var hour: Int = DEFAULT_HOUR,
                 var creationTime: Long = System.currentTimeMillis(),
                 var minute: Int = DEFAULT_MINUTE,
                 var repetitions: Int = DEFAULT_REPETITIONS,
                 var offset: Int = DEFAULT_OFFSET,
                 var activated: Boolean = DEFAULT_ACTIVATION,
                 var isPeriodic: Boolean = DEFAULT_PERIODIC,
                 var periods: List<DayOfWeek> = listOf())