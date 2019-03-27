package com.baltazar.medicinetimer

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by Baltazar Rodriguez Ramirez on 3/26/19.
 */
class SharePreferenceManager {

    private lateinit var mPreferences: SharedPreferences

    fun saveSeconds(seconds: Long) {
        mPreferences.edit().apply {
            putLong(TIME_IN_MINUTES, seconds)
        }.apply()
    }

    fun saveTimeToReduce(seconds: Long) {
        mPreferences.edit().apply {
            putLong(TIME_TO_REDUCE, seconds)
        }.apply()
    }

    fun saveWorkerLastExecution(time: Long) {
        mPreferences.edit().apply {
            putLong(TIME_WORK_LAST_EXECUTION, time)
        }.apply()
    }

    fun getTimeLeft() = mPreferences.getLong(TIME_IN_MINUTES, 0)

    fun getWorkerLastExecution() = mPreferences.getLong(TIME_WORK_LAST_EXECUTION, 0)

    fun getTimeToReduce() = mPreferences.getLong(TIME_TO_REDUCE, 0)

    fun removeSeconds(seconds: Long) {
        val timeLeft = getTimeLeft().minus(seconds)
        saveSeconds(timeLeft)
    }

    fun cleanPreferences() {
        mPreferences.edit().clear().apply()
    }

    companion object {

        const val TIME_IN_MINUTES = "time_in_minutes"
        const val TIME_TO_REDUCE = "time_to_reduce"
        const val TIME_WORK_LAST_EXECUTION = "time_work_last_execution"

        fun init(context: Context): SharePreferenceManager {
            val manager = SharePreferenceManager()
            manager.mPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return manager
        }
    }
}