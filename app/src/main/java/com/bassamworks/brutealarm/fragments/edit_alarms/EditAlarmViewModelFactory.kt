package com.bassamworks.brutealarm.fragments.edit_alarms

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bassamworks.brutealarm.alarms_management.AlarmsManager

class EditAlarmViewModelFactory(private val app: Application, private val alarmId: Long, private
val dataSource: AlarmsManager)
    : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditAlarmViewModel::class.java)) {
            return EditAlarmViewModel(app, alarmId, dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}