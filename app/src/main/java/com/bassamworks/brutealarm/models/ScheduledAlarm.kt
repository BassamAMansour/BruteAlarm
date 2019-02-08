package com.bassamworks.brutealarm.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.bassamworks.brutealarm.constatnts.Constants
import com.bassamworks.brutealarm.constatnts.Constants.Database.ScheduledAlarms.COLUMN_ALARM_TIME
import com.bassamworks.brutealarm.constatnts.Constants.Database.ScheduledAlarms.COLUMN_PARENT_ID

@Entity(tableName = Constants.Database.TABLE_NAME_SCHEDULED_ALARM,
        foreignKeys = [ForeignKey(entity = Alarm::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf(COLUMN_PARENT_ID),
                onDelete = ForeignKey.CASCADE)])

data class ScheduledAlarm(@PrimaryKey(autoGenerate = true)
                          var id: Long,
                          @ColumnInfo(name = COLUMN_PARENT_ID)
                          var parentId: Long,
                          @ColumnInfo(name = COLUMN_ALARM_TIME)
                          var alarmTime: Long = System.currentTimeMillis())