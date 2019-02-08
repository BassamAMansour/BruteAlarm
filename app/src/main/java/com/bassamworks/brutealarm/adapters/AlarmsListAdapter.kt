package com.bassamworks.brutealarm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bassamworks.brutealarm.databinding.ItemListAlarmBinding
import com.bassamworks.brutealarm.models.Alarm
import com.bassamworks.brutealarm.viewholders.AlarmViewHolder

class AlarmsListAdapter(private val itemClickListener: AlarmClickListener) :
        ListAdapter<Alarm, AlarmViewHolder>(AlarmDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder =
            AlarmViewHolder(ItemListAlarmBinding.inflate(LayoutInflater.from(parent.context),
                    parent, false), itemClickListener)

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        getItem(position)?.let { holder.bindTo(it) }
    }

}

class AlarmDiffCallback : DiffUtil.ItemCallback<Alarm>() {
    override fun areItemsTheSame(oldItem: Alarm, newItem: Alarm): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Alarm, newItem: Alarm): Boolean = oldItem == newItem
}

class AlarmClickListener(private val clickListener: (alarm: Alarm) -> Unit,
                         private val toggleListener: (alarm: Alarm, toggled: Boolean) -> Unit) {
    fun onClick(alarm: Alarm) = clickListener(alarm)
    fun onToggle(alarm: Alarm, toggled: Boolean) = toggleListener(alarm, toggled)
}