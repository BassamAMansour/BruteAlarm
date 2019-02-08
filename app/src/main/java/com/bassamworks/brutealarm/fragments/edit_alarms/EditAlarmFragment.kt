package com.bassamworks.brutealarm.fragments.edit_alarms

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.bassamworks.brutealarm.R
import com.bassamworks.brutealarm.alarms_management.Injector
import com.bassamworks.brutealarm.databinding.FragmentEditAlarmBinding
import com.bassamworks.brutealarm.extentions.showToast
import com.bassamworks.brutealarm.models.Alarm
import kotlinx.android.synthetic.main.content_edit_alarm.*
import kotlinx.android.synthetic.main.fragment_edit_alarm.*


class EditAlarmFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var binding: FragmentEditAlarmBinding
    private lateinit var model: EditAlarmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val alarmId = EditAlarmFragmentArgs.fromBundle(arguments!!).alarmId

        val viewModelFactory = EditAlarmViewModelFactory(this.activity!!.application, alarmId,
                Injector.provideAlarmsManager(this.activity!!.application))

        model = ViewModelProviders.of(this, viewModelFactory).get(EditAlarmViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentEditAlarmBinding.inflate(inflater, container, false)
        binding.editAlarmModel = model
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        model.finishedAlarmEditing.observe(this, androidx.lifecycle.Observer {
            if (it == true) {

                showToast(getString(R.string.successfully_activated), Toast.LENGTH_SHORT)

                navController.navigate(EditAlarmFragmentDirections.actionEditAlarmFragmentToAlarmsFragment())
                model.doneNavigatingUp()
            }
        })

        initViews()

        populateViews()
    }

    private fun initViews() {
        btn_select_time.setOnClickListener { model.alarm.value?.let { getTimePicker(it.hour, it.minute).show() } }

        fab_confirm_alarm_changes.setOnClickListener { confirmEditedAlarm() }
    }

    private fun populateViews() {
        model.alarm.observe(this, androidx.lifecycle.Observer {
            updateNumberCounters(it)
        })
    }

    private fun confirmEditedAlarm() {

        model.apply {
            val validLabel = setLabel(et_alarm_label.text.toString())
            setRepetitions(nb_repetitions_counter.number.toInt())
            setOffset(nb_offset_counter.number.toInt())

            if (!validLabel) {
                et_alarm_label.error = getString(R.string.invalid_label)
            } else {
                this.confirmEditedAlarm()
            }
        }
    }

    private fun getTimePicker(hour: Int, minute: Int): TimePickerDialog {
        val timePicker = TimePickerDialog(
                context,
                { _, selectedHour, selectedMinute -> model.setSelectedTime(selectedHour, selectedMinute) },
                hour, minute, true)

        timePicker.setTitle(context?.getString(R.string.select_alarm_time))

        return timePicker
    }

    private fun updateNumberCounters(alarm: Alarm) {
        nb_offset_counter.number = alarm.offset.toString()
        nb_repetitions_counter.number = alarm.repetitions.toString()
    }

}