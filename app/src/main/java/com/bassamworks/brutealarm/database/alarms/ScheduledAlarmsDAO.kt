package com.bassamworks.brutealarm.database.alarms

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bassamworks.brutealarm.constatnts.Constants.Database.COLUMN_ID
import com.bassamworks.brutealarm.constatnts.Constants.Database.TABLE_NAME_SCHEDULED_ALARM
import com.bassamworks.brutealarm.models.ScheduledAlarm

@Dao
interface ScheduledAlarmsDAO {

    @Query("SELECT * FROM $TABLE_NAME_SCHEDULED_ALARM")
    fun getAllScheduledAlarms(): LiveData<List<ScheduledAlarm>>

    @Query("SELECT * FROM $TABLE_NAME_SCHEDULED_ALARM WHERE $COLUMN_ID = :id")
    fun getScheduledAlarm(id: Long): LiveData<ScheduledAlarm>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addScheduledAlarm(alarm: ScheduledAlarm)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addScheduledAlarms(alarms: List<ScheduledAlarm>)

    @Update
    fun updateScheduledAlarm(alarm: ScheduledAlarm)

    @Update
    fun updateScheduledAlarms(alarms: List<ScheduledAlarm>)

    @Delete
    fun deleteScheduledAlarm(alarm: ScheduledAlarm)

    @Delete
    fun deleteScheduledAlarms(alarms: List<ScheduledAlarm>)

    @Query("DELETE FROM $TABLE_NAME_SCHEDULED_ALARM")
    fun deleteAllScheduledAlarms()
}