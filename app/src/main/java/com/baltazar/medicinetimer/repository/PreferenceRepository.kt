package com.baltazar.medicinetimer.repository

import android.content.Context
import com.baltazar.medicinetimer.SharePreferenceManager

/**
 * Created by Baltazar Rodriguez Ramirez on 3/26/19.
 */
interface PreferenceRepository {
    fun sayHello(): String
}

class PreferenceRepositoryImpl(private val mContext: Context): PreferenceRepository {

    private val mPreferenceManager = SharePreferenceManager.init(mContext)

    override fun sayHello(): String {
        val timeLeft = mPreferenceManager.getTimeLeft()
        return "Time left is $timeLeft"
    }
}