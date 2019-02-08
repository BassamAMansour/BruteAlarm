package com.bassamworks.brutealarm.alarms_management

import android.app.Application
import androidx.lifecycle.LiveData
import com.bassamworks.brutealarm.database.alarms.AlarmsDAO
import com.bassamworks.brutealarm.database.alarms.AlarmsDB
import com.bassamworks.brutealarm.database.alarms.ScheduledAlarmsDAO
import com.bassamworks.brutealarm.models.Alarm
import com.bassamworks.brutealarm.models.ScheduledAlarm

class AlarmsRepo(private val app: Application) {

    private val alarmsDao: AlarmsDAO by lazy { AlarmsDB.getInstance(app).alarmsDao() }
    private val scheduledAlarmsDAO: ScheduledAlarmsDAO by lazy { AlarmsDB.getInstance(app).scheduledAlarmsDAO() }

    fun getAllAlarms(): LiveData<List<Alarm>> = alarmsDao.getAllAlarms()

    fun getAlarm(id: Long): LiveData<Alarm> = alarmsDao.getAlarm(id)

    fun addAlarm(alarm: Alarm) = alarmsDao.addAlarm(alarm)

    fun addAlarms(alarms: List<Alarm>) = alarmsDao.addAlarms(alarms)

    fun updateAlarm(alarm: Alarm) = alarmsDao.updateAlarm(alarm)

    fun updateAlarms(alarms: List<Alarm>) = alarmsDao.updateAlarms(alarms)

    fun deleteAlarm(alarm: Alarm) = alarmsDao.deleteAlarm(alarm)

    fun deleteAlarms(alarms: List<Alarm>) = alarmsDao.deleteAlarms(alarms)

    fun deleteAllAlarms() = alarmsDao.deleteAllAlarms()

    private fun getAllScheduledAlarms(): LiveData<List<ScheduledAlarm>> = scheduledAlarmsDAO
            .getAllScheduledAlarms()

    private fun getScheduledAlarm(id: Long): LiveData<ScheduledAlarm> = scheduledAlarmsDAO
            .getScheduledAlarm(id)

    private fun addScheduledAlarm(alarm: ScheduledAlarm) = scheduledAlarmsDAO.addScheduledAlarm(alarm)

    private fun addScheduledAlarms(alarms: List<ScheduledAlarm>) = scheduledAlarmsDAO
            .addScheduledAlarms(alarms)

    private fun updateScheduledAlarm(alarm: ScheduledAlarm) = scheduledAlarmsDAO
            .updateScheduledAlarm(alarm)

    private fun updateScheduledAlarms(alarms: List<ScheduledAlarm>) = scheduledAlarmsDAO
            .updateScheduledAlarms(alarms)

    private fun deleteScheduledAlarm(alarm: ScheduledAlarm) = scheduledAlarmsDAO
            .deleteScheduledAlarm(alarm)

    private fun deleteScheduledAlarms(alarms: List<ScheduledAlarm>) = scheduledAlarmsDAO
            .deleteScheduledAlarms(alarms)

    private fun deleteAllScheduledAlarms() = scheduledAlarmsDAO.deleteAllScheduledAlarms()

}