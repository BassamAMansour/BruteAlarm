package com.bassamworks.brutealarm.fragments.edit_alarms

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.bassamworks.brutealarm.alarms_management.AlarmsManager
import com.bassamworks.brutealarm.constatnts.Constants.Alarm.INVALID_ID
import com.bassamworks.brutealarm.models.Alarm
import com.bassamworks.brutealarm.models.DayOfWeek
import kotlinx.coroutines.*
import java.util.*

class EditAlarmViewModel(app: Application, private val alarmId: Long, private val dataSource: AlarmsManager) :
        AndroidViewModel(app) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _alarm: MediatorLiveData<Alarm> = MediatorLiveData()
    private val _finishedAlarmEditing: MutableLiveData<Boolean> = MutableLiveData()

    val alarm: LiveData<Alarm>
        get() = _alarm
    val finishedAlarmEditing: LiveData<Boolean>
        get() = _finishedAlarmEditing

    init {
        _alarm.value = Alarm()

        if (alarmId != INVALID_ID) {
            _alarm.addSource(dataSource.getAlarm(alarmId), _alarm::setValue)
        }
    }

    fun setSelectedTime(selectedHour: Int, selectedMinute: Int) {
        _alarm.value?.apply {
            hour = selectedHour
            minute = selectedMinute
        }
    }

    fun onPeriodicDaySelected(dayPosition: Int, checked: Boolean) {
        val day = DayOfWeek.getDayFromIndex(dayPosition)
        val selectedDays = LinkedList(_alarm.value?.periods ?: linkedSetOf())

        if (checked) {
            if (!selectedDays.contains(day)) selectedDays.add(day)
        } else {
            selectedDays.remove(day)
        }

        _alarm.value?.isPeriodic = selectedDays.isNotEmpty()
        _alarm.value?.periods = selectedDays
    }

    fun setLabel(label: String?): Boolean {
        label?.let {
            if (label.matches("^\\d+$".toRegex())) return false

            _alarm.value?.label = label
        }
        return true
    }

    fun setRepetitions(repetitions: Int?): Boolean {
        repetitions?.let {
            if (it <= 0) return false

            _alarm.value?.repetitions = it
        }
        return true
    }

    fun setOffset(offset: Int?): Boolean {

        offset?.let {
            if (it <= 0) return false

            _alarm.value?.offset = it
        }

        return true
    }

    fun confirmEditedAlarm() {

        val alarm = _alarm.value!!
        alarm.activated = true

        uiScope.launch {
            withContext(Dispatchers.IO) {
                if (alarmId == INVALID_ID) {
                    dataSource.addAlarm(alarm)
                } else {
                    dataSource.updateAlarm(alarm)
                }

                _finishedAlarmEditing.postValue(true)
            }
        }
    }

    fun doneNavigatingUp() {
        _finishedAlarmEditing.value = false
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}