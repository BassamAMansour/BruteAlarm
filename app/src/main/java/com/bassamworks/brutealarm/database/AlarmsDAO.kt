package com.bassamworks.brutealarm.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bassamworks.brutealarm.constatnts.Constants
import com.bassamworks.brutealarm.models.Alarm

@Dao
interface AlarmsDAO {

    @Query("SELECT * FROM ${Constants.Database.TABLE_NAME_ALARM}")
    fun getAllAlarms(): LiveData<List<Alarm>>

    @Query("SELECT * FROM ${Constants.Database.TABLE_NAME_ALARM} WHERE id = :id")
    fun getAlarm(id: Long): LiveData<Alarm>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAlarm(alarm: Alarm)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAlarms(alarms: List<Alarm>)
}