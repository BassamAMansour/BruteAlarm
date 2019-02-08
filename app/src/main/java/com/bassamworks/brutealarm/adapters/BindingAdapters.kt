package com.bassamworks.brutealarm.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bassamworks.brutealarm.models.Alarm
import com.bassamworks.brutealarm.models.DayOfWeek
import com.bassamworks.brutealarm.utils.TimeUtils

@BindingAdapter("time")
fun TextView.setTime(alarm: Alarm) {
    this.text = TimeUtils.convertLongToHoursAndMinutes(alarm.hour, alarm.minute)
}

@BindingAdapter("periods")
fun TextView.setPeriods(periods: List<DayOfWeek>) {
    this.text = TimeUtils.getPeriodsText(context, periods)
}