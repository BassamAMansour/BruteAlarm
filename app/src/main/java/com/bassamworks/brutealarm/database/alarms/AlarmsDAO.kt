package com.bassamworks.brutealarm.database.alarms

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bassamworks.brutealarm.constatnts.Constants.Database.COLUMN_ID
import com.bassamworks.brutealarm.constatnts.Constants.Database.TABLE_NAME_ALARM
import com.bassamworks.brutealarm.models.Alarm

@Dao
interface AlarmsDAO {

    @Query("SELECT * FROM $TABLE_NAME_ALARM")
    fun getAllAlarms(): LiveData<List<Alarm>>

    @Query("SELECT * FROM $TABLE_NAME_ALARM WHERE $COLUMN_ID = :id")
    fun getAlarm(id: Long): LiveData<Alarm>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAlarm(alarm: Alarm)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAlarms(alarms: List<Alarm>)

    @Update
    fun updateAlarm(alarm: Alarm)

    @Update
    fun updateAlarms(alarms: List<Alarm>)

    @Delete
    fun deleteAlarm(alarm: Alarm)

    @Delete
    fun deleteAlarms(alarms: List<Alarm>)

    @Query("DELETE FROM $TABLE_NAME_ALARM")
    fun deleteAllAlarms()
}