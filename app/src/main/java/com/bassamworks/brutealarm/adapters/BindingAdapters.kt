package com.bassamworks.brutealarm.adapters

import android.widget.TextView
import android.widget.ToggleButton
import androidx.databinding.BindingAdapter
import com.bassamworks.brutealarm.models.Alarm
import com.bassamworks.brutealarm.models.DayOfWeek
import com.bassamworks.brutealarm.utils.AlarmUtils
import com.bassamworks.brutealarm.utils.TimeUtils

@BindingAdapter("time")
fun TextView.setTime(alarm: Alarm) {
    this.text = TimeUtils.convertLongToHoursAndMinutes(alarm.hour, alarm.minute)
}

@BindingAdapter("periods")
fun TextView.setPeriods(periods: List<DayOfWeek>) {
    this.text = TimeUtils.getPeriodsText(context, periods)
}

@BindingAdapter(*["bind:periods", "bind:dayIndex"])
fun ToggleButton.setChecked(periods: List<DayOfWeek>?, dayIndex: Int) {
    this.isChecked = AlarmUtils.isDaySelected(periods, dayIndex)
}