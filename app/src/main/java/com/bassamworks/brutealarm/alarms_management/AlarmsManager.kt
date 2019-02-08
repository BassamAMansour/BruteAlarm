package com.bassamworks.brutealarm.alarms_management

import androidx.lifecycle.LiveData
import com.bassamworks.brutealarm.models.Alarm

class AlarmsManager(private val alarmsRepo: AlarmsRepo, private val alarmsDispatcher: AlarmsDispatcher) {

    fun getAllAlarms(): LiveData<List<Alarm>> = alarmsRepo.getAllAlarms()

    fun getAlarm(id: Long): LiveData<Alarm> = alarmsRepo.getAlarm(id)

    fun addAlarm(alarm: Alarm) = alarmsRepo.addAlarm(alarm)

    fun addAlarms(alarms: List<Alarm>) = alarmsRepo.addAlarms(alarms)

    fun updateAlarm(alarm: Alarm) = alarmsRepo.updateAlarm(alarm)

    fun updateAlarms(alarms: List<Alarm>) = alarmsRepo.updateAlarms(alarms)

    fun deleteAlarm(alarm: Alarm) = alarmsRepo.deleteAlarm(alarm)

    fun deleteAlarms(alarms: List<Alarm>) = alarmsRepo.deleteAlarms(alarms)

    fun deleteAllAlarms() = alarmsRepo.deleteAllAlarms()
}