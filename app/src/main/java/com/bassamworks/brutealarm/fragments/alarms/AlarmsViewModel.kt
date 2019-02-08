package com.bassamworks.brutealarm.fragments.alarms

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.bassamworks.brutealarm.alarms_management.AlarmsManager
import com.bassamworks.brutealarm.models.Alarm
import kotlinx.coroutines.*

class AlarmsViewModel(app: Application, private val dataSource: AlarmsManager) : AndroidViewModel
(app) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val alarms = dataSource.getAllAlarms()

    fun onAlarmToggled(alarm: Alarm, toggled: Boolean) {

        if (alarm.activated == toggled) return //Avoids useless updates

        alarm.activated = toggled

        uiScope.launch {
            withContext(Dispatchers.IO) {
                dataSource.updateAlarm(alarm)

                //TODO: Add/remove scheduledAlarms
            }

            //TODO: Add/remove alarms to the system
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}