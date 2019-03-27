package com.baltazar.medicinetimer.repository

import android.content.Context

/**
 * Created by Baltazar Rodriguez Ramirez on 3/26/19.
 */
interface PreferenceRepository {
    fun sayHello(): String
}

class PreferenceRepositoryImpl(private val mContext: Context): PreferenceRepository {

    override fun sayHello(): String = "Hello from repository"
}