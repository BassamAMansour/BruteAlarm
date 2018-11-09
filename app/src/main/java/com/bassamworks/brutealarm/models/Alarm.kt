package com.bassamworks.brutealarm.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bassamworks.brutealarm.constatnts.Constants
import java.time.DayOfWeek

@Entity(tableName = Constants.Database.TABLE_NAME_ALARM)
data class Alarm(@PrimaryKey(autoGenerate = true)
                 val id: Long,
                 val parentId: Long,
                 val label: String,
                 val startTimeUNIX: Long,
                 val repetitions: Int,
                 val offset: Long,
                 val activated: Boolean,
                 val ringtoneUri: String,
                 val vibrate: Boolean,
                 val snoozeDuration: Long,
                 val isPeriodic: Boolean,
                 val periods: List<DayOfWeek>)