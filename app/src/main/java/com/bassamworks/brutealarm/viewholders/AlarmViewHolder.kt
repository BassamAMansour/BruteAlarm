package com.bassamworks.brutealarm.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bassamworks.brutealarm.adapters.AlarmClickListener
import com.bassamworks.brutealarm.databinding.ItemListAlarmBinding
import com.bassamworks.brutealarm.models.Alarm

class AlarmViewHolder(private val binding: ItemListAlarmBinding, private val listener: AlarmClickListener)
    : RecyclerView.ViewHolder(binding.root) {

    fun bindTo(newAlarm: Alarm) {
        binding.apply {
            alarm = newAlarm
            clickListener = listener

            executePendingBindings()
        }
    }
}