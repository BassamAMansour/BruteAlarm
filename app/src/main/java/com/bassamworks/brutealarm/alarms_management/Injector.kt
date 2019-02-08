package com.bassamworks.brutealarm.alarms_management

import android.app.Application

object Injector {

    fun provideAlarmsRepo(app: Application) = AlarmsRepo(app)

    fun provideAlarmsDispatcher() = AlarmsDispatcher()

    fun provideAlarmsManager(app: Application) = AlarmsManager(provideAlarmsRepo(app), provideAlarmsDispatcher())
}