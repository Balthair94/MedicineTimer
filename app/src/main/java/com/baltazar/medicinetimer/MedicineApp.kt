package com.baltazar.medicinetimer

import android.app.Application
import org.koin.android.ext.android.startKoin

/**
 * Created by Baltazar Rodriguez Ramirez on 3/26/19.
 */
class MedicineApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(modulePreference(this)))
    }
}