package com.bassamworks.brutealarm.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bassamworks.brutealarm.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_edit_alarm.*

class EditAlarmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_alarm)
        setSupportActionBar(toolbar_edit_alarm_activity)

        fab_confirm_alarm_changes.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
