package com.bassamworks.brutealarm.fragments.alarms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bassamworks.brutealarm.adapters.AlarmClickListener
import com.bassamworks.brutealarm.adapters.AlarmsListAdapter
import com.bassamworks.brutealarm.alarms_management.Injector
import com.bassamworks.brutealarm.constatnts.Constants.Alarm.INVALID_ID
import com.bassamworks.brutealarm.databinding.FragmentAlarmsBinding
import com.bassamworks.brutealarm.models.Alarm
import kotlinx.android.synthetic.main.fragment_alarms.*

class AlarmsFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var binding: FragmentAlarmsBinding
    private lateinit var model: AlarmsViewModel

    private val alarmsAdapter: AlarmsListAdapter by lazy {
        AlarmsListAdapter(AlarmClickListener({ onAlarmSelected(it.id) },
                { alarm: Alarm, toggled: Boolean -> model.onAlarmToggled(alarm, toggled) }))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModelFactory = AlarmsViewModelFactory(this.activity!!.application,
                Injector.provideAlarmsManager(this.activity!!.application))

        model = ViewModelProviders.of(this, viewModelFactory).get(AlarmsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentAlarmsBinding.inflate(inflater, container, false)

        binding.rvUserAlarms.adapter = alarmsAdapter

        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        model.alarms.observe(this, Observer { alarmsAdapter.submitList(it) })

        fab_add_alarm.setOnClickListener {
            navController.navigate(AlarmsFragmentDirections
                    .actionAlarmsFragmentToEditAlarmFragment(INVALID_ID))
        }

        rv_user_alarms.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && fab_add_alarm.visibility == View.VISIBLE) {
                    fab_add_alarm.hide()
                } else if (dy < 0 && fab_add_alarm.visibility != View.VISIBLE) {
                    fab_add_alarm.show()
                }
            }
        })
    }

    private fun onAlarmSelected(id: Long) {
        navController.navigate(AlarmsFragmentDirections.actionAlarmsFragmentToEditAlarmFragment(id))
    }
}