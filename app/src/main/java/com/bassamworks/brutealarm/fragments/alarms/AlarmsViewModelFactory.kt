package com.bassamworks.brutealarm.fragments.alarms

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bassamworks.brutealarm.alarms_management.AlarmsManager

class AlarmsViewModelFactory(private val app: Application, private val dataSource: AlarmsManager)
    : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlarmsViewModel::class.java)) {
            return AlarmsViewModel(app, dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}